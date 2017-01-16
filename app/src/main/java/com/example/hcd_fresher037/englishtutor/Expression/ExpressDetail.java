package com.example.hcd_fresher037.englishtutor.Expression;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.widget.TextView;

import com.example.hcd_fresher037.englishtutor.Database;
import com.example.hcd_fresher037.englishtutor.R;

/**
 * Created by Le Minh on 1/16/2017.
 */
public class ExpressDetail extends Activity{
    final String DATABASE_NAME = "data.db";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.express_detail);

        TextView exNameD = (TextView) findViewById(R.id.ex_nameD);
        TextView exDetail1 = (TextView) findViewById(R.id.ex_detail1);
        TextView exDetail2 = (TextView) findViewById(R.id.ex_detail2);
        TextView exDetail3 = (TextView) findViewById(R.id.ex_detail3);
        TextView exDetail4 = (TextView) findViewById(R.id.ex_detail4);


        Intent intent = getIntent();
        int id = intent.getIntExtra("ID",-1);
        SQLiteDatabase database = Database.initDatabase(this, DATABASE_NAME);
        Cursor cursor = database.rawQuery("SELECT * FROM Express WHERE ID = ? ",new String[]{id + ""});
        cursor.moveToFirst();
        String exName = cursor.getString(1);
        String ex_Detail_1 = cursor.getString(2);
        String ex_Detail_2 = cursor.getString(3);
        String ex_Detail_3 = cursor.getString(4);
        String ex_Detail_4 = cursor.getString(5);

        exNameD.setText(exName);
        exDetail1.setText(ex_Detail_1);
        exDetail2.setText(ex_Detail_2);
        exDetail3.setText(ex_Detail_3);
        exDetail4.setText(ex_Detail_4);




    }

}
