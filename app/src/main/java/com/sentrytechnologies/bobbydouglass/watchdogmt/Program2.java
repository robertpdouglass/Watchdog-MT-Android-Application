package com.sentrytechnologies.bobbydouglass.watchdogmt;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import java.util.ArrayList;

public class Program2 extends AppCompatActivity {

    public static final int SizeX =             8;
    public static final int SizeY =             24;

    public static Modbus[][] Changes =          new Modbus[SizeX][SizeY];
    public static boolean[][] Changes_Bool =  {{false,  false,  false,  false,  false,  false,  false,  false,
                                                false,  false,  false,  false,  false,  false,  false,  false,
                                                false,  false,  false,  false,  false,  false,  false,  false},
                                               {false,  false,  false,  false,  false,  false,  false,  false,
                                                false,  false,  false,  false,  false,  false,  false,  false,
                                                false,  false,  false,  false,  false,  false,  false,  false},
                                               {false,  false,  false,  false,  false,  false,  false,  false,
                                                false,  false,  false,  false,  false,  false,  false,  false,
                                                false,  false,  false,  false,  false,  false,  false,  false},
                                               {false,  false,  false,  false,  false,  false,  false,  false,
                                                false,  false,  false,  false,  false,  false,  false,  false,
                                                false,  false,  false,  false,  false,  false,  false,  false},
                                               {false,  false,  false,  false,  false,  false,  false,  false,
                                                false,  false,  false,  false,  false,  false,  false,  false,
                                                false,  false,  false,  false,  false,  false,  false,  false},
                                               {false,  false,  false,  false,  false,  false,  false,  false,
                                                false,  false,  false,  false,  false,  false,  false,  false,
                                                false,  false,  false,  false,  false,  false,  false,  false},
                                               {false,  false,  false,  false,  false,  false,  false,  false,
                                                false,  false,  false,  false,  false,  false,  false,  false,
                                                false,  false,  false,  false,  false,  false,  false,  false},
                                               {false,  false,  false,  false,  false,  false,  false,  false,
                                                false,  false,  false,  false,  false,  false,  false,  false,
                                                false,  false,  false,  false,  false,  false,  false,  false}};
    public static int[][] Changes_Add =       {{10200,  10206,  10212,  10218,  10224,  10230,  10236,  10242,
                                                10248,  10254,  10260,  10266,  10272,  10278,  10284,  10290,
                                                10296,  10302,  10308,  10314,  10320,  10326,  10332,  10338},
                                               {10201,  10207,  10213,  10219,  10225,  10231,  10237,  10243,
                                                10249,  10255,  10261,  10267,  10273,  10279,  10285,  10291,
                                                10297,  10303,  10309,  10315,  10321,  10327,  10333,  10339},
                                               {10202,  10208,  10214,  10220,  10226,  10232,  10238,  10244,
                                                10250,  10256,  10262,  10268,  10274,  10280,  10286,  10292,
                                                10298,  10304,  10310,  10316,  10322,  10328,  10334,  10340},
                                               {10203,  10209,  10215,  10221,  10227,  10233,  10239,  10245,
                                                10251,  10257,  10263,  10269,  10275,  10281,  10287,  10293,
                                                10299,  10305,  10311,  10317,  10323,  10329,  10335,  10341},
                                               {10204,  10210,  10216,  10222,  10228,  10234,  10240,  10246,
                                                10252,  10258,  10264,  10270,  10276,  10282,  10288,  10294,
                                                10300,  10306,  10312,  10318,  10324,  10330,  10336,  10342},
                                               {14102,  14107,  14112,  14117,  14122,  14127,  14132,  14137,
                                                14142,  14147,  14152,  14157,  14162,  14167,  14172,  14177,
                                                14182,  14187,  14192,  14197,  14202,  14207,  14212,  14217},
                                               {14100,  14105,  14110,  14115,  14120,  14125,  14130,  14135,
                                                14140,  14145,  14150,  14155,  14160,  14165,  14170,  14175,
                                                14180,  14185,  14190,  14195,  14200,  14205,  14210,  14215},
                                               {14101,  14106,  14111,  14116,  14121,  14126,  14131,  14136,
                                                14141,  14146,  14151,  14156,  14161,  14166,  14171,  14176,
                                                14181,  14186,  14191,  14196,  14201,  14206,  14211,  14216}};
    public static int[] Changes_Type =         {1,      1,      1,      1,      1,      3,      3,      3};
    boolean Changes_Made =                      false;
    int position =                              1;
    int loadedSpinners =                        0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        for(int x = 0; x < SizeX; x++)
            for(int y = 0; y < SizeY; y++)
                Changes[x][y] = new Modbus(getApplicationContext(), Changes_Add[x][y], Changes_Type[x]);

        Screen1();
    }

    @Override
    public void onBackPressed() {
        if(Changes_Made) {
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

    public void left(View view) {
        if(position > 1 && position < 8) {
            position--;
            switch (position) {
                case 1:
                    Screen1();
                    break;
                case 2:
                    Screen2();
                    break;
                case 3:
                    Screen3();
                    break;
                case 4:
                    Screen4();
                    break;
                case 5:
                    Screen5();
                    break;
                case 6:
                    Screen6();
                    break;
                case 7:
                    Screen7();
                    break;
            }
        }
    }

    public void right(View view) {
        if(position > 0 && position < 7) {
            position++;
            switch (position) {
                case 2:
                    Screen2();
                    break;
                case 3:
                    Screen3();
                    break;
                case 4:
                    Screen4();
                    break;
                case 5:
                    Screen5();
                    break;
                case 6:
                    Screen6();
                    break;
                case 7:
                    Screen7();
                    break;
            }
        }
    }

    public void Screen1() {
        final int x = 0;
        setContentView(R.layout.modbus_01_id);

        EditText e[] = {(EditText) findViewById(R.id.id_edittext_1),    (EditText) findViewById(R.id.id_edittext_2),
                        (EditText) findViewById(R.id.id_edittext_3),    (EditText) findViewById(R.id.id_edittext_4),
                        (EditText) findViewById(R.id.id_edittext_5),    (EditText) findViewById(R.id.id_edittext_6),
                        (EditText) findViewById(R.id.id_edittext_7),    (EditText) findViewById(R.id.id_edittext_8),
                        (EditText) findViewById(R.id.id_edittext_9),    (EditText) findViewById(R.id.id_edittext_10),
                        (EditText) findViewById(R.id.id_edittext_11),   (EditText) findViewById(R.id.id_edittext_12),
                        (EditText) findViewById(R.id.id_edittext_13),   (EditText) findViewById(R.id.id_edittext_14),
                        (EditText) findViewById(R.id.id_edittext_15),   (EditText) findViewById(R.id.id_edittext_16),
                        (EditText) findViewById(R.id.id_edittext_17),   (EditText) findViewById(R.id.id_edittext_18),
                        (EditText) findViewById(R.id.id_edittext_19),   (EditText) findViewById(R.id.id_edittext_20),
                        (EditText) findViewById(R.id.id_edittext_21),   (EditText) findViewById(R.id.id_edittext_22),
                        (EditText) findViewById(R.id.id_edittext_23),   (EditText) findViewById(R.id.id_edittext_24)};

        for(int i = 0; i < 24; i++) {
            final int j = i;
            e[j].setText("" + Changes[x][j].getValue1());
            e[j].addTextChangedListener(new TextWatcher() {
                @Override
                public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {}
                @Override
                public void afterTextChanged(Editable editable) {}
                @Override
                public void onTextChanged(CharSequence s, int start, int before, int count) {
                    if(s.length() != 0) {
                        Changes[x][j].setValue1(Short.parseShort(s.toString()));
                        Changes_Bool[x][j] = true;
                        Changes_Made = true;
                    }
                }
            });
        }
    }

    public void Screen2() {
        final int x = 1;
        setContentView(R.layout.modbus_02_command);
        loadedSpinners = 0;

        Spinner[] dropdown =   {(Spinner) findViewById(R.id.command_spinner_1),     (Spinner) findViewById(R.id.command_spinner_2),
                                (Spinner) findViewById(R.id.command_spinner_3),     (Spinner) findViewById(R.id.command_spinner_4),
                                (Spinner) findViewById(R.id.command_spinner_5),     (Spinner) findViewById(R.id.command_spinner_6),
                                (Spinner) findViewById(R.id.command_spinner_7),     (Spinner) findViewById(R.id.command_spinner_8),
                                (Spinner) findViewById(R.id.command_spinner_9),     (Spinner) findViewById(R.id.command_spinner_10),
                                (Spinner) findViewById(R.id.command_spinner_11),    (Spinner) findViewById(R.id.command_spinner_12),
                                (Spinner) findViewById(R.id.command_spinner_13),    (Spinner) findViewById(R.id.command_spinner_14),
                                (Spinner) findViewById(R.id.command_spinner_15),    (Spinner) findViewById(R.id.command_spinner_16),
                                (Spinner) findViewById(R.id.command_spinner_17),    (Spinner) findViewById(R.id.command_spinner_18),
                                (Spinner) findViewById(R.id.command_spinner_19),    (Spinner) findViewById(R.id.command_spinner_20),
                                (Spinner) findViewById(R.id.command_spinner_21),    (Spinner) findViewById(R.id.command_spinner_22),
                                (Spinner) findViewById(R.id.command_spinner_23),    (Spinner) findViewById(R.id.command_spinner_24)};
        String[] items = new String[]{"Rd Coil", "Rd Discreat", "Rd Register", "Rd Input", "Wr Coil", "Wr Register"};
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, items);
        for(int i = 0; i < 24; i++) {
            final int j = i;
            dropdown[i].setAdapter(adapter);
            dropdown[i].setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                @Override
                public void onItemSelected(AdapterView<?> adapterView, View view, int position, long id) {
                    if(loadedSpinners > 23) {
                        Changes[x][j].setValue1((short) position);
                        Changes_Bool[x][j] = true;
                        Changes_Made = true;
                    }
                }
                @Override
                public void onNothingSelected(AdapterView<?> adapterView) {}
            });
            dropdown[i].setSelection(Changes[x][j].getValue1());
            loadedSpinners++;
        }
    }

    public void Screen3() {
        final int x = 2;
        setContentView(R.layout.modbus_03_address);

        EditText e[] = {(EditText) findViewById(R.id.address_edittext_1),   (EditText) findViewById(R.id.address_edittext_2),
                        (EditText) findViewById(R.id.address_edittext_3),   (EditText) findViewById(R.id.address_edittext_4),
                        (EditText) findViewById(R.id.address_edittext_5),   (EditText) findViewById(R.id.address_edittext_6),
                        (EditText) findViewById(R.id.address_edittext_7),   (EditText) findViewById(R.id.address_edittext_8),
                        (EditText) findViewById(R.id.address_edittext_9),   (EditText) findViewById(R.id.address_edittext_10),
                        (EditText) findViewById(R.id.address_edittext_11),  (EditText) findViewById(R.id.address_edittext_12),
                        (EditText) findViewById(R.id.address_edittext_13),  (EditText) findViewById(R.id.address_edittext_14),
                        (EditText) findViewById(R.id.address_edittext_15),  (EditText) findViewById(R.id.address_edittext_16),
                        (EditText) findViewById(R.id.address_edittext_17),  (EditText) findViewById(R.id.address_edittext_18),
                        (EditText) findViewById(R.id.address_edittext_19),  (EditText) findViewById(R.id.address_edittext_20),
                        (EditText) findViewById(R.id.address_edittext_21),  (EditText) findViewById(R.id.address_edittext_22),
                        (EditText) findViewById(R.id.address_edittext_23),  (EditText) findViewById(R.id.address_edittext_24)};

        for(int i = 0; i < 24; i++) {
            final int j = i;
            e[j].setText("" + Changes[x][j].getValue1());
            e[j].addTextChangedListener(new TextWatcher() {
                @Override
                public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {}
                @Override
                public void afterTextChanged(Editable editable) {}
                @Override
                public void onTextChanged(CharSequence s, int start, int before, int count) {
                    if(s.length() != 0) {
                        Changes[x][j].setValue1(Short.parseShort(s.toString()));
                        Changes_Bool[x][j] = true;
                        Changes_Made = true;
                    }
                }
            });
        }
    }

    public void Screen4() {
        final int x = 3;
        setContentView(R.layout.modbus_04_data);
        loadedSpinners = 0;

        Spinner[] dropdown =   {(Spinner) findViewById(R.id.data_spinner_1),    (Spinner) findViewById(R.id.data_spinner_2),
                                (Spinner) findViewById(R.id.data_spinner_3),    (Spinner) findViewById(R.id.data_spinner_4),
                                (Spinner) findViewById(R.id.data_spinner_5),    (Spinner) findViewById(R.id.data_spinner_6),
                                (Spinner) findViewById(R.id.data_spinner_7),    (Spinner) findViewById(R.id.data_spinner_8),
                                (Spinner) findViewById(R.id.data_spinner_9),    (Spinner) findViewById(R.id.data_spinner_10),
                                (Spinner) findViewById(R.id.data_spinner_11),   (Spinner) findViewById(R.id.data_spinner_12),
                                (Spinner) findViewById(R.id.data_spinner_13),   (Spinner) findViewById(R.id.data_spinner_14),
                                (Spinner) findViewById(R.id.data_spinner_15),   (Spinner) findViewById(R.id.data_spinner_16),
                                (Spinner) findViewById(R.id.data_spinner_17),   (Spinner) findViewById(R.id.data_spinner_18),
                                (Spinner) findViewById(R.id.data_spinner_19),   (Spinner) findViewById(R.id.data_spinner_20),
                                (Spinner) findViewById(R.id.data_spinner_21),   (Spinner) findViewById(R.id.data_spinner_22),
                                (Spinner) findViewById(R.id.data_spinner_23),   (Spinner) findViewById(R.id.data_spinner_24)};
        String[] items = new String[]{"16Bit Int", "16Bit Unsigned Int", "8Bit Int", "8Bit Unsigned Int"};
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, items);
        for(int i = 0; i < 24; i++) {
            final int j = i;
            dropdown[i].setAdapter(adapter);
            dropdown[i].setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                @Override
                public void onItemSelected(AdapterView<?> adapterView, View view, int position, long id) {
                    if(loadedSpinners > 23) {
                        Changes[x][j].setValue1((short) position);
                        Changes_Bool[x][j] = true;
                        Changes_Made = true;
                    }
                }
                @Override
                public void onNothingSelected(AdapterView<?> adapterView) {}
            });
            dropdown[i].setSelection(Changes[x][j].getValue1());
            loadedSpinners++;
        }
    }

    public void Screen5() {
        final int x = 4;
        setContentView(R.layout.modbus_05_alarm);
        loadedSpinners = 0;

        Spinner[] dropdown =   {(Spinner) findViewById(R.id.alarm_spinner_1),   (Spinner) findViewById(R.id.alarm_spinner_2),
                                (Spinner) findViewById(R.id.alarm_spinner_3),   (Spinner) findViewById(R.id.alarm_spinner_4),
                                (Spinner) findViewById(R.id.alarm_spinner_5),   (Spinner) findViewById(R.id.alarm_spinner_6),
                                (Spinner) findViewById(R.id.alarm_spinner_7),   (Spinner) findViewById(R.id.alarm_spinner_8),
                                (Spinner) findViewById(R.id.alarm_spinner_9),   (Spinner) findViewById(R.id.alarm_spinner_10),
                                (Spinner) findViewById(R.id.alarm_spinner_11),  (Spinner) findViewById(R.id.alarm_spinner_12),
                                (Spinner) findViewById(R.id.alarm_spinner_13),  (Spinner) findViewById(R.id.alarm_spinner_14),
                                (Spinner) findViewById(R.id.alarm_spinner_15),  (Spinner) findViewById(R.id.alarm_spinner_16),
                                (Spinner) findViewById(R.id.alarm_spinner_17),  (Spinner) findViewById(R.id.alarm_spinner_18),
                                (Spinner) findViewById(R.id.alarm_spinner_19),  (Spinner) findViewById(R.id.alarm_spinner_20),
                                (Spinner) findViewById(R.id.alarm_spinner_21),  (Spinner) findViewById(R.id.alarm_spinner_22),
                                (Spinner) findViewById(R.id.alarm_spinner_23),  (Spinner) findViewById(R.id.alarm_spinner_24)};
        String[] items = new String[]{"Status Only", "Alarm If Zero", "Alarm If Nonzero", "Analog Low/High"};
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, items);
        for(int i = 0; i < 24; i++) {
            final int j = i;
            dropdown[i].setAdapter(adapter);
            dropdown[i].setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                @Override
                public void onItemSelected(AdapterView<?> adapterView, View view, int position, long id) {
                    if(loadedSpinners > 23) {
                        Changes[x][j].setValue1((short) position);
                        Changes_Bool[x][j] = true;
                        Changes_Made = true;
                    }
                }
                @Override
                public void onNothingSelected(AdapterView<?> adapterView) {}
            });
            dropdown[i].setSelection(Changes[x][j].getValue1());
            loadedSpinners++;
        }
    }

    public void Screen6() {
        final int x = 5;
        setContentView(R.layout.modbus_06_calibration);

        EditText e[] = {(EditText) findViewById(R.id.calibration_edittext_1),   (EditText) findViewById(R.id.calibration_edittext_2),
                        (EditText) findViewById(R.id.calibration_edittext_3),   (EditText) findViewById(R.id.calibration_edittext_4),
                        (EditText) findViewById(R.id.calibration_edittext_5),   (EditText) findViewById(R.id.calibration_edittext_6),
                        (EditText) findViewById(R.id.calibration_edittext_7),   (EditText) findViewById(R.id.calibration_edittext_8),
                        (EditText) findViewById(R.id.calibration_edittext_9),   (EditText) findViewById(R.id.calibration_edittext_10),
                        (EditText) findViewById(R.id.calibration_edittext_11),  (EditText) findViewById(R.id.calibration_edittext_12),
                        (EditText) findViewById(R.id.calibration_edittext_13),  (EditText) findViewById(R.id.calibration_edittext_14),
                        (EditText) findViewById(R.id.calibration_edittext_15),  (EditText) findViewById(R.id.calibration_edittext_16),
                        (EditText) findViewById(R.id.calibration_edittext_17),  (EditText) findViewById(R.id.calibration_edittext_18),
                        (EditText) findViewById(R.id.calibration_edittext_19),  (EditText) findViewById(R.id.calibration_edittext_20),
                        (EditText) findViewById(R.id.calibration_edittext_21),  (EditText) findViewById(R.id.calibration_edittext_22),
                        (EditText) findViewById(R.id.calibration_edittext_23),  (EditText) findViewById(R.id.calibration_edittext_24)};
        for(int i = 0; i < 24; i++) {
            final int j = i;
            e[j].setText("" + Changes[x][j].getValue3());
            e[j].addTextChangedListener(new TextWatcher() {
                @Override
                public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {}
                @Override
                public void afterTextChanged(Editable editable) {}
                @Override
                public void onTextChanged(CharSequence s, int start, int before, int count) {
                    if(s.length() != 0) {
                        Changes[x][j].setValue3(Float.parseFloat(s.toString()));
                        Changes_Bool[x][j] = true;
                        Changes_Made = true;
                    }
                }
            });
        }
    }

    public void Screen7() {
        final int x = 6;
        setContentView(R.layout.modbus_07_limits);

        EditText e[][] =  {{(EditText) findViewById(R.id.limits_edittext_low_1),    (EditText) findViewById(R.id.limits_edittext_low_2),
                            (EditText) findViewById(R.id.limits_edittext_low_3),    (EditText) findViewById(R.id.limits_edittext_low_4),
                            (EditText) findViewById(R.id.limits_edittext_low_5),    (EditText) findViewById(R.id.limits_edittext_low_6),
                            (EditText) findViewById(R.id.limits_edittext_low_7),    (EditText) findViewById(R.id.limits_edittext_low_8),
                            (EditText) findViewById(R.id.limits_edittext_low_9),    (EditText) findViewById(R.id.limits_edittext_low_10),
                            (EditText) findViewById(R.id.limits_edittext_low_11),   (EditText) findViewById(R.id.limits_edittext_low_12),
                            (EditText) findViewById(R.id.limits_edittext_low_13),   (EditText) findViewById(R.id.limits_edittext_low_14),
                            (EditText) findViewById(R.id.limits_edittext_low_15),   (EditText) findViewById(R.id.limits_edittext_low_16),
                            (EditText) findViewById(R.id.limits_edittext_low_17),   (EditText) findViewById(R.id.limits_edittext_low_18),
                            (EditText) findViewById(R.id.limits_edittext_low_19),   (EditText) findViewById(R.id.limits_edittext_low_20),
                            (EditText) findViewById(R.id.limits_edittext_low_21),   (EditText) findViewById(R.id.limits_edittext_low_22),
                            (EditText) findViewById(R.id.limits_edittext_low_23),   (EditText) findViewById(R.id.limits_edittext_low_24)},
                           {(EditText) findViewById(R.id.limits_edittext_high_1),    (EditText) findViewById(R.id.limits_edittext_high_2),
                            (EditText) findViewById(R.id.limits_edittext_high_3),    (EditText) findViewById(R.id.limits_edittext_high_4),
                            (EditText) findViewById(R.id.limits_edittext_high_5),    (EditText) findViewById(R.id.limits_edittext_high_6),
                            (EditText) findViewById(R.id.limits_edittext_high_7),    (EditText) findViewById(R.id.limits_edittext_high_8),
                            (EditText) findViewById(R.id.limits_edittext_high_9),    (EditText) findViewById(R.id.limits_edittext_high_10),
                            (EditText) findViewById(R.id.limits_edittext_high_11),   (EditText) findViewById(R.id.limits_edittext_high_12),
                            (EditText) findViewById(R.id.limits_edittext_high_13),   (EditText) findViewById(R.id.limits_edittext_high_14),
                            (EditText) findViewById(R.id.limits_edittext_high_15),   (EditText) findViewById(R.id.limits_edittext_high_16),
                            (EditText) findViewById(R.id.limits_edittext_high_17),   (EditText) findViewById(R.id.limits_edittext_high_18),
                            (EditText) findViewById(R.id.limits_edittext_high_19),   (EditText) findViewById(R.id.limits_edittext_high_20),
                            (EditText) findViewById(R.id.limits_edittext_high_21),   (EditText) findViewById(R.id.limits_edittext_high_22),
                            (EditText) findViewById(R.id.limits_edittext_high_23),   (EditText) findViewById(R.id.limits_edittext_high_24)}};
        for(int i = 0; i < 2; i++) {
            for (int j = 0; j < 24; j++) {
                final int l = i, k = j;
                e[l][j].setText("" + Changes[x + l][j].getValue3());
                e[l][j].addTextChangedListener(new TextWatcher() {
                    @Override
                    public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {}
                    @Override
                    public void afterTextChanged(Editable editable) {}
                    @Override
                    public void onTextChanged(CharSequence s, int start, int before, int count) {
                        if (s.length() != 0) {
                            Changes[x + l][k].setValue3(Float.parseFloat(s.toString()));
                            Changes_Bool[x + l][k] = true;
                            Changes_Made = true;
                        }
                    }
                });
            }
        }
    }
}