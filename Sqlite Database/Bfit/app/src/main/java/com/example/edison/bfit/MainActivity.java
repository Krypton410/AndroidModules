package com.example.edison.bfit;

import android.app.ActionBar;
import android.content.ContentValues;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.media.Image;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.NumberPicker;
import android.widget.Spinner;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {




    DBHelper dbHelper;
    ImageButton con,back;
    EditText name, age, weight, id;
    NumberPicker feet, inches;
    Spinner gender,units;
    Button btn,updataData, delete;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().hide();
        delete = (Button) findViewById(R.id.buttonDelete);
        updataData = (Button) findViewById(R.id.updates);
        btn = (Button) findViewById(R.id.button);
        back = (ImageButton) findViewById(R.id.bck);
        con = (ImageButton) findViewById(R.id.imageButton2);
        name = (EditText) findViewById(R.id.theName);
        age = (EditText) findViewById(R.id.theAge);
        weight = (EditText) findViewById(R.id.theWeight);
        feet = (NumberPicker) findViewById(R.id.theFeet);
        inches = (NumberPicker) findViewById(R.id.theInches);
        gender = (Spinner) findViewById(R.id.genderPicker);
        units = (Spinner) findViewById(R.id.unitSpinner);
        name.setGravity(Gravity.CENTER_HORIZONTAL);
        age.setGravity(Gravity.CENTER_HORIZONTAL);
        weight.setGravity(Gravity.CENTER_HORIZONTAL);
        id = (EditText) findViewById(R.id.editTextID);
        feet.setMinValue(1);
        feet.setMaxValue(7);
        inches.setMinValue(0);
        inches.setMaxValue(12);

        dbHelper = new DBHelper(this);

        SQLiteDatabase db = dbHelper.getWritableDatabase();


        con.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dbHelper.insertData(name.getText().toString(),
                        gender.getSelectedItem().toString(),
                        Integer.parseInt(age.getText().toString()),
                        feet.getValue(),
                        inches.getValue(),
                        Integer.parseInt(weight.getText().toString()));


                AddData();
                //  Intent i = new Intent(MainActivity.this, Main2Activity.class);
                //startActivity(i);
                //finish();


            }
        });
        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Integer deletedRows = dbHelper.deleteData(id.getText().toString());

                if(deletedRows > 0){
                    Toast.makeText(MainActivity.this, "User Deleted", Toast.LENGTH_SHORT).show();
                }
                else
                {
                    Toast.makeText(MainActivity.this, "Not Deleted", Toast.LENGTH_SHORT).show();
                }
            }
        });




        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, Home.class);
                startActivity(i);
                finish();
            }
        });

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                viewAll();
            }
        });


        updataData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                boolean isUpdate = dbHelper.updateData(id.getText().toString(), name.getText().toString(),
                        gender.getSelectedItem().toString(),
                        Integer.parseInt(age.getText().toString()),
                        feet.getValue(),
                        inches.getValue(),
                        Integer.parseInt(weight.getText().toString()));

                if (isUpdate == true) {

                    Toast.makeText(MainActivity.this, "User UPDATED", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(MainActivity.this, "Not Updated", Toast.LENGTH_SHORT).show();
                }
            }
        });

        }


    public void AddData(){
        con.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                boolean isInserted =  dbHelper.insertData(name.getText().toString(),
                        gender.getSelectedItem().toString(),
                        Integer.parseInt(age.getText().toString()),
                        feet.getValue(),
                        inches.getValue(),
                        Integer.parseInt(weight.getText().toString()));
                if(isInserted == true){
                    Toast.makeText(MainActivity.this, "Succesfully Added", Toast.LENGTH_SHORT).show();

                }
                else {

                    Toast.makeText(MainActivity.this, "Adding Unsuccessful", Toast.LENGTH_SHORT).show();

                }







            }
        });}
/*    public void updateUser(){
        updataData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                boolean isUpdate = dbHelper.updateData(id.getText().toString(), name.getText().toString(),
                        gender.getSelectedItem().toString(),
                        Integer.parseInt(age.getText().toString()),
                        feet.getValue(),
                        inches.getValue(),
                        Integer.parseInt(weight.getText().toString()));

                if (isUpdate == true) {

                    Toast.makeText(MainActivity.this, "User UPDATED", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(MainActivity.this, "Not Updated", Toast.LENGTH_SHORT).show();
                }
            }
        });


    }*/

    public void viewAll(){
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Cursor res = dbHelper.getAllData();
                if(res.getCount() == 0 ){
                    return;
                }
                StringBuffer buffer = new StringBuffer();
                while(res.moveToNext()){
                    buffer.append("ID: " + res.getString(0)+ "\n");
                    buffer.append("Name : " + res.getString(1)+ "\n");
                    buffer.append("Gender: " + res.getString(2)+ "\n");
                    buffer.append("Age : " + res.getString(3)+ "\n");
                    buffer.append("Height: " + res.getString(4)+ "\n");
                    buffer.append("Weight : " + res.getString(5)+ "\n");

                }
                show("Data", buffer.toString());
//                Intent i = new Intent(MainActivity.this, Viewer.class);
//                i.putExtra("get", buffer.toString());
//                startActivity(i);

            }
        });


    }



    public void show(String title, String Message){

        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setCancelable(true);

        builder.setTitle(title);
        builder.setMessage(Message);
        builder.show();



    }


}
