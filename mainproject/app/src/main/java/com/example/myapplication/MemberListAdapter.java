package com.example.myapplication;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class MemberListAdapter extends BaseAdapter {

    private LayoutInflater inflater;
    private ArrayList<memberList> data;

    public MemberListAdapter(Context context, ArrayList<memberList> data) {
        this.inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        this.data = data;
    }

    @Override
    public int getCount() {
        return data.size();
    }

    @Override
    public Object getItem(int position) {
        return data.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        convertView = inflater.inflate(R.layout.memberlistitem, parent, false);

        ImageView memberImage = convertView.findViewById(R.id.memberImage);
        TextView memberName = convertView.findViewById(R.id.memberName);
        TextView memberIntroduce = convertView.findViewById(R.id.memberIntroduce);
        TextView memberRank = convertView.findViewById(R.id.memberRank);

        memberImage.setImageResource(data.get(position).getMemberImage());
        memberName.setText(data.get(position).getMemberName());
        memberIntroduce.setText(data.get(position).getMemberIntroduce());
        memberRank.setText(data.get(position).getMemberRank());


        return convertView;
    }
}
