package com.sentrytechnologies.bobbydouglass.watchdogmt;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.MotionEvent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class Program extends AppCompatActivity {

    public static final int SizeX =             3;
    public static final int SizeY =             8;

    public static Modbus[][] Changes =          new Modbus[SizeX][SizeY];
    public static boolean[][] Changes_Bool =  {{false,  false,  false,  false,  false,  false,  false,  false},
                                               {false,  false,  false,  false,  false,  false,  false,  false},
                                               {false,  false,  false,  false,  false,  false,  false,  false}};
    public static int[][] Changes_Add =       {{10100,  10102,  10104,  10106,  10108,  10110,  10112,  10114},
                                               {12000,  12001,  12002,  12003,  12004,  12005,  12006,  12007},
                                               {14000,  14001,  14002,  14003,  14004,  14005,  14006,  14007}};
    public static int[] Changes_Type =         {1,      1,      3};
    int position =                              1;
    int loadedSpinners =                        0;
    boolean Changes_Made =                      false;
    boolean pulse =                             false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        for(int i = 0; i < SizeX; i++)
            for(int j = 0; j < SizeY; j++)
                Changes[i][j] = new Modbus(getApplicationContext(), Changes_Add[i][j], Changes_Type[i]);

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
        if(position > 1 && position < 4) {
            position--;
            if(position == 1)
                Screen1();
            else if(position == 2)
                Screen2();
            else
                Toast.makeText(this, "OUT OF BOUNDS", Toast.LENGTH_SHORT).show();
        }
        else
            Toast.makeText(this, "Cannot move farther left", Toast.LENGTH_SHORT).show();
    }

    public void right(View view) {
        if(position > 0 && position < 3) {
            position++;
            if(position == 2)
                Screen2();
            else if(position == 3)
                if(pulse)
                    Screen3();
                else
                    Toast.makeText(this, "Pulse Multiplier Not Selected For Any Inputs", Toast.LENGTH_SHORT).show();
            else
                Toast.makeText(this, "OUT OF BOUNDS", Toast.LENGTH_SHORT).show();
        }
        else
            Toast.makeText(this, "Cannot move farther right", Toast.LENGTH_SHORT).show();
    }

    public void Screen1() {
        final int x = 0;
        loadedSpinners = 0;
        setContentView(R.layout.local_input_01_mode);

        Spinner[] dropdown =   {(Spinner) findViewById(R.id.mode_spinner_1),    (Spinner) findViewById(R.id.mode_spinner_2),
                                (Spinner) findViewById(R.id.mode_spinner_3),    (Spinner) findViewById(R.id.mode_spinner_4),
                                (Spinner) findViewById(R.id.mode_spinner_5),    (Spinner) findViewById(R.id.mode_spinner_6),
                                (Spinner) findViewById(R.id.mode_spinner_7),    (Spinner) findViewById(R.id.mode_spinner_8)};
        String[] items = new String[]{"0 = Disabled", "1 = Normally Open", "2 = Normally Closed", "3 = Pulse Count"};
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, items);
        for(int i = 0; i < 8; i++) {
            final int j = i;
            dropdown[i].setAdapter(adapter);
            dropdown[i].setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                @Override
                public void onItemSelected(AdapterView<?> adapterView, View view, int position, long id) {
                    if(loadedSpinners > 7) {
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

    public void Screen2() {
        final int x = 1;
        setContentView(R.layout.local_input_02_recog);

        final EditText[] e =   {(EditText) findViewById(R.id.recog_edittext_1), (EditText) findViewById(R.id.recog_edittext_2),
                                (EditText) findViewById(R.id.recog_edittext_3), (EditText) findViewById(R.id.recog_edittext_4),
                                (EditText) findViewById(R.id.recog_edittext_5), (EditText) findViewById(R.id.recog_edittext_6),
                                (EditText) findViewById(R.id.recog_edittext_7), (EditText) findViewById(R.id.recog_edittext_8)};
        for(int i = 0; i < 8; i++) {
            final int j = i;
            e[i].setText("" + (Changes[x][j].getValue1()));
            e[i].addTextChangedListener(new TextWatcher() {
                @Override
                public void afterTextChanged(Editable s) {}
                @Override
                public void beforeTextChanged(CharSequence s, int start, int count, int after) {}
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

        final Button[][] button = {{(Button) findViewById(R.id.recog_neg_1),    (Button) findViewById(R.id.recog_neg_2),
                                    (Button) findViewById(R.id.recog_neg_3),    (Button) findViewById(R.id.recog_neg_4),
                                    (Button) findViewById(R.id.recog_neg_5),    (Button) findViewById(R.id.recog_neg_6),
                                    (Button) findViewById(R.id.recog_neg_7),    (Button) findViewById(R.id.recog_neg_8)},
                                   {(Button) findViewById(R.id.recog_neg_1),    (Button) findViewById(R.id.recog_neg_2),
                                    (Button) findViewById(R.id.recog_neg_3),    (Button) findViewById(R.id.recog_neg_4),
                                    (Button) findViewById(R.id.recog_neg_5),    (Button) findViewById(R.id.recog_neg_6),
                                    (Button) findViewById(R.id.recog_neg_7),    (Button) findViewById(R.id.recog_neg_8)}};
        for(int i = 0; i < 8; i++) {
            for(int j = 0; j < 2; j++) {
                final int l = i, k = j;
                button[j][i].setOnTouchListener(new Button.OnTouchListener() {
                    @Override
                    public boolean onTouch(View v, MotionEvent event) {
                        switch (event.getAction()) {
                            case MotionEvent.ACTION_DOWN:
                                if (Build.VERSION.SDK_INT >= 22)
                                    button[k][l].setBackground(getDrawable(R.drawable.material_button_red));
                                else
                                    button[k][l].setBackground(getResources().getDrawable(R.drawable.material_button_red));

                                if(k == 0)
                                    Changes[x][l].setValue1((short) (Changes[x][l].getValue1() - 1));
                                else
                                    Changes[x][l].setValue1((short) (Changes[x][l].getValue1() + 1));
                                Changes_Bool[x][l] = true;
                                Changes_Made = true;

                                e[l].setText("" + Changes[x][l].getValue1());
                                break;
                            case MotionEvent.ACTION_UP:
                                if (Build.VERSION.SDK_INT >= 22)
                                    button[k][l].setBackground(getDrawable(R.drawable.material_spinner_bg));
                                else
                                    button[k][l].setBackground(getResources().getDrawable(R.drawable.material_spinner_bg));
                                break;
                        }
                        return false;
                    }
                });
            }
        }
    }

    public void Screen3() {
        final int x = 2;
        setContentView(R.layout.local_input_03_pulse);

        EditText[] e = {(EditText) findViewById(R.id.pulse_edittext_1), (EditText) findViewById(R.id.pulse_edittext_2),
                        (EditText) findViewById(R.id.pulse_edittext_3), (EditText) findViewById(R.id.pulse_edittext_4),
                        (EditText) findViewById(R.id.pulse_edittext_5), (EditText) findViewById(R.id.pulse_edittext_6),
                        (EditText) findViewById(R.id.pulse_edittext_7), (EditText) findViewById(R.id.pulse_edittext_8)};

        for(int i = 0; i < 8; i++) {
            final int j = i;
            if(Changes[x][j].getValue1() == 3) {
                e[j].setEnabled(true);
                e[j].setClickable(true);

                e[j].setText("" + Changes[x][j].getValue3());
                e[j].addTextChangedListener(new TextWatcher() {
                    @Override
                    public void afterTextChanged(Editable s) {}
                    @Override
                    public void beforeTextChanged(CharSequence s, int start, int count, int after) {}
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
            else {
                e[j].setEnabled(false);
                e[j].setClickable(false);
            }
        }
    }
}