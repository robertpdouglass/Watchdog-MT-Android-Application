package com.sentrytechnologies.bobbydouglass.watchdogmt;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class Home extends AppCompatActivity {

    public static int Selected = -1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home);

        final String PREFS_NAME = "Preferences";
        SharedPreferences settings = getSharedPreferences(PREFS_NAME, 0);
        boolean firstTime = false;

        if (settings.getBoolean("firstTime", true)) {
            firstTime = true;
            settings.edit().putBoolean("firstTime", false).commit();
        }
        new Modbus(getApplicationContext(), firstTime);

        Selected = -1;
    }

    @Override
    public void onBackPressed() {
        finish();
        System.exit(0);
    }

    public void status(View view) {
        startActivity(new Intent(this, Status.class));
    }

    public void local(View view) {
        Selected = 1;
        startActivity(new Intent(this, Program.class));
    }

    public void modbus(View view) {
        Selected = 2;
        startActivity(new Intent(this, Program2.class));
    }

    public void settings(View view) {

    }
}
