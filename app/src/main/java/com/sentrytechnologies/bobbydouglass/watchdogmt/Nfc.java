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

        info = (TextView) findViewById(R.id.textView13);
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
            info.setText("Changes Sent To Watchdog MT");
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

                info.setText("Changes Sent To Watchdog MT!");
                save();
            }
        } catch (Exception e) {
            info.setText("Error(3) communicating with Watchdog MT, please try again...");
        }
    }

    private NdefMessage createNdefMessage() {
        ArrayList<NdefRecord> ndef = new ArrayList<NdefRecord>();
        if(Home.Selected == 1) {
            for (int i = 0; i < Program.Size_1; i++) {
                if(Program.Changes_Bool_1[i]) {
                    ndef.add(createRecord(Program.Changes_1[i].getAddress(), Program.Changes_1[i].getValue1()));
                }
            }
            for (int i = 0; i < Program.Size_2; i++) {
                if(Program.Changes_Bool_2[i]) {
                    ndef.add(createRecord(Program.Changes_2[i].getAddress(), Program.Changes_2[i].getValue2()));
                }
            }
            for (int i = 0; i < Program.Size_3; i++) {
                if(Program.Changes_Bool_3[i]) {
                    ndef.add(createRecord(Program.Changes_3[i].getAddress(), Program.Changes_3[i].getValue3()));
                }
            }
            for (int i = 0; i < Program.Size_4; i++) {
                if(Program.Changes_Bool_4[i]) {
                    ndef.add(createRecord(Program.Changes_4[i].getAddress(), Program.Changes_4[i].getValue4()));
                }
            }
        }
        else {
            for (int i = 0; i < Program2.Size_1; i++) {
                if(Program2.Changes_Bool_1[i])
                    ndef.add(createRecord(Program2.Changes_1[i].getAddress(), Program2.Changes_1[i].getValue1()));
            }
            for (int i = 0; i < Program2.Size_2; i++) {
                if(Program2.Changes_Bool_2[i])
                    ndef.add(createRecord(Program2.Changes_2[i].getAddress(), Program2.Changes_2[i].getValue2()));
            }
            for (int i = 0; i < Program2.Size_3; i++) {
                if(Program2.Changes_Bool_3[i])
                    ndef.add(createRecord(Program2.Changes_3[i].getAddress(), Program2.Changes_3[i].getValue3()));
            }
            for (int i = 0; i < Program2.Size_4; i++) {
                if(Program2.Changes_Bool_4[i])
                    ndef.add(createRecord(Program2.Changes_4[i].getAddress(), Program2.Changes_4[i].getValue4()));
            }
        }
        NdefRecord[] ndefr = new NdefRecord[ndef.size()];
        for (int i = 0; i < ndef.size(); i++)
            ndefr[i] = ndef.get(i);
        NdefMessage ndefMessage = new NdefMessage(ndefr);

        return ndefMessage;
    }

    private NdefRecord createRecord(int add, int val) {
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

    private NdefRecord createRecord(int add, long val) {
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

    private NdefRecord createRecord(int add, float val) {
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

    private NdefRecord createRecord(int add, String val) {
        final int BYTE_SIZE = 16;
        final int BYTE_ARRAY = 24;

        ByteArrayOutputStream payload = new ByteArrayOutputStream(BYTE_ARRAY);

        payload.write('M');
        payload.write('1');
        payload.write(16);
        payload.write((byte) ((add >> 8) & 0x00ff));
        payload.write((byte) (add & 0x00ff));
        payload.write(0);
        payload.write(1);
        payload.write(BYTE_SIZE);
        for(int i = 0; i < 16; i++) {
            if(val.length() > i)
                payload.write(val.charAt(i));
            else
                payload.write(0);
        }

        return new NdefRecord(NdefRecord.TNF_MIME_MEDIA, NdefRecord.RTD_TEXT, null, payload.toByteArray());
    }

    public void save() {
        if(Home.Selected == 1) {
            for (int i = 0; i < Program.Size_1; i++) {
                if (Program.Changes_Bool_1[i])
                    Program.Changes_1[i].save();
            }
            for (int i = 0; i < Program.Size_2; i++) {
                if (Program.Changes_Bool_2[i])
                    Program.Changes_2[i].save();
            }
            for (int i = 0; i < Program.Size_3; i++) {
                if (Program.Changes_Bool_3[i])
                    Program.Changes_3[i].save();
            }
            for (int i = 0; i < Program.Size_4; i++) {
                if (Program.Changes_Bool_4[i])
                    Program.Changes_4[i].save();
            }
        }
        else {
            for (int i = 0; i < Program2.Size_1; i++) {
                if (Program2.Changes_Bool_1[i])
                    Program2.Changes_1[i].save();
            }
            for (int i = 0; i < Program2.Size_2; i++) {
                if (Program2.Changes_Bool_2[i])
                    Program2.Changes_2[i].save();
            }
            for (int i = 0; i < Program2.Size_3; i++) {
                if (Program2.Changes_Bool_3[i])
                    Program2.Changes_3[i].save();
            }
            for (int i = 0; i < Program2.Size_4; i++) {
                if (Program2.Changes_Bool_4[i])
                    Program2.Changes_4[i].save();
            }
        }
    }
}