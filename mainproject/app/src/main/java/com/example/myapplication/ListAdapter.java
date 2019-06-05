package com.example.myapplication;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class ListAdapter extends BaseAdapter {
    private ArrayList<ContentVO> listVOArrayNotice = new ArrayList<ContentVO>();
    private Context currentContext;

    public ListAdapter(Context currentContext)
    {
        this.currentContext = currentContext;
    }
    @Override
    public int getCount() {
        return listVOArrayNotice.size();
    }

    @Override
    public Object getItem(int position) {
        return position;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        final Context context = parent.getContext();

        if(convertView ==null)
        {
            LayoutInflater inflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.listview_item, parent, false);
        }


        final ContentVO contentVO = listVOArrayNotice.get(position);

        TextView title = (TextView)convertView.findViewById(R.id.listview_title);
        TextView day = (TextView)convertView.findViewById(R.id.listview_day);
        TextView contents = (TextView)convertView.findViewById(R.id.listview_contents);
        TextView name = (TextView)convertView.findViewById(R.id.listview_name);
        ImageView profileImg = (ImageView)convertView.findViewById(R.id.listview_profileImg);


        //아이템 설정
        title.setText(contentVO.getTitle());
        day.setText(contentVO.getDay());
        contents.setText(contentVO.getContents());
        name.setText(contentVO.getName());


        return convertView;
    }
    public void addVO(String title, String day, String profileImage, String name, String contents, String img)
    {
        ContentVO listItem= new ContentVO();
        listItem.setTitle(title);
        listItem.setDay(day);
        listItem.setContents(contents);
        listItem.setProfileImage(profileImage);
        listItem.setName(name);

        listVOArrayNotice.add(listItem);
    }
}
