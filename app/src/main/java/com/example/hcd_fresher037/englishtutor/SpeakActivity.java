package com.example.hcd_fresher037.englishtutor;

import android.app.Activity;
import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import android.widget.Toast;

import java.util.Locale;
import java.util.UUID;


public class SpeakActivity extends Activity {
    private TextToSpeech textToSpeech;
    private EditText editText_text;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.speak);

        editText_text = (EditText) findViewById(R.id.editText);
        Button button = (Button) findViewById(R.id.button);
        textToSpeech = new TextToSpeech(getApplicationContext(), new TextToSpeech.OnInitListener() {
            @Override
            public void onInit(int status) {
                setTextToSpeechLanguage();

            }
        });

        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                speakOut();
            }
        });
    }

    public void onPause() {
        if (textToSpeech != null) {
            textToSpeech.stop();
            textToSpeech.shutdown();
        }
        super.onPause();
    }

    private void speakOut() {

        String toSpeak = editText_text.getText().toString();
        String utteranceId = UUID.randomUUID().toString();
        textToSpeech.speak(toSpeak, TextToSpeech.QUEUE_FLUSH, null, utteranceId);
    }

    private void setTextToSpeechLanguage() {
        int currentLanguage = textToSpeech.setLanguage(Locale.US);
        Toast.makeText(this, "Please type  " + currentLanguage, Toast.LENGTH_SHORT).show();
    }
}

