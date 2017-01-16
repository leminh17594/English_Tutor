package com.example.hcd_fresher037.englishtutor.Expression;

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
import com.example.hcd_fresher037.englishtutor.Topic.Topic;
import com.example.hcd_fresher037.englishtutor.Topic.TopicDetail;

import java.util.ArrayList;

import static com.example.hcd_fresher037.englishtutor.R.layout.topic_item;

/**
 * Created by Le Minh on 1/16/2017.
 */

public class ExpressAdapter extends BaseAdapter {

    Activity context;
    ArrayList<Expression> list;


    public ExpressAdapter(Activity context, ArrayList<Expression> list) {
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
        View ex_item = inflater.inflate(R.layout.ex_item, null);

        TextView exID = (TextView) ex_item.findViewById(R.id.ex_id);
        TextView exName = (TextView) ex_item.findViewById(R.id.ex_name);


        final Expression expression = list.get(position);
        exID.setText(+expression.id + ".");
        exName.setText(expression.exName);

        ex_item.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, ExpressDetail.class);
                intent.putExtra("ID", expression.id);
                context.startActivity(intent);
            }
        });


        return ex_item;
    }
}
