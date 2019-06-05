package com.example.myapplication;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class RoomListAdapter extends BaseAdapter {
    private LayoutInflater inflater;
    private ArrayList<memberList> data;

    public RoomListAdapter(Context context, ArrayList<memberList> data) {
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
        convertView = inflater.inflate(R.layout.roomlistitem, parent, false);

        ImageView listImage = convertView.findViewById(R.id.roomListImage);
        TextView roomName = convertView.findViewById(R.id.roomListName);
        TextView roomMemberCount = convertView.findViewById(R.id.roomListMemberCount);

        listImage.setImageResource(data.get(position).getMemberImage());
        roomName.setText(data.get(position).getMemberName());
        roomMemberCount.setText(data.get(position).getMemberIntroduce());

        return convertView;
    }
}
