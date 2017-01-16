package com.example.hcd_fresher037.englishtutor.Expression;

import android.app.Activity;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.widget.ListView;

import com.example.hcd_fresher037.englishtutor.Database;
import com.example.hcd_fresher037.englishtutor.R;


import java.util.ArrayList;

/**
 * Created by Le Minh on 1/16/2017.
 */
public class ExpressionActivity extends Activity {

    final String DATABASE_NAME = "data.db";
    SQLiteDatabase database;

    ListView listView2;
    ArrayList<Expression> list;
    ExpressAdapter adapter;
    // Button btnAdd;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.expression_activity);
        addControls();
        readData();
    }

    private void addControls() {
        listView2 = (ListView) findViewById(R.id.listView2);
        list = new ArrayList<>();
        adapter = new ExpressAdapter(this, list);
        listView2.setAdapter(adapter);
    }

    private void readData(){
        database = Database.initDatabase(this, DATABASE_NAME);
        Cursor cursor = database.rawQuery("SELECT * FROM Express",null);
        list.clear();
        for(int i = 0; i < cursor.getCount(); i++){
            cursor.moveToPosition(i);
            int id = cursor.getInt(0);
            String tpName = cursor.getString(1);
            String tpIntro = cursor.getString(2);

            list.add(new Expression(id, tpName, tpIntro,"abc1","abc2","abc3"));
        }
        adapter.notifyDataSetChanged();
    }
}
