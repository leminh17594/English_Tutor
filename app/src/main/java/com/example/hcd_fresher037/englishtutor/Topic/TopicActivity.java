package com.example.hcd_fresher037.englishtutor.Topic;

import android.app.Activity;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.widget.ListView;

import com.example.hcd_fresher037.englishtutor.Database;
import com.example.hcd_fresher037.englishtutor.R;

import java.util.ArrayList;

/**
 * Created by HCD-Fresher037 on 1/10/2017.
 */
public class TopicActivity extends Activity {

    final String DATABASE_NAME = "data.db";
    SQLiteDatabase database;

    ListView listView1;
    ArrayList<Topic> list;
    TopicAdapter adapter;
   // Button btnAdd;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.topic_activity);
        addControls();
        readData();
    }

    private void addControls() {
        listView1 = (ListView) findViewById(R.id.listView1);
        list = new ArrayList<>();
        adapter = new TopicAdapter(this, list);
        listView1.setAdapter(adapter);
    }

    private void readData(){
        database = Database.initDatabase(this, DATABASE_NAME);
        Cursor cursor = database.rawQuery("SELECT * FROM Topic",null);
        list.clear();
        for(int i = 0; i < cursor.getCount(); i++){
            cursor.moveToPosition(i);
            int id = cursor.getInt(0);
            String tpName = cursor.getString(1);
            String tpIntro = cursor.getString(2);
            String tpQues1 = cursor.getString(3);
            String tpQues2 = cursor.getString(4);
            String tpQues3 = cursor.getString(5);
            byte[] anh = cursor.getBlob(6);
            list.add(new Topic(id, tpName, tpIntro,tpQues1,tpQues2,tpQues3,anh));
        }
        adapter.notifyDataSetChanged();
    }
}
