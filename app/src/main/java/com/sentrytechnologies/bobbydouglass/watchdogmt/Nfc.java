package com.sentrytechnologies.bobbydouglass.watchdogmt;

import android.app.PendingIntent;
import android.content.Intent;
import android.content.IntentFilter;
import android.nfc.NdefMessage;
import android.nfc.NdefRecord;
import android.nfc.NfcAdapter;
import android.nfc.Tag;
import android.nfc.tech.Ndef;
import android.nfc.tech.NdefFormatable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.TextView;
import java.io.ByteArrayOutputStream;
import java.nio.ByteBuffer;
import java.util.ArrayList;

public class Nfc extends AppCompatActivity {

    NfcAdapter nfcAdapter;
    TextView info;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.nfc);

        info = (TextView) findViewById(R.id.nfc_textView);
        nfcAdapter = nfcAdapter.getDefaultAdapter(this);
        info.setText("Touch Watchdog MT to apply changes");
    }

    @Override
    public void onBackPressed() {
        startActivity(new Intent(this, Home.class));
    }

    @Override
    protected void onResume() {
        super.onResume();
        enableForegroundDispatchSystem();
    }

    @Override
    protected void onPause() {
        super.onPause();
        disableForegroundDispatchSystem();
    }

    @Override
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);

        Tag tag = intent.getParcelableExtra(NfcAdapter.EXTRA_TAG);
        NdefMessage ndefMessage = createNdefMessage();
        writeNdefMessage(tag, ndefMessage);
    }

    private void enableForegroundDispatchSystem() {
        Intent intent = new Intent(this, Nfc.class).addFlags(Intent.FLAG_RECEIVER_REPLACE_PENDING);
        PendingIntent pendingIntent = PendingIntent.getActivity(this, 0, intent, 0);
        IntentFilter[] intentFilters = new IntentFilter[]{};
        nfcAdapter.enableForegroundDispatch(this, pendingIntent, intentFilters, null);
    }

    private void disableForegroundDispatchSystem() {
        nfcAdapter.disableForegroundDispatch(this);
    }

    private void formatTag(Tag tag, NdefMessage ndefMessage) {
        try {
            NdefFormatable ndefFormatable = NdefFormatable.get(tag);
            ndefFormatable.connect();
            ndefFormatable.format(ndefMessage);
            ndefFormatable.close();
            info.setText("Changes Sent To Watchdog MT, Please Wait For Changes To Be Sent To Server Before Exiting");
            save();
        } catch (Exception e) {}
    }

    private void writeNdefMessage(Tag tag, NdefMessage ndefMessage) {
        try {
            if (tag == null) {
                info.setText("Error(1) communicating with Watchdog MT, please try again...");
                return;
            }
            Ndef ndef = Ndef.get(tag);
            if (ndef == null) {
                info.setText("Error(2) communicating with Watchdog MT, please try again...");
                formatTag(tag, ndefMessage);
            }
            else {
                ndef.connect();
                ndef.writeNdefMessage(ndefMessage);
                ndef.close();

                info.setText("Changes Sent To Watchdog MT, Please Wait For Changes To Be Sent To Server Before Exiting");
                save();
            }
        } catch (Exception e) {
            info.setText("Error(3) communicating with Watchdog MT, please try again...");
        }
    }

    private NdefMessage createNdefMessage() {
        ArrayList<NdefRecord> ndef = new ArrayList<NdefRecord>();
        if(Home.Selected == 1) {
            for (int x = 0; x < Program.SizeX; x++) {
                for (int y = 0; y < Program.SizeY; y++) {
                    if (Program.Changes_Bool[x][y]) {
                        if (Program.Changes_Type[x] == 1) {
                            ndef.add(createRecord1(Program.Changes[x][y].getAddress(), Program.Changes[x][y].getValue1()));
                        }
                        else if(Program.Changes_Type[x] == 3) {
                            ndef.add(createRecord3(Program.Changes[x][y].getAddress(), Program.Changes[x][y].getValue3()));
                        }
                    }
                }
            }
        }
        else {
            for (int x = 0; x < Program2.SizeX; x++) {
                for (int y = 0; y < Program2.SizeY; y++) {
                    if (Program2.Changes_Bool[x][y]) {
                        if (Program2.Changes_Type[x] == 1) {
                            ndef.add(createRecord1(Program2.Changes[x][y].getAddress(), Program2.Changes[x][y].getValue1()));
                        }
                        else if(Program2.Changes_Type[x] == 3) {
                            ndef.add(createRecord3(Program2.Changes[x][y].getAddress(), Program2.Changes[x][y].getValue3()));
                        }
                    }
                }
            }
        }
        NdefRecord[] ndefr = new NdefRecord[ndef.size()];
        for (int i = 0; i < ndef.size(); i++)
            ndefr[i] = ndef.get(i);
        NdefMessage ndefMessage = new NdefMessage(ndefr);

        return ndefMessage;
    }

    private NdefRecord createRecord1(int add, short val) {
        final int BYTE_SIZE = 2;
        final int BYTE_ARRAY = 11;

        ByteArrayOutputStream payload = new ByteArrayOutputStream(BYTE_ARRAY);

        payload.write('M');
        payload.write('1');
        payload.write(16);
        payload.write((byte) ((add >> 8) & 0x00ff));
        payload.write((byte) (add & 0x00ff));
        payload.write(0);
        payload.write(1);
        payload.write(BYTE_SIZE);
        payload.write((byte) ((val >> 8) & 0x00ff));
        payload.write((byte) (val & 0x00ff));

        return new NdefRecord(NdefRecord.TNF_MIME_MEDIA, NdefRecord.RTD_TEXT, null, payload.toByteArray());
    }

    private NdefRecord createRecord3(int add, float val) {
        final int BYTE_SIZE = 4;
        final int BYTE_ARRAY = 12;

        ByteArrayOutputStream payload = new ByteArrayOutputStream(BYTE_ARRAY);

        payload.write('M');
        payload.write('1');
        payload.write(16);
        payload.write((byte) ((add >> 8) & 0x00ff));
        payload.write((byte) (add & 0x00ff));
        payload.write(0);
        payload.write(1);
        payload.write(BYTE_SIZE);
        byte[] valBytes = ByteBuffer.allocate(4).putFloat(val).array();
        for (int i = 0; i < 4; i++)
            payload.write(valBytes[i]);

        return new NdefRecord(NdefRecord.TNF_MIME_MEDIA, NdefRecord.RTD_TEXT, null, payload.toByteArray());
    }

    public void save() {
        JSON json = new JSON();
        if(Home.Selected == 1) {
            for (int x = 0; x < Program.SizeX; x++) {
                for(int y = 0; y < Program.SizeY; y++) {
                    if (Program.Changes_Bool[x][y]) {
                        Program.Changes[x][y].save();
                        json.addModbus(Program.Changes[x][y]);
                    }
                }
            }
        }
        else {
            for (int x = 0; x < Program2.SizeX; x++) {
                for (int y = 0; y < Program2.SizeY; y++) {
                    if (Program2.Changes_Bool[x][y]) {
                        Program2.Changes[x][y].save();
                        json.addModbus(Program2.Changes[x][y]);
                    }
                }
            }
        }
        json.send();
    }
}