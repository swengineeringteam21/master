package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;


public class RoomList extends AppCompatActivity {

    ListView roomlist;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.roomlist);

        roomlist = findViewById(R.id.roomList);

        ArrayList<memberList> roomListData = new ArrayList<>();

        roomListData.add(new memberList(R.drawable.testimage, "C사모", "55"));
        roomListData.add(new memberList(R.drawable.testimage, "이보게 저보게(보드게임)", "55"));
        roomListData.add(new memberList(R.drawable.testimage, "뉴턴", "55"));
        roomListData.add(new memberList(R.drawable.testimage, "헤이 온 와이", "55"));

        RoomListAdapter roomListAdapter = new RoomListAdapter(this, roomListData);

        roomlist.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(RoomList.this, MainActivity.class);
                intent.putExtra(String.valueOf(position), "int");
                startActivity(intent);
            }
        });

        roomlist.setAdapter(roomListAdapter);
    }
}
