package com.sentrytechnologies.bobbydouglass.watchdogmt;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class Modbus extends SQLiteOpenHelper {

    int device = 1;
    int index;
    int type;
    int address;
    boolean saved = false;
    int value1;
    long value2;
    float value3;
    String value4;

    Context context;
    SQLiteDatabase sql;
    public static final String TABLE_NAME = "watchdogMT";
    public static final String baseName = "modbus_";
    public static final int DATABASE_VERSION = 6;
    public static final String SQL_DELETE_ENTRIES = "DROP TABLE IF EXISTS " + TABLE_NAME;
    public static final String DATABASE_NAME = "Modbus.db";

    public Modbus(Context c, boolean first) {
        super(c, DATABASE_NAME, null, DATABASE_VERSION);
        sql = getWritableDatabase();
        context = c;
        if(first) {
            constructSQLiteTable(sql);
            insertValues();
        }
        readValues();
    }

    public Modbus(Context c, int add, int t) {
        super(c, DATABASE_NAME, null, DATABASE_VERSION);
        sql = getWritableDatabase();
        context = c;
        type = t;
        findAddress(add);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {}

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(SQL_DELETE_ENTRIES);
        onCreate(db);
    }

    @Override
    public void onDowngrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        onUpgrade(db, oldVersion, newVersion);
    }

    public void constructSQLiteTable(SQLiteDatabase db) {
        String str = "CREATE TABLE IF NOT EXISTS " + TABLE_NAME + "(id INTEGER PRIMARY KEY, ";
        str = str + "name TEXT, ";
        for(int i = 0; i < Modbus_Values.Size_1; i++)
            str = str + baseName + Integer.toString(Modbus_Values.Address_1[i]) + " INTEGER, ";
        for(int i = 0; i < Modbus_Values.Size_2; i++)
            str = str + baseName + Integer.toString(Modbus_Values.Address_2[i]) + " INTEGER, ";
        for(int i = 0; i < Modbus_Values.Size_3; i++)
            str = str + baseName + Integer.toString(Modbus_Values.Address_3[i]) + " REAL, ";
        for(int i = 0; i < Modbus_Values.Size_4 - 1; i++)
            str = str + baseName + Integer.toString(Modbus_Values.Address_4[i]) + " TEXT, ";
        str = str + baseName + Integer.toString(Modbus_Values.Address_4[Modbus_Values.Size_4 - 1]) + " TEXT)";
        db.execSQL(str);
    }

    public void insertValues() {
        ContentValues cv = new ContentValues();
        cv.put("name", "Watchdog #" + device);
        for(int i = 0; i < Modbus_Values.Size_1; i++)
            cv.put(baseName + Modbus_Values.Address_1[i], Modbus_Values.Modbus_1[i]);
        for(int i = 0; i < Modbus_Values.Size_2; i++)
            cv.put(baseName + Modbus_Values.Address_2[i], Modbus_Values.Modbus_2[i]);
        for(int i = 0; i < Modbus_Values.Size_3; i++)
            cv.put(baseName + Modbus_Values.Address_3[i], Modbus_Values.Modbus_3[i]);
        for(int i = 0; i < Modbus_Values.Size_4; i++)
            cv.put(baseName + Modbus_Values.Address_4[i], Modbus_Values.Modbus_4[i]);
        sql.insert(TABLE_NAME, null, cv);
    }

    public void updateValue() {
        ContentValues cv = new ContentValues();
        if(type == 1)
            cv.put(baseName + address, value1);
        else if(type == 2)
            cv.put(baseName + address, value2);
        else if(type == 3)
            cv.put(baseName + address, value3);
        else
            cv.put(baseName + address, value4);
        sql.update(TABLE_NAME, cv, "id = ?", new String[] { Integer.toString(device) });
    }

    public void readValues() {
        String selectQuery = "SELECT * FROM " + TABLE_NAME;
        sql = getReadableDatabase();
        Cursor c = sql.rawQuery(selectQuery, null);
        c.moveToFirst();
        int i = 2;
        for(int j = 0; j < Modbus_Values.Size_1; j++, i++)
            Modbus_Values.Modbus_1[j] = c.getInt(i);
        for(int j = 0; j < Modbus_Values.Size_2; j++, i++)
            Modbus_Values.Modbus_2[j] = c.getLong(i);
        for(int j = 0; j < Modbus_Values.Size_3; j++, i++)
            Modbus_Values.Modbus_3[j] = c.getFloat(i);
        for(int j = 0; j < Modbus_Values.Size_4; j++, i++)
            Modbus_Values.Modbus_4[j] = c.getString(i);
        c.close();
    }

    public void findAddress(int add) {
        if(type == 1) {
            for (int i = 0; i < Modbus_Values.Size_1; i++) {
                if (Modbus_Values.Address_1[i] == add) {
                    address = add;
                    index = i;
                    value1 = Modbus_Values.Modbus_1[index];
                    return;
                }
            }
        }
        else if(type == 2) {
            for (int i = 0; i < Modbus_Values.Size_2; i++) {
                if (Modbus_Values.Address_2[i] == add) {
                    address = add;
                    index = i;
                    value2 = Modbus_Values.Modbus_2[index];
                    return;
                }
            }
        }
        else if(type == 3) {
            for (int i = 0; i < Modbus_Values.Size_3; i++) {
                if (Modbus_Values.Address_3[i] == add) {
                    address = add;
                    index = i;
                    value3 = Modbus_Values.Modbus_3[index];
                    return;
                }
            }
        }
        else {
            for (int i = 0; i < Modbus_Values.Size_4; i++) {
                if (Modbus_Values.Address_4[i] == add) {
                    address = add;
                    index = i;
                    value4 = Modbus_Values.Modbus_4[index];
                    return;
                }
            }
        }
        Log.e("ERROR", "" + add + " DOES NOT EXIST");
    }

    public void save() {
        updateValue();
    }

    public int getAddress() { return address; }

    public int getValue1() { return value1; }

    public long getValue2() { return value2; }

    public float getValue3() { return value3; }

    public String getValue4() { return value4; }

    public void setValue(int val) { value1 = val; }

    public void setValue(long val) { value2 = val; }

    public void setValue(float val) { value3 = val; }

    public void setValue(String val) { value4 = val; }
}
