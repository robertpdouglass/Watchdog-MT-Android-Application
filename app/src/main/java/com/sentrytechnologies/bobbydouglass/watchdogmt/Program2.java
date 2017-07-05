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

    int position =                              1;
    boolean[] loaded =                         {false,  false,  false,  false,  false,  false,  false,  false,
                                                false};
    int loadSpinners =                          0;

    public static final int Size_1 =            120;
    public static final int Size_2 =            0;
    public static final int Size_3 =            72;
    public static final int Size_4 =            48;

    public static Modbus[] Changes_1 =          new Modbus[Size_1];
    public static Modbus[] Changes_2 =          new Modbus[Size_2];
    public static Modbus[] Changes_3 =          new Modbus[Size_3];
    public static Modbus[] Changes_4 =          new Modbus[Size_4];

    public static boolean[] Changes_Bool_1 =   {false,  false,  false,  false,  false,  false,  false,  false,
                                                false,  false,  false,  false,  false,  false,  false,  false,
                                                false,  false,  false,  false,  false,  false,  false,  false,
                                                false,  false,  false,  false,  false,  false,  false,  false,
                                                false,  false,  false,  false,  false,  false,  false,  false,
                                                false,  false,  false,  false,  false,  false,  false,  false,
                                                false,  false,  false,  false,  false,  false,  false,  false,
                                                false,  false,  false,  false,  false,  false,  false,  false,
                                                false,  false,  false,  false,  false,  false,  false,  false,
                                                false,  false,  false,  false,  false,  false,  false,  false,
                                                false,  false,  false,  false,  false,  false,  false,  false,
                                                false,  false,  false,  false,  false,  false,  false,  false,
                                                false,  false,  false,  false,  false,  false,  false,  false,
                                                false,  false,  false,  false,  false,  false,  false,  false,
                                                false,  false,  false,  false,  false,  false,  false,  false};
    public static boolean[] Changes_Bool_2 =    null;
    public static boolean[] Changes_Bool_3 =   {false,  false,  false,  false,  false,  false,  false,  false,
                                                false,  false,  false,  false,  false,  false,  false,  false,
                                                false,  false,  false,  false,  false,  false,  false,  false,
                                                false,  false,  false,  false,  false,  false,  false,  false,
                                                false,  false,  false,  false,  false,  false,  false,  false,
                                                false,  false,  false,  false,  false,  false,  false,  false,
                                                false,  false,  false,  false,  false,  false,  false,  false,
                                                false,  false,  false,  false,  false,  false,  false,  false,
                                                false,  false,  false,  false,  false,  false,  false,  false};
    public static boolean[] Changes_Bool_4 =   {false,  false,  false,  false,  false,  false,  false,  false,
                                                false,  false,  false,  false,  false,  false,  false,  false,
                                                false,  false,  false,  false,  false,  false,  false,  false,
                                                false,  false,  false,  false,  false,  false,  false,  false,
                                                false,  false,  false,  false,  false,  false,  false,  false,
                                                false,  false,  false,  false,  false,  false,  false,  false};

    int[] Address_1 =                          {10200,  10206,  10212,  10218,  10224,  10230,  10236,  10242,
                                                10248,  10254,  10260,  10266,  10272,  10278,  10284,  10290,
                                                10296,  10302,  10308,  10314,  10320,  10326,  10332,  10338,
                                                10201,  10207,  10213,  10219,  10225,  10231,  10237,  10243,
                                                10249,  10255,  10261,  10267,  10273,  10279,  10285,  10291,
                                                10297,  10303,  10309,  10315,  10321,  10327,  10333,  10339,
                                                10202,  10208,  10214,  10220,  10226,  10232,  10238,  10244,
                                                10250,  10256,  10262,  10268,  10274,  10280,  10286,  10292,
                                                10298,  10304,  10310,  10316,  10322,  10328,  10334,  10340,
                                                10203,  10209,  10215,  10221,  10227,  10233,  10239,  10245,
                                                10251,  10257,  10263,  10269,  10275,  10281,  10287,  10293,
                                                10299,  10305,  10311,  10317,  10323,  10329,  10335,  10341,
                                                10204,  10210,  10216,  10222,  10228,  10234,  10240,  10246,
                                                10252,  10258,  10264,  10270,  10276,  10282,  10288,  10294,
                                                10300,  10306,  10312,  10318,  10324,  10330,  10336,  10342};
    int[] Address_2 =                           null;
    int[] Address_3 =                          {14102,  14107,  14112,  14117,  14122,  14127,  14132,  14137,
                                                14142,  14147,  14152,  14157,  14162,  14167,  14172,  14177,
                                                14182,  14187,  14192,  14197,  14202,  14207,  14212,  14217,
                                                14100,  14105,  14110,  14115,  14120,  14125,  14130,  14135,
                                                14140,  14145,  14150,  14155,  14160,  14165,  14170,  14175,
                                                14180,  14185,  14190,  14195,  14200,  14205,  14210,  14215,
                                                14101,  14106,  14111,  14116,  14121,  14126,  14131,  14136,
                                                14141,  14146,  14151,  14156,  14161,  14166,  14171,  14176,
                                                14181,  14186,  14191,  14196,  14201,  14206,  14211,  14216};
    int[] Address_4 =                          {16008,  16009,  16010,  16011,  16012,  16013,  16014,  16015,
                                                16016,  16017,  16018,  16019,  16020,  16021,  16022,  16023,
                                                16024,  16025,  16026,  16027,  16028,  16029,  16030,  16031,
                                                15608,  15609,  15610,  15611,  15612,  15613,  15614,  15615,
                                                15616,  15617,  15618,  15619,  15620,  15621,  15622,  15623,
                                                15624,  15625,  15626,  15627,  15628,  15629,  15630,  15631};

    boolean changes_made =                      false;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.modbus_id);
        Screen1();
    }

    public void mvLeft(View view) {
        if(position > 1 && position < 10) {
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
                case 8:
                    Screen8();
                    break;
            }
        }
    }

    public void mvRight(View view) {
        if(position > 0 && position < 9) {
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
                case 8:
                    Screen8();
                    break;
                case 9:
                    Screen9();
                    break;
            }
        }
    }

    public void Screen1() {
        if(!loaded[0]) {
            loaded[0] = true;
            for(int i = 0; i < 24; i++)
                Changes_1[i] = new Modbus(getApplicationContext(), Address_1[i], 1);
        }

        setContentView(R.layout.modbus_id);

        EditText id[] =    {(EditText) findViewById(R.id.edittext1),    (EditText) findViewById(R.id.edittext2),
                            (EditText) findViewById(R.id.edittext3),    (EditText) findViewById(R.id.edittext4),
                            (EditText) findViewById(R.id.edittext5),    (EditText) findViewById(R.id.edittext6),
                            (EditText) findViewById(R.id.edittext7),    (EditText) findViewById(R.id.edittext8),
                            (EditText) findViewById(R.id.edittext9),    (EditText) findViewById(R.id.edittext10),
                            (EditText) findViewById(R.id.edittext11),   (EditText) findViewById(R.id.edittext12),
                            (EditText) findViewById(R.id.edittext13),   (EditText) findViewById(R.id.edittext14),
                            (EditText) findViewById(R.id.edittext15),   (EditText) findViewById(R.id.edittext16),
                            (EditText) findViewById(R.id.edittext17),   (EditText) findViewById(R.id.edittext18),
                            (EditText) findViewById(R.id.edittext19),   (EditText) findViewById(R.id.edittext20),
                            (EditText) findViewById(R.id.edittext21),   (EditText) findViewById(R.id.edittext22),
                            (EditText) findViewById(R.id.edittext23),   (EditText) findViewById(R.id.edittext24)};

        for(int i = 0; i < 24; i++) {
            id[i].setText("" + Changes_1[i].getValue1());
            final int index = i;
            id[i].addTextChangedListener(new TextWatcher() {
                @Override
                public void afterTextChanged(Editable s) {}

                @Override
                public void beforeTextChanged(CharSequence s, int start, int count, int after) {}

                @Override
                public void onTextChanged(CharSequence s, int start, int before, int count) {
                    if(count != 0 && count < 17) {
                        Changes_1[index].setValue(Integer.parseInt(s.toString()));
                        Changes_Bool_1[index] = true;
                        changes_made = true;
                    }
                }
            });
        }
    }

    public void Screen2() {
        if(!loaded[1]) {
            loaded[1] = true;
            for(int i = 24; i < 48; i++)
                Changes_1[i] = new Modbus(getApplicationContext(), Address_1[i], 1);
        }

        setContentView(R.layout.modbus_command);

        loadSpinners = 0;

        Spinner[] dropdown =   {(Spinner) findViewById(R.id.spinner1),      (Spinner) findViewById(R.id.spinner2),
                                (Spinner) findViewById(R.id.spinner3),      (Spinner) findViewById(R.id.spinner4),
                                (Spinner) findViewById(R.id.spinner5),      (Spinner) findViewById(R.id.spinner6),
                                (Spinner) findViewById(R.id.spinner7),      (Spinner) findViewById(R.id.spinner8),
                                (Spinner) findViewById(R.id.spinner9),      (Spinner) findViewById(R.id.spinner10),
                                (Spinner) findViewById(R.id.spinner11),     (Spinner) findViewById(R.id.spinner12),
                                (Spinner) findViewById(R.id.spinner13),     (Spinner) findViewById(R.id.spinner14),
                                (Spinner) findViewById(R.id.spinner15),     (Spinner) findViewById(R.id.spinner16),
                                (Spinner) findViewById(R.id.spinner17),     (Spinner) findViewById(R.id.spinner18),
                                (Spinner) findViewById(R.id.spinner19),     (Spinner) findViewById(R.id.spinner20),
                                (Spinner) findViewById(R.id.spinner21),     (Spinner) findViewById(R.id.spinner22),
                                (Spinner) findViewById(R.id.spinner23),     (Spinner) findViewById(R.id.spinner24)};

        String[] items = new String[]{"Rd Coil", "Rd Discreat", "Rd Register", "Rd Input", "Wr Coil", "Wr Register"};
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, items);

        for (int j = 0, i = 24; j < 24; j++, i++) {
            dropdown[j].setAdapter(adapter);
            dropdown[j].setOnItemSelectedListener(onSpinner2);
            dropdown[j].setSelection(Changes_1[i].getValue1());
        }
    }

    public void Screen3() {
        if(!loaded[2]) {
            loaded[2] = true;
            for(int i = 48; i < 72; i++)
                Changes_1[i] = new Modbus(getApplicationContext(), Address_1[i], 1);
        }

        setContentView(R.layout.modbus_address);

        EditText id[] =    {(EditText) findViewById(R.id.edittext1),    (EditText) findViewById(R.id.edittext2),
                            (EditText) findViewById(R.id.edittext3),    (EditText) findViewById(R.id.edittext4),
                            (EditText) findViewById(R.id.edittext5),    (EditText) findViewById(R.id.edittext6),
                            (EditText) findViewById(R.id.edittext7),    (EditText) findViewById(R.id.edittext8),
                            (EditText) findViewById(R.id.edittext9),    (EditText) findViewById(R.id.edittext10),
                            (EditText) findViewById(R.id.edittext11),   (EditText) findViewById(R.id.edittext12),
                            (EditText) findViewById(R.id.edittext13),   (EditText) findViewById(R.id.edittext14),
                            (EditText) findViewById(R.id.edittext15),   (EditText) findViewById(R.id.edittext16),
                            (EditText) findViewById(R.id.edittext17),   (EditText) findViewById(R.id.edittext18),
                            (EditText) findViewById(R.id.edittext19),   (EditText) findViewById(R.id.edittext20),
                            (EditText) findViewById(R.id.edittext21),   (EditText) findViewById(R.id.edittext22),
                            (EditText) findViewById(R.id.edittext23),   (EditText) findViewById(R.id.edittext24)};

        for(int j = 0, i = 48; j < 24; j++, i++) {
            id[j].setText("" + Changes_1[i].getValue1());
            final int index = i;
            id[j].addTextChangedListener(new TextWatcher() {
                @Override
                public void afterTextChanged(Editable s) {}

                @Override
                public void beforeTextChanged(CharSequence s, int start, int count, int after) {}

                @Override
                public void onTextChanged(CharSequence s, int start, int before, int count) {
                    if(count != 0 && count < 17) {
                        Changes_1[index].setValue(Integer.parseInt(s.toString()));
                        Changes_Bool_1[index] = true;
                        changes_made = true;
                    }
                }
            });
        }
    }

    public void Screen4() {
        if(!loaded[3]) {
            loaded[3] = true;
            for(int i = 72; i < 96; i++)
                Changes_1[i] = new Modbus(getApplicationContext(), Address_1[i], 1);
        }

        setContentView(R.layout.modbus_data_format);

        loadSpinners = 0;

        Spinner[] dropdown =   {(Spinner) findViewById(R.id.spinner49),     (Spinner) findViewById(R.id.spinner50),
                                (Spinner) findViewById(R.id.spinner51),     (Spinner) findViewById(R.id.spinner52),
                                (Spinner) findViewById(R.id.spinner53),     (Spinner) findViewById(R.id.spinner54),
                                (Spinner) findViewById(R.id.spinner55),     (Spinner) findViewById(R.id.spinner56),
                                (Spinner) findViewById(R.id.spinner57),     (Spinner) findViewById(R.id.spinner58),
                                (Spinner) findViewById(R.id.spinner59),     (Spinner) findViewById(R.id.spinner60),
                                (Spinner) findViewById(R.id.spinner61),     (Spinner) findViewById(R.id.spinner62),
                                (Spinner) findViewById(R.id.spinner63),     (Spinner) findViewById(R.id.spinner64),
                                (Spinner) findViewById(R.id.spinner65),     (Spinner) findViewById(R.id.spinner66),
                                (Spinner) findViewById(R.id.spinner67),     (Spinner) findViewById(R.id.spinner68),
                                (Spinner) findViewById(R.id.spinner69),     (Spinner) findViewById(R.id.spinner70),
                                (Spinner) findViewById(R.id.spinner71),     (Spinner) findViewById(R.id.spinner72)};

        String[] items = new String[]{"16-Bit Integer", "16-Bit Unsigned Integer", "8-Bit Integer", "8-Bit Unsigned Integer"};
        ArrayAdapter<String> adapterr = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, items);

        for(int j = 0, i = 72; j < 24; j++, i++) {
            dropdown[j].setAdapter(adapterr);
            dropdown[j].setOnItemSelectedListener(onSpinner4);
            dropdown[j].setSelection(Changes_1[i].getValue1());
        }
    }

    public void Screen5() {
        if(!loaded[4]) {
            loaded[4] = true;
            for(int i = 96; i < 120; i++)
                Changes_1[i] = new Modbus(getApplicationContext(), Address_1[i], 1);
        }

        setContentView(R.layout.modbus_alarm_config);

        loadSpinners = 0;

        Spinner[] dropdown =   {(Spinner) findViewById(R.id.spinner25),     (Spinner) findViewById(R.id.spinner26),
                                (Spinner) findViewById(R.id.spinner27),     (Spinner) findViewById(R.id.spinner28),
                                (Spinner) findViewById(R.id.spinner29),     (Spinner) findViewById(R.id.spinner30),
                                (Spinner) findViewById(R.id.spinner31),     (Spinner) findViewById(R.id.spinner32),
                                (Spinner) findViewById(R.id.spinner33),     (Spinner) findViewById(R.id.spinner34),
                                (Spinner) findViewById(R.id.spinner35),     (Spinner) findViewById(R.id.spinner36),
                                (Spinner) findViewById(R.id.spinner37),     (Spinner) findViewById(R.id.spinner38),
                                (Spinner) findViewById(R.id.spinner39),     (Spinner) findViewById(R.id.spinner40),
                                (Spinner) findViewById(R.id.spinner41),     (Spinner) findViewById(R.id.spinner42),
                                (Spinner) findViewById(R.id.spinner43),     (Spinner) findViewById(R.id.spinner44),
                                (Spinner) findViewById(R.id.spinner45),     (Spinner) findViewById(R.id.spinner46),
                                (Spinner) findViewById(R.id.spinner47),     (Spinner) findViewById(R.id.spinner48)};

        String[] items = new String[]{"Status Only", "Alarm If Zero", "Alarm If Nonzero", "Analog Low/High"};
        ArrayAdapter<String> adapterr = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, items);

        for(int j = 0, i = 96; j < 24; j++, i++) {
            dropdown[j].setAdapter(adapterr);
            dropdown[j].setOnItemSelectedListener(onSpinner5);
            dropdown[j].setSelection(Changes_1[i].getValue1());
        }
    }

    public void Screen6() {
        if(!loaded[5]) {
            loaded[5] = true;
            for(int i = 0; i < 24; i++)
                Changes_3[i] = new Modbus(getApplicationContext(), Address_3[i], 3);
        }

        setContentView(R.layout.modbus_calibration);

        EditText id[] =    {(EditText) findViewById(R.id.edittext1),    (EditText) findViewById(R.id.edittext2),
                            (EditText) findViewById(R.id.edittext3),    (EditText) findViewById(R.id.edittext4),
                            (EditText) findViewById(R.id.edittext5),    (EditText) findViewById(R.id.edittext6),
                            (EditText) findViewById(R.id.edittext7),    (EditText) findViewById(R.id.edittext8),
                            (EditText) findViewById(R.id.edittext9),    (EditText) findViewById(R.id.edittext10),
                            (EditText) findViewById(R.id.edittext11),   (EditText) findViewById(R.id.edittext12),
                            (EditText) findViewById(R.id.edittext13),   (EditText) findViewById(R.id.edittext14),
                            (EditText) findViewById(R.id.edittext15),   (EditText) findViewById(R.id.edittext16),
                            (EditText) findViewById(R.id.edittext17),   (EditText) findViewById(R.id.edittext18),
                            (EditText) findViewById(R.id.edittext19),   (EditText) findViewById(R.id.edittext20),
                            (EditText) findViewById(R.id.edittext21),   (EditText) findViewById(R.id.edittext22),
                            (EditText) findViewById(R.id.edittext23),   (EditText) findViewById(R.id.edittext24)};

        for(int i = 0; i < 24; i++) {
            id[i].setText("" + Changes_3[i].getValue3());
            final int index = i;
            id[i].addTextChangedListener(new TextWatcher() {
                @Override
                public void afterTextChanged(Editable s) {}

                @Override
                public void beforeTextChanged(CharSequence s, int start, int count, int after) {}

                @Override
                public void onTextChanged(CharSequence s, int start, int before, int count) {
                    if(count != 0 && count < 17) {
                        Changes_3[index].setValue(Float.parseFloat(s.toString()));
                        Changes_Bool_3[index] = true;
                        changes_made = true;
                    }
                }
            });
        }
    }

    public void Screen7() {
        if(!loaded[6]) {
            loaded[6] = true;
            for(int i = 24; i < 72; i++)
                Changes_3[i] = new Modbus(getApplicationContext(), Address_3[i], 3);
        }

        setContentView(R.layout.modbus_alarm_limits);

        EditText low[] =   {(EditText) findViewById(R.id.edittext1),    (EditText) findViewById(R.id.edittext3),
                            (EditText) findViewById(R.id.edittext5),    (EditText) findViewById(R.id.edittext7),
                            (EditText) findViewById(R.id.edittext9),    (EditText) findViewById(R.id.edittext11),
                            (EditText) findViewById(R.id.edittext13),   (EditText) findViewById(R.id.edittext15),
                            (EditText) findViewById(R.id.edittext17),   (EditText) findViewById(R.id.edittext19),
                            (EditText) findViewById(R.id.edittext21),   (EditText) findViewById(R.id.edittext23),
                            (EditText) findViewById(R.id.edittext25),   (EditText) findViewById(R.id.edittext27),
                            (EditText) findViewById(R.id.edittext29),   (EditText) findViewById(R.id.edittext31),
                            (EditText) findViewById(R.id.edittext33),   (EditText) findViewById(R.id.edittext35),
                            (EditText) findViewById(R.id.edittext37),   (EditText) findViewById(R.id.edittext39),
                            (EditText) findViewById(R.id.edittext41),   (EditText) findViewById(R.id.edittext43),
                            (EditText) findViewById(R.id.edittext45),   (EditText) findViewById(R.id.edittext47)};

        EditText high[] =  {(EditText) findViewById(R.id.edittext2),    (EditText) findViewById(R.id.edittext4),
                            (EditText) findViewById(R.id.edittext6),    (EditText) findViewById(R.id.edittext8),
                            (EditText) findViewById(R.id.edittext10),   (EditText) findViewById(R.id.edittext12),
                            (EditText) findViewById(R.id.edittext14),   (EditText) findViewById(R.id.edittext16),
                            (EditText) findViewById(R.id.edittext18),   (EditText) findViewById(R.id.edittext20),
                            (EditText) findViewById(R.id.edittext22),   (EditText) findViewById(R.id.edittext24),
                            (EditText) findViewById(R.id.edittext26),   (EditText) findViewById(R.id.edittext28),
                            (EditText) findViewById(R.id.edittext30),   (EditText) findViewById(R.id.edittext32),
                            (EditText) findViewById(R.id.edittext34),   (EditText) findViewById(R.id.edittext36),
                            (EditText) findViewById(R.id.edittext38),   (EditText) findViewById(R.id.edittext40),
                            (EditText) findViewById(R.id.edittext42),   (EditText) findViewById(R.id.edittext44),
                            (EditText) findViewById(R.id.edittext46),   (EditText) findViewById(R.id.edittext48)};

        for(int i = 0, l = 24, h = 48; i < 24; i++, l++, h++) {
            low[i].setText("" + Changes_3[l].getValue3());
            final int indexL = l;
            low[i].addTextChangedListener(new TextWatcher() {
                @Override
                public void afterTextChanged(Editable s) {}

                @Override
                public void beforeTextChanged(CharSequence s, int start, int count, int after) {}

                @Override
                public void onTextChanged(CharSequence s, int start, int before, int count) {
                    if(count != 0 && count < 17) {
                        Changes_3[indexL].setValue(Float.parseFloat(s.toString()));
                        Changes_Bool_3[indexL] = true;
                        changes_made = true;
                    }
                }
            });

            high[i].setText("" + Changes_3[h].getValue3());
            final int indexH = h;
            high[i].addTextChangedListener(new TextWatcher() {
                @Override
                public void afterTextChanged(Editable s) {}

                @Override
                public void beforeTextChanged(CharSequence s, int start, int count, int after) {}

                @Override
                public void onTextChanged(CharSequence s, int start, int before, int count) {
                    if(count != 0 && count < 17) {
                        Changes_3[indexL].setValue(Float.parseFloat(s.toString()));
                        Changes_Bool_3[indexL] = true;
                        changes_made = true;
                    }
                }
            });
        }
    }

    public void Screen8() {
        if(!loaded[7]) {
            loaded[7] = true;
            for(int i = 0; i < 24; i++)
                Changes_4[i] = new Modbus(getApplicationContext(), Address_4[i], 4);
        }

        setContentView(R.layout.modbus_name);

        EditText name[] =  {(EditText) findViewById(R.id.edittext1),    (EditText) findViewById(R.id.edittext2),
                            (EditText) findViewById(R.id.edittext3),    (EditText) findViewById(R.id.edittext4),
                            (EditText) findViewById(R.id.edittext5),    (EditText) findViewById(R.id.edittext6),
                            (EditText) findViewById(R.id.edittext7),    (EditText) findViewById(R.id.edittext8),
                            (EditText) findViewById(R.id.edittext9),    (EditText) findViewById(R.id.edittext10),
                            (EditText) findViewById(R.id.edittext11),   (EditText) findViewById(R.id.edittext12),
                            (EditText) findViewById(R.id.edittext13),   (EditText) findViewById(R.id.edittext14),
                            (EditText) findViewById(R.id.edittext15),   (EditText) findViewById(R.id.edittext16),
                            (EditText) findViewById(R.id.edittext17),   (EditText) findViewById(R.id.edittext18),
                            (EditText) findViewById(R.id.edittext19),   (EditText) findViewById(R.id.edittext20),
                            (EditText) findViewById(R.id.edittext21),   (EditText) findViewById(R.id.edittext22),
                            (EditText) findViewById(R.id.edittext23),   (EditText) findViewById(R.id.edittext24)};

        for(int i = 0; i < 24; i++) {
            name[i].setText("" + Changes_4[i].getValue4());
            final int index = i;
            name[i].addTextChangedListener(new TextWatcher() {
                @Override
                public void afterTextChanged(Editable s) {}

                @Override
                public void beforeTextChanged(CharSequence s, int start, int count, int after) {}

                @Override
                public void onTextChanged(CharSequence s, int start, int before, int count) {
                    if(count != 0 && count < 17) {
                        Changes_4[index].setValue(Integer.parseInt(s.toString()));
                        Changes_Bool_4[index] = true;
                        changes_made = true;
                    }
                }
            });
        }
    }

    public void Screen9() {
        if(!loaded[8]) {
            loaded[8] = true;
            for(int i = 24; i < 48; i++)
                Changes_4[i] = new Modbus(getApplicationContext(), Address_4[i], 4);
        }

        setContentView(R.layout.modbus_units);

        EditText uom[] =    {(EditText) findViewById(R.id.edittext1),   (EditText) findViewById(R.id.edittext2),
                            (EditText) findViewById(R.id.edittext3),    (EditText) findViewById(R.id.edittext4),
                            (EditText) findViewById(R.id.edittext5),    (EditText) findViewById(R.id.edittext6),
                            (EditText) findViewById(R.id.edittext7),    (EditText) findViewById(R.id.edittext8),
                            (EditText) findViewById(R.id.edittext9),    (EditText) findViewById(R.id.edittext10),
                            (EditText) findViewById(R.id.edittext11),   (EditText) findViewById(R.id.edittext12),
                            (EditText) findViewById(R.id.edittext13),   (EditText) findViewById(R.id.edittext14),
                            (EditText) findViewById(R.id.edittext15),   (EditText) findViewById(R.id.edittext16),
                            (EditText) findViewById(R.id.edittext17),   (EditText) findViewById(R.id.edittext18),
                            (EditText) findViewById(R.id.edittext19),   (EditText) findViewById(R.id.edittext20),
                            (EditText) findViewById(R.id.edittext21),   (EditText) findViewById(R.id.edittext22),
                            (EditText) findViewById(R.id.edittext23),   (EditText) findViewById(R.id.edittext24)};

        for(int j = 0, i = 24; j < 24; j++, i++) {
            uom[j].setText("" + Changes_4[i].getValue4());
            final int index = i;
            uom[j].addTextChangedListener(new TextWatcher() {
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

    AdapterView.OnItemSelectedListener onSpinner2 = new AdapterView.OnItemSelectedListener() {
        @Override
        public void onItemSelected(AdapterView<?> parent, View view, int pos, long id) {
            int i = 0;
            switch (parent.getId()) {
                case R.id.spinner1:
                    i = 24;
                    break;
                case R.id.spinner2:
                    i = 25;
                    break;
                case R.id.spinner3:
                    i = 26;
                    break;
                case R.id.spinner4:
                    i = 27;
                    break;
                case R.id.spinner5:
                    i = 28;
                    break;
                case R.id.spinner6:
                    i = 29;
                    break;
                case R.id.spinner7:
                    i = 30;
                    break;
                case R.id.spinner8:
                    i = 31;
                    break;
                case R.id.spinner9:
                    i = 32;
                    break;
                case R.id.spinner10:
                    i = 33;
                    break;
                case R.id.spinner11:
                    i = 34;
                    break;
                case R.id.spinner12:
                    i = 35;
                    break;
                case R.id.spinner13:
                    i = 36;
                    break;
                case R.id.spinner14:
                    i = 37;
                    break;
                case R.id.spinner15:
                    i = 38;;
                    break;
                case R.id.spinner16:
                    i = 39;
                    break;
                case R.id.spinner17:
                    i = 40;
                    break;
                case R.id.spinner18:
                    i = 41;
                    break;
                case R.id.spinner19:
                    i = 42;
                    break;
                case R.id.spinner20:
                    i = 43;
                    break;
                case R.id.spinner21:
                    i = 44;
                    break;
                case R.id.spinner22:
                    i = 45;
                    break;
                case R.id.spinner23:
                    i = 46;
                    break;
                case R.id.spinner24:
                    i = 47;
                    break;
            }
            if (loadSpinners > 23) {
                Changes_1[i].setValue(pos);
                Changes_Bool_1[i] = true;
                changes_made = true;
            } else {
                loadSpinners++;
            }
        }

        @Override
        public void onNothingSelected(AdapterView<?> parent) {

        }
    };

    AdapterView.OnItemSelectedListener onSpinner4 = new AdapterView.OnItemSelectedListener() {
        @Override
        public void onItemSelected(AdapterView<?> parent, View view, int pos, long id) {
            int i = 0;
            switch (parent.getId()) {
                case R.id.spinner49:
                    i = 72;
                    break;
                case R.id.spinner50:
                    i = 73;
                    break;
                case R.id.spinner51:
                    i = 74;
                    break;
                case R.id.spinner52:
                    i = 75;
                    break;
                case R.id.spinner53:
                    i = 76;
                    break;
                case R.id.spinner54:
                    i = 77;
                    break;
                case R.id.spinner55:
                    i = 78;
                    break;
                case R.id.spinner56:
                    i = 79;
                    break;
                case R.id.spinner57:
                    i = 80;
                    break;
                case R.id.spinner58:
                    i = 81;
                    break;
                case R.id.spinner59:
                    i = 82;
                    break;
                case R.id.spinner60:
                    i = 83;
                    break;
                case R.id.spinner61:
                    i = 84;
                    break;
                case R.id.spinner62:
                    i = 85;
                    break;
                case R.id.spinner63:
                    i = 86;
                    break;
                case R.id.spinner64:
                    i = 87;
                    break;
                case R.id.spinner65:
                    i = 88;
                    break;
                case R.id.spinner66:
                    i = 89;
                    break;
                case R.id.spinner67:
                    i = 90;
                    break;
                case R.id.spinner68:
                    i = 91;
                    break;
                case R.id.spinner69:
                    i = 92;
                    break;
                case R.id.spinner70:
                    i = 93;
                    break;
                case R.id.spinner71:
                    i = 94;
                    break;
                case R.id.spinner72:
                    i = 95;
                    break;
            }
            if (loadSpinners > 23) {
                Changes_1[i].setValue(pos);
                Changes_Bool_1[i] = true;
                changes_made = true;
            } else {
                loadSpinners++;
            }
        }

        @Override
        public void onNothingSelected(AdapterView<?> parent) {

        }
    };

    AdapterView.OnItemSelectedListener onSpinner5 = new AdapterView.OnItemSelectedListener() {
        @Override
        public void onItemSelected(AdapterView<?> parent, View view, int pos, long id) {
            int i = 0;
            switch (parent.getId()) {
                case R.id.spinner25:
                    i = 96;
                    break;
                case R.id.spinner26:
                    i = 97;
                    break;
                case R.id.spinner27:
                    i = 98;
                    break;
                case R.id.spinner28:
                    i = 99;
                    break;
                case R.id.spinner29:
                    i = 100;
                    break;
                case R.id.spinner30:
                    i = 101;
                    break;
                case R.id.spinner31:
                    i = 102;
                    break;
                case R.id.spinner32:
                    i = 103;
                    break;
                case R.id.spinner33:
                    i = 104;
                    break;
                case R.id.spinner34:
                    i = 105;
                    break;
                case R.id.spinner35:
                    i = 106;
                    break;
                case R.id.spinner36:
                    i = 107;
                    break;
                case R.id.spinner37:
                    i = 108;
                    break;
                case R.id.spinner38:
                    i = 109;
                    break;
                case R.id.spinner39:
                    i = 110;
                    break;
                case R.id.spinner40:
                    i = 111;
                    break;
                case R.id.spinner41:
                    i = 112;
                    break;
                case R.id.spinner42:
                    i = 113;
                    break;
                case R.id.spinner43:
                    i = 114;
                    break;
                case R.id.spinner44:
                    i = 115;
                    break;
                case R.id.spinner45:
                    i = 116;
                    break;
                case R.id.spinner46:
                    i = 117;
                    break;
                case R.id.spinner47:
                    i = 118;
                    break;
                case R.id.spinner48:
                    i = 119;
                    break;
            }
            if (loadSpinners > 23) {
                Changes_1[i].setValue(pos);
                Changes_Bool_1[i] = true;
                changes_made = true;
            } else {
                loadSpinners++;
            }
        }

        @Override
        public void onNothingSelected(AdapterView<?> parent) {

        }
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

    public void startNFC() { startActivity(new Intent(this, Nfc.class)); }

    public void startHome() { startActivity(new Intent(this, Home.class)); }
}