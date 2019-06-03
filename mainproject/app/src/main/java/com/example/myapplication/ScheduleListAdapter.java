package com.example.myapplication;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class ScheduleListAdapter extends BaseAdapter {

    private LayoutInflater inflater;
    private ArrayList<scheduleList> data;

    public ScheduleListAdapter(Context context, ArrayList<scheduleList> data) {
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
        convertView = inflater.inflate(R.layout.schedulelistitem, parent, false);

        TextView scheduleName = convertView.findViewById(R.id.scheduleName);
        TextView scheduleDate = convertView.findViewById(R.id.scheduleDate);
        TextView scheduleLocation = convertView.findViewById(R.id.scheduleLocation);

        scheduleName.setText(data.get(position).getScheduleName());
        scheduleDate.setText(data.get(position).getScheduleDate());
        scheduleLocation.setText(data.get(position).getSchedultLocation());



        return convertView;
    }
}
