package com.example.edison.tts;

import android.content.Intent;
import android.content.Loader;
import android.speech.RecognizerIntent;
import android.speech.tts.TextToSpeech;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Locale;

import static android.R.attr.data;

public class MainActivity extends AppCompatActivity {
    TextView word;
    int result;
    String text;
    TextToSpeech tts;
    Spinner spinner, from;
    Locale selectedLang;
    ImageView init;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        word = (TextView) findViewById(R.id.textView);
        init = (ImageView) findViewById(R.id.imageView);
        spinner = (Spinner) findViewById(R.id.spinner);
        from = (Spinner) findViewById(R.id.spinner2);
        word.setText("");

        /*<item>English</item>
        <item>German</item>
        <item>Chinese</item>
        <item>French</item>
        <item>Japanese</item>
        <item>Italian</item>
        <item>Korean</item>
        <item>Taiwan</item>*/

        selectedLang = Locale.JAPANESE;

        from.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                switch (i){

                    case 0:
                        selectedLang = Locale.US;
                        break;
                    case 1:
                        selectedLang = Locale.GERMAN;
                        break;
                    case 2:
                        selectedLang = Locale.CHINESE;
                        break;
                    case 3:
                        selectedLang = Locale.FRENCH;
                        break;
                    case 4:
                        selectedLang = Locale.JAPANESE;
                        break;
                    case 5:
                        selectedLang = Locale.ITALIAN;
                        break;
                    case 6:
                        selectedLang = Locale.KOREAN;
                        break;
                    case 7:
                        selectedLang = Locale.TAIWAN;
                        break;
                }

            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
                selectedLang = Locale.US;
            }
        });
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
               switch(i){
                   case 0:
                       tts = new TextToSpeech(MainActivity.this, new TextToSpeech.OnInitListener() {
                           @Override
                           public void onInit(int i) {
                               if(i == TextToSpeech.SUCCESS){
                                   result = tts.setLanguage(Locale.US);
                               }
                               else{
                                   Toast.makeText(MainActivity.this, "Feature Not Supported", Toast.LENGTH_SHORT).show();
                               }
                           }
                       });
                       break;
                   case 1:
                       tts = new TextToSpeech(MainActivity.this, new TextToSpeech.OnInitListener() {
                           @Override
                           public void onInit(int i) {
                               if(i == TextToSpeech.SUCCESS){
                                   result = tts.setLanguage(Locale.GERMAN);
                               }
                               else{
                                   Toast.makeText(MainActivity.this, "Feature Not Supported", Toast.LENGTH_SHORT).show();
                               }
                           }
                       });
                       break;
                   case 2:
                       tts = new TextToSpeech(MainActivity.this, new TextToSpeech.OnInitListener() {
                           @Override
                           public void onInit(int i) {
                               if(i == TextToSpeech.SUCCESS){
                                   result = tts.setLanguage(Locale.CHINESE);
                               }
                               else{
                                   Toast.makeText(MainActivity.this, "Feature Not Supported", Toast.LENGTH_SHORT).show();
                               }
                           }
                       });
                       break;
                   case 3:
                       tts = new TextToSpeech(MainActivity.this, new TextToSpeech.OnInitListener() {
                           @Override
                           public void onInit(int i) {
                               if(i == TextToSpeech.SUCCESS){
                                   result = tts.setLanguage(Locale.FRENCH);
                               }
                               else{
                                   Toast.makeText(MainActivity.this, "Feature Not Supported", Toast.LENGTH_SHORT).show();
                               }
                           }
                       });
                       break;
                   case 4:
                       tts = new TextToSpeech(MainActivity.this, new TextToSpeech.OnInitListener() {
                           @Override
                           public void onInit(int i) {
                               if(i == TextToSpeech.SUCCESS){
                                   result = tts.setLanguage(Locale.JAPANESE);
                               }
                               else{
                                   Toast.makeText(MainActivity.this, "Feature Not Supported", Toast.LENGTH_SHORT).show();
                               }
                           }
                       });
                       break;
                   case 5:
                       tts = new TextToSpeech(MainActivity.this, new TextToSpeech.OnInitListener() {
                           @Override
                           public void onInit(int i) {
                               if(i == TextToSpeech.SUCCESS){
                                   result = tts.setLanguage(Locale.ITALIAN);
                               }
                               else{
                                   Toast.makeText(MainActivity.this, "Feature Not Supported", Toast.LENGTH_SHORT).show();
                               }
                           }
                       });
                       break;
                   case 6:
                       tts = new TextToSpeech(MainActivity.this, new TextToSpeech.OnInitListener() {
                           @Override
                           public void onInit(int i) {
                               if(i == TextToSpeech.SUCCESS){
                                   result = tts.setLanguage(Locale.KOREAN);
                               }
                               else{
                                   Toast.makeText(MainActivity.this, "Feature Not Supported", Toast.LENGTH_SHORT).show();
                               }
                           }
                       });
                       break;
                   case 7:
                       tts = new TextToSpeech(MainActivity.this, new TextToSpeech.OnInitListener() {
                           @Override
                           public void onInit(int i) {
                               if(i == TextToSpeech.SUCCESS){
                                   result = tts.setLanguage(Locale.TRADITIONAL_CHINESE);
                               }
                               else{
                                   Toast.makeText(MainActivity.this, "Feature Not Supported", Toast.LENGTH_SHORT).show();
                               }
                           }
                       });
                       break;

               }

                //TTS(view);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }

        });


    }





    public   void TTS(View v){

        if(word.equals("")){
            Toast.makeText(this, "Input Required", Toast.LENGTH_SHORT).show();
        }

        else{
        switch (v.getId()) {
            case R.id.imageView2:
                if (result == TextToSpeech.LANG_MISSING_DATA || result == TextToSpeech.LANG_NOT_SUPPORTED) {
                    Toast.makeText(this, "Feature not supported.", Toast.LENGTH_SHORT).show();
                } else {
                    text = word.getText().toString();
                    tts.speak(text, TextToSpeech.QUEUE_FLUSH, null);
                }
                break;
        }}
    }


    public void getSpeechInput(View view) {
        Intent i = new Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH);
        i.putExtra(RecognizerIntent.EXTRA_LANGUAGE_MODEL, RecognizerIntent.LANGUAGE_MODEL_FREE_FORM);
        i.putExtra(RecognizerIntent.EXTRA_LANGUAGE, selectedLang);

        if(i.resolveActivity(getPackageManager()) != null){

            startActivityForResult(i, 10);
        }
        else{
            Toast.makeText(this, "Device Not Supported", Toast.LENGTH_SHORT).show();
        }


        TTS(view);



    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data){

        switch (requestCode){
            case 10:

                if(resultCode == RESULT_OK && data != null){

                    ArrayList<String> res = data.getStringArrayListExtra(RecognizerIntent.EXTRA_RESULTS);
                    word.setText(res.get(0));

                }
                break;
        }
    }



    @Override
    protected void onDestroy(){
        super.onDestroy();
        if(tts == null){
            tts.stop();
            tts.shutdown();
        }
    }
}
