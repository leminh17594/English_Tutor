package com.example.hcd_fresher037.englishtutor.Topic;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.widget.TextView;

import com.example.hcd_fresher037.englishtutor.Database;
import com.example.hcd_fresher037.englishtutor.R;

/**
 * Created by HCD-Fresher037 on 1/12/2017.
 */

public class TopicDetail extends Activity {
    final String DATABASE_NAME = "data.db";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.topic_detail);
        initUI();
    }

    private void initUI() {

        TextView tvtpName = (TextView) findViewById(R.id.tv_tpName);
        TextView tvtpInfo = (TextView) findViewById(R.id.tv_tpInfo);
        TextView tvtpQues1 = (TextView) findViewById(R.id.tv_tpQues1);
        TextView tvtpQues2 = (TextView) findViewById(R.id.tv_tpQues2);
        TextView tvtpQues3 = (TextView) findViewById(R.id.tv_tpQues3);

        Intent intent = getIntent();
        int id = intent.getIntExtra("ID",-1);
        SQLiteDatabase database = Database.initDatabase(this, DATABASE_NAME);
        Cursor cursor = database.rawQuery("SELECT * FROM Topic WHERE ID = ? ",new String[]{id + ""});
        cursor.moveToFirst();
        String tpName = cursor.getString(1);
        String tpIntro = cursor.getString(2);
        String tpQues1 = cursor.getString(3);
        String tpQues2 = cursor.getString(4);
        String tpQues3 = cursor.getString(5);

        tvtpName.setText(tpName);
        tvtpInfo.setText(tpIntro);
        tvtpQues1.setText(tpQues1);
        tvtpQues2.setText(tpQues2);
        tvtpQues3.setText(tpQues3);

    }
}
