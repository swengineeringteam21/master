package com.example.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;


public class MainActivity extends AppCompatActivity {

    public ListView memberList;
    public ListView scheduleList;

    public TextView infoBtnUnderline;
    public TextView boardBtnUnderline;

    public Button infoBtn;
    public Button boardBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        memberList = findViewById(R.id.memberList);
        scheduleList = findViewById(R.id.scheduleList);
        infoBtn = findViewById(R.id.mettingInfo);
        boardBtn = findViewById(R.id.mettingBorad);
        infoBtnUnderline = findViewById(R.id.infoBtnUnderline);
        boardBtnUnderline = findViewById(R.id.boradBtnUnderline);
        boardBtnUnderline.setVisibility(View.GONE);

        ArrayList<memberList> memberInfoLists = new ArrayList<>();
        ArrayList<scheduleList> scheduleLists = new ArrayList<>();

        memberInfoLists.add(new memberList(R.drawable.testimage, "이용진", "주사모 모임장 입니다", "모임장"));
        memberInfoLists.add(new memberList(R.drawable.testimage, "김주운", "ㅎㅎㅎ", "운영진"));
        scheduleLists.add(new scheduleList("번개모임", "6월 21일", "수유"));
        scheduleLists.add(new scheduleList("신입환영회", "7월 17일", "노원"));

        MemberListAdapter memberListAdapter = new MemberListAdapter(this, memberInfoLists);
        ScheduleListAdapter scheduleListAdapter = new ScheduleListAdapter(this, scheduleLists);

        memberList.setAdapter(memberListAdapter);
        scheduleList.setAdapter(scheduleListAdapter);

        infoBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 정보 버튼 클릭 이벤트 리스너
                infoBtnUnderline.setVisibility(View.VISIBLE);
                boardBtnUnderline.setVisibility(View.GONE);
            }
        });

        boardBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 게시판 버튼 클릭 이벤트 리스너
                infoBtnUnderline.setVisibility(View.GONE);
                boardBtnUnderline.setVisibility(View.VISIBLE);
            }
        });

    }
}
