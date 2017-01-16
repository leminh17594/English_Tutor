package com.example.hcd_fresher037.englishtutor.Topic;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.hcd_fresher037.englishtutor.R;

import java.util.ArrayList;

/**
 * Created by HCD-Fresher037 on 1/10/2017.
 */

public class TopicAdapter extends BaseAdapter {

    Activity context;
    ArrayList<Topic> list;


    public TopicAdapter(Activity context, ArrayList<Topic> list) {
        this.context = context;
        this.list = list;
    }

    @Override // trả về số dòng mà addapter vẽ ra, nếu quá nhiều thì phải tạo ra nhiều trang...
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View topic_item = inflater.inflate(R.layout.topic_item, null);
        ImageView tpImage = (ImageView) topic_item.findViewById(R.id.im_tpImage);
        TextView tpID = (TextView) topic_item.findViewById(R.id.tv_tpID);
        TextView tpName = (TextView) topic_item.findViewById(R.id.tv_tpName);


        final Topic topic = list.get(position);
        tpID.setText("No."+topic.id + "");
        tpName.setText(topic.topicName);

        topic_item.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, TopicDetail.class);
                intent.putExtra("ID", topic.id);
                context.startActivity(intent);
            }
        });


        Bitmap bm1 = BitmapFactory.decodeByteArray(topic.anh,0,topic.anh.length);
        tpImage.setImageBitmap(bm1);



        return topic_item;
    }
}





