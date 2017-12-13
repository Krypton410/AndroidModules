package com.example.edison.bfit;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

/**
 * Created by Edison on 08/10/2017.
 */

public class DBHelper extends SQLiteOpenHelper {
    public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "Storage.db";
    public static final String TABLE_NAME = "Data_Table";
    public static final String ID = "ID"; //1st COL
    public static final String NAME = "NAME"; // 2nd Col
    public static final String Gender = "GENDER"; // 3rd Col
    public static final String Age = "AGE"; // 4th Col
    public static final String Height = "HEIGHT"; // Fifth Col
    public static final String Weight = "WEIGHT"; //6th Col

    public DBHelper(Context context){
        super(context, DATABASE_NAME, null, DATABASE_VERSION);


    }
    public void onCreate(SQLiteDatabase db){
        String sql = "Create TABLE " + TABLE_NAME + " (ID INTEGER PRIMARY KEY AUTOINCREMENT, NAME TEXT, GENDER TEXT, AGE INTEGER,  HEIGHT REAL, WEIGHT REAL)";

        db.execSQL(sql);

    }

    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion){
        db.execSQL("DROP IF TABLE EXISTS " + TABLE_NAME);
        onCreate(db);
    }
    public void onDowngrade(SQLiteDatabase db, int oldVersion, int newVersion){
        onUpgrade(db, oldVersion, newVersion);

    }

    public boolean insertData(String name, String gender, int age, int ft, int inch, double weight){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(NAME, name);
        contentValues.put(Gender, gender);
        contentValues.put(Age, age);
        contentValues.put(Height, ft + (inch * 12));
        contentValues.put(Weight, weight);
        long result = db.insert(TABLE_NAME, null, contentValues);
        if(result == -1){
            return false;

        }
        else {return true;}



    }
    public Cursor getAllData(){
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor res = db.rawQuery("select * from " + TABLE_NAME, null);
        return res;

    }
    public boolean updateData(String id,String name, String gender, int age, int ft, int inch, double weight){
    SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(ID, id);
        contentValues.put(NAME, name);
        contentValues.put(Gender, gender);
        contentValues.put(Age, age);
        contentValues.put(Height, ft + (inch * 12));
        contentValues.put(Weight, weight);
        db.update(TABLE_NAME, contentValues, "id = ?", new String[] {id});
        return true;

    }

    public Integer deleteData(String id){



        SQLiteDatabase db = this.getWritableDatabase();
        return db.delete(TABLE_NAME, "ID = ?", new String[] {id});
    }
}
