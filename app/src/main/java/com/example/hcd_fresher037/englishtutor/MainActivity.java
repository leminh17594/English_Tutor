package com.example.hcd_fresher037.englishtutor;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.example.hcd_fresher037.englishtutor.Expression.ExpressionActivity;
import com.example.hcd_fresher037.englishtutor.Topic.TopicActivity;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button topicBtn = (Button) findViewById(R.id.topicBtn);
        Button grammarBtn = (Button) findViewById(R.id.expressBtn);
        Button speakBtn = (Button) findViewById(R.id.speakBtn);
        Button aboutBtn = (Button) findViewById(R.id.aboutBtn);

        topicBtn.setOnClickListener(this);
        grammarBtn.setOnClickListener(this);
        speakBtn.setOnClickListener(this);
        aboutBtn.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        Intent intent, intent1, intent2, intent3;

        switch (view.getId()){

            case R.id.topicBtn:
                intent = new Intent(MainActivity.this, TopicActivity.class);
                startActivity(intent);
                break;
            case R.id.expressBtn:
                intent1 = new Intent(MainActivity.this,ExpressionActivity.class);
                startActivity(intent1);
                break;
            case R.id.speakBtn:
                intent2 = new Intent(MainActivity.this, SpeakActivity.class);
                startActivity(intent2);
                break;
            case R.id.aboutBtn:
                intent3 = new Intent(MainActivity.this, AboutUs.class);
                startActivity(intent3);
                break;
        }



    }
}
