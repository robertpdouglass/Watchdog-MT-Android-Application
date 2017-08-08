package com.sentrytechnologies.bobbydouglass.watchdogmt;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import org.json.JSONException;
import org.json.JSONObject;
import java.util.ArrayList;
import java.util.List;

public class JSON extends AppCompatActivity {

    static List<Modbus> changes;
    static JSONObject jsonObject;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        changes = new ArrayList<Modbus>();
        jsonObject = new JSONObject();
    }

    public void addModbus(Modbus mb) {
        changes.add(mb);
    }

    public void send() {
        createJsonObject();
        sendJsonObject();
        awaitRequest();
    }

    public void createJsonObject() {
        for (int i = 0; i < changes.size(); i++) {
            if (changes.get(i).getType() == 1) {
                try {
                    jsonObject.put("" + changes.get(i).getAddress(), changes.get(i).getValue1());
                } catch(JSONException e) {}
            }
            else if (changes.get(i).getType() == 2) {
                try {
                    jsonObject.put("" + changes.get(i).getAddress(), changes.get(i).getValue2());
                } catch(JSONException e) {}
            }
            else if (changes.get(i).getType() == 3) {
                try {
                    jsonObject.put("" + changes.get(i).getAddress(), changes.get(i).getValue3());
                } catch(JSONException e) {}
            }
            else {
                try {
                    jsonObject.put("" + changes.get(i).getAddress(), changes.get(i).getValue4());
                } catch(JSONException e) {}
            }
        }
    }

    public void sendJsonObject() {

    }

    public void awaitRequest() {

    }

}
