package com.sentrytechnologies.bobbydouglass.watchdogmt;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class Program extends AppCompatActivity {

    int position =                              1;
    boolean[] loaded =                         {false, false, false};
    boolean[] loaded4 =                        {false, false, false, false, false, false, false, false};
    boolean[] loaded5 =                        {false, false, false, false, false, false, false, false};
    boolean[] pulseIndividual =                {false, false, false, false, false, false, false, false};
    boolean pulseLoad =                         false;
    int loadSpinners =                          1;

    public static final int Size_1 =            16;
    public static final int Size_2 =            0;
    public static final int Size_3 =            8;
    public static final int Size_4 =            16;

    public static Modbus[] Changes_1 =          new Modbus[Size_1];
    public static Modbus[] Changes_2 =          new Modbus[Size_2];
    public static Modbus[] Changes_3 =          new Modbus[Size_3];
    public static Modbus[] Changes_4 =          new Modbus[Size_4];

    public static boolean[] Changes_Bool_1 =   {false,  false,  false,  false,  false,  false,  false,  false,
                                                false,  false,  false,  false,  false,  false,  false,  false};
    public static boolean[] Changes_Bool_2 =    null;
    public static boolean[] Changes_Bool_3 =   {false,  false,  false,  false,  false,  false,  false,  false};
    public static boolean[] Changes_Bool_4 =   {false,  false,  false,  false,  false,  false,  false,  false,
                                                false,  false,  false,  false,  false,  false,  false,  false};

    int[] Address_1 =                          {10100,  10102,  10104,  10106,  10108,  10110,  10112,  10114,
                                                12000,  12001,  12002,  12003,  12004,  12005,  12006,  12007};
    int[] Address_2 =                           null;
    int[] Address_3 =                          {14000,  14001,  14002,  14003,  14004,  14005,  14006,  14007};
    int[] Address_4 =                          {16000,  16001,  16002,  16003,  16004,  16005,  16006,  16007,
                                                15600,  15601,  15602,  15603,  15604,  15605,  15606,  15607};

    boolean changes_made =                      false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Screen1();
    }

    public void mvLeft(View view) {
        if(position > 1 && position < 6) {
            position--;
            if(position == 1)
                Screen1();
            else if(position == 2)
                Screen2();
            else if(position == 3)
                Screen3();
            else if(position == 4)
                Screen4();
            else
                Toast.makeText(this, "OUT OF BOUNDS", Toast.LENGTH_SHORT).show();
        }
        else
            Toast.makeText(this, "Cannot move farther left", Toast.LENGTH_SHORT).show();
    }

    public void mvRight(View view) {
        if(position > 0 && position < 5) {
            position++;
            if(position == 2)
                Screen2();
            else if(position == 3)
                Screen3();
            else if(position == 4) {
                if(pulseLoad)
                    Screen4();
                else
                    Toast.makeText(this, "Pulse Multiplier Not Selected For Any Inputs", Toast.LENGTH_SHORT).show();
            }
            else if(position == 5) {
                Screen5();
            }
            else
                Toast.makeText(this, "OUT OF BOUNDS", Toast.LENGTH_SHORT).show();
        }
        else
            Toast.makeText(this, "Cannot move farther right", Toast.LENGTH_SHORT).show();
    }

    public void Screen1() {
        if(!loaded[0]) {
            loaded[0] = true;
            for(int i = 0; i < 8; i++)
                Changes_1[i] = new Modbus(getApplicationContext(), Address_1[i], 1);
        }

        setContentView(R.layout.local_input_mode);

        loadSpinners = 0;

        Spinner[] dropdown =   {(Spinner) findViewById(R.id.spinner1),  (Spinner) findViewById(R.id.spinner2),
                                (Spinner) findViewById(R.id.spinner3),  (Spinner) findViewById(R.id.spinner4),
                                (Spinner) findViewById(R.id.spinner5),  (Spinner) findViewById(R.id.spinner6),
                                (Spinner) findViewById(R.id.spinner7),  (Spinner) findViewById(R.id.spinner8)};

        String[] items = new String[]{"0 = Disabled", "1 = Normally Open", "2 = Normally Closed", "3 = Pulse Counter"};
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, items);

        for(int i = 0; i < 8; i++) {
            dropdown[i].setAdapter(adapter);
            dropdown[i].setOnItemSelectedListener(onSpinner);
            if(Changes_1[i].getValue1() == 3) {
                pulseIndividual[i] = true;
                pulseLoad = true;
            }
            dropdown[i].setSelection(Changes_1[i].getValue1());
        }
    }

    public void Screen2() {
        if(!loaded[1]) {
            loaded[1] = true;
            for(int i = 0; i < 8; i++)
                Changes_1[i + 8] = new Modbus(getApplicationContext(), Address_1[i + 8], 1);
        }

        setContentView(R.layout.local_input_rec_time);
        EditText[] minutes =   {(EditText) findViewById(R.id.edittext1),  (EditText) findViewById(R.id.edittext3),
                                (EditText) findViewById(R.id.edittext5), (EditText) findViewById(R.id.edittext7),
                                (EditText) findViewById(R.id.edittext9), (EditText) findViewById(R.id.edittext11),
                                (EditText) findViewById(R.id.edittext13), (EditText) findViewById(R.id.edittext15)};
        EditText[] seconds =   {(EditText) findViewById(R.id.edittext2), (EditText) findViewById(R.id.edittext4),
                                (EditText) findViewById(R.id.edittext6), (EditText) findViewById(R.id.edittext8),
                                (EditText) findViewById(R.id.edittext10), (EditText) findViewById(R.id.edittext12),
                                (EditText) findViewById(R.id.edittext14), (EditText) findViewById(R.id.edittext16)};
        for(int i = 0; i < 8; i++) {
            seconds[i].setText("" + (Changes_1[i + 8].getValue1()) % 60);
            minutes[i].setText("" + (Changes_1[i + 8].getValue1()) / 60);
            final int index = i + 8;
            final Modbus temp = Changes_1[index];
            minutes[i].addTextChangedListener(new TextWatcher() {
                @Override
                public void afterTextChanged(Editable s) {}

                @Override
                public void beforeTextChanged(CharSequence s, int start, int count, int after) {}

                @Override
                public void onTextChanged(CharSequence s, int start, int before, int count) {
                    if(s.length() != 0) {
                        int seconds = (temp.getValue1() % 60) + (Integer.parseInt(s.toString()) * 60);
                        Changes_1[index].setValue(seconds);
                        Changes_Bool_1[index] = true;
                        changes_made = true;
                    }
                }
            });
            seconds[i].addTextChangedListener(new TextWatcher() {
                @Override
                public void afterTextChanged(Editable s) {}

                @Override
                public void beforeTextChanged(CharSequence s, int start, int count, int after) {}

                @Override
                public void onTextChanged(CharSequence s, int start, int before, int count) {
                    if(s.length() != 0) {
                        int seconds = (temp.getValue1() / 60) + (Integer.parseInt(s.toString()));
                        Changes_1[index].setValue(seconds);
                        Changes_Bool_1[index] = true;
                        changes_made = true;
                    }
                }
            });
        }
    }

    public void Screen3() {
        if(!loaded[2]) {
            loaded[2] = true;
            for(int i = 0; i < 8; i++) {
                Changes_4[i] = new Modbus(getApplicationContext(), Address_4[i], 4);
            }
        }

        setContentView(R.layout.local_input_name);

        EditText[] name =  {(EditText) findViewById(R.id.edittext1), (EditText) findViewById(R.id.edittext2),
                            (EditText) findViewById(R.id.edittext3), (EditText) findViewById(R.id.edittext4),
                            (EditText) findViewById(R.id.edittext5), (EditText) findViewById(R.id.edittext6),
                            (EditText) findViewById(R.id.edittext7), (EditText) findViewById(R.id.edittext8)};

        for(int i = 0; i < 8; i++) {
            name[i].setText("" + Changes_4[i].getValue4());
            final int index = i;
            final Modbus temp = Changes_4[index];
            name[i].addTextChangedListener(new TextWatcher() {
                @Override
                public void afterTextChanged(Editable s) {}

                @Override
                public void beforeTextChanged(CharSequence s, int start, int count, int after) {}

                @Override
                public void onTextChanged(CharSequence s, int start, int before, int count) {
                    if(count != 0 && count < 17) {
                        Changes_4[index].setValue(s.toString());
                        Changes_Bool_4[index] = true;
                        changes_made = true;
                    }
                }
            });
        }
    }

    public void Screen4() {
        setContentView(R.layout.local_input_pulse);

        EditText[] pulse = {(EditText) findViewById(R.id.edittext1), (EditText) findViewById(R.id.edittext2),
                            (EditText) findViewById(R.id.edittext3), (EditText) findViewById(R.id.edittext4),
                            (EditText) findViewById(R.id.edittext5), (EditText) findViewById(R.id.edittext6),
                            (EditText) findViewById(R.id.edittext7), (EditText) findViewById(R.id.edittext8)};

        for(int i = 0; i < 8; i++) {
            if(pulseIndividual[i]) {
                pulse[i].setClickable(true);
                pulse[i].setEnabled(true);

                if(!loaded4[i]) {
                    loaded4[i] = true;
                    Changes_3[i] = new Modbus(getApplicationContext(), Address_3[i], 3);
                }

                pulse[i].setText("" + Changes_3[i].getValue3());

                final int index = i;
                final Modbus temp = Changes_3[index];
                pulse[i].addTextChangedListener(new TextWatcher() {
                    @Override
                    public void afterTextChanged(Editable s) {}

                    @Override
                    public void beforeTextChanged(CharSequence s, int start, int count, int after) {}

                    @Override
                    public void onTextChanged(CharSequence s, int start, int before, int count) {
                        if(s.length() != 0) {
                            Changes_3[index].setValue(Float.parseFloat(s.toString()));
                            Changes_Bool_3[index] = true;
                            changes_made = true;
                        }
                    }
                });
            }
            else {
                pulse[i].setClickable(false);
                pulse[i].setEnabled(false);
            }
        }

    }

    public void Screen5() {
        setContentView(R.layout.local_input_units);

        EditText[] pulse = {(EditText) findViewById(R.id.edittext1), (EditText) findViewById(R.id.edittext2),
                (EditText) findViewById(R.id.edittext3), (EditText) findViewById(R.id.edittext4),
                (EditText) findViewById(R.id.edittext5), (EditText) findViewById(R.id.edittext6),
                (EditText) findViewById(R.id.edittext7), (EditText) findViewById(R.id.edittext8)};

        for(int i = 0; i < 8; i++) {
            if(pulseIndividual[i]) {
                pulse[i].setClickable(true);
                pulse[i].setEnabled(true);

                if(!loaded5[i]) {
                    loaded5[i] = true;
                    Changes_4[i + 8] = new Modbus(getApplicationContext(), Address_4[i + 8], 4);
                }

                pulse[i].setText(Changes_4[i + 8].getValue4());

                final int index = i + 8;
                final Modbus temp = Changes_4[index];
                pulse[i].addTextChangedListener(new TextWatcher() {
                    @Override
                    public void afterTextChanged(Editable s) {}
                    @Override
                    public void beforeTextChanged(CharSequence s, int start, int count, int after) {}
                    @Override
                    public void onTextChanged(CharSequence s, int start, int before, int count) {
                        if(s.length() != 0) {
                            Changes_4[index].setValue(Float.parseFloat(s.toString()));
                            Changes_Bool_4[index] = true;
                            changes_made = true;
                        }
                    }
                });
            }
            else {
                pulse[i].setClickable(false);
                pulse[i].setEnabled(false);
            }
        }
    }

    AdapterView.OnItemSelectedListener onSpinner = new AdapterView.OnItemSelectedListener() {
        @Override
        public void onItemSelected(AdapterView<?> parent, View view, int pos, long id) {
            int i = 0;
            switch(parent.getId()) {
                case R.id.spinner:
                    i = 0;
                    break;
                case R.id.spinner2:
                    i = 1;
                    break;
                case R.id.spinner3:
                    i = 2;
                    break;
                case R.id.spinner4:
                    i = 3;
                    break;
                case R.id.spinner5:
                    i = 4;
                    break;
                case R.id.spinner6:
                    i = 5;
                    break;
                case R.id.spinner7:
                    i = 6;
                    break;
                case R.id.spinner8:
                    i = 7;
                    break;
            }
            if(loadSpinners > 7) {
                Changes_1[i].setValue(pos);
                Changes_Bool_1[i] = true;
                changes_made = true;
                if(Changes_1[i].getValue1() == 3) {
                    pulseIndividual[i] = true;
                    pulseLoad = true;
                }
            }
            else {
                loadSpinners++;
            }
        }

        @Override
        public void onNothingSelected(AdapterView<?> parent) {}
    };

    @Override
    public void onBackPressed() {
        if(changes_made) {
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setMessage("Changes made");
            builder.setPositiveButton("Save Changes", dialogClickListener);
            builder.setNegativeButton("Discard Changes", dialogClickListener).show();
        }
        else
            startActivity(new Intent(this, Home.class));
    }

    DialogInterface.OnClickListener dialogClickListener = new DialogInterface.OnClickListener() {
        @Override
        public void onClick(DialogInterface dialog, int which) {
            switch (which){
                case DialogInterface.BUTTON_POSITIVE:
                    startNFC();
                    break;

                case DialogInterface.BUTTON_NEGATIVE:
                    startHome();
                    break;
            }
        }
    };

    public void startNFC() {
        startActivity(new Intent(this, Nfc.class));
    }

    public void startHome() {
        startActivity(new Intent(this, Home.class));
    }
}