package com.example.myapplication;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import org.json.JSONObject;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;


public class MainActivity extends AppCompatActivity {

    public ListView memberList;
    public ListView scheduleList;

    public TextView infoBtnUnderline;
    public TextView boardBtnUnderline;

    public Button infoBtn;
    public Button boardBtn;

    public TextView mettingName;
    public TextView roomContent;

    int caseint;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE,
                Manifest.permission.READ_EXTERNAL_STORAGE}, 0);

        roomContent = findViewById(R.id.roomContent);
        mettingName = findViewById(R.id.mettingName);
        memberList = findViewById(R.id.memberList);
        scheduleList = findViewById(R.id.scheduleList);
        infoBtn = findViewById(R.id.mettingInfo);
        boardBtn = findViewById(R.id.mettingBorad);
        infoBtnUnderline = findViewById(R.id.infoBtnUnderline);
        boardBtnUnderline = findViewById(R.id.boradBtnUnderline);
        boardBtnUnderline.setVisibility(View.GONE);

        ArrayList<memberList> memberInfoLists = new ArrayList<>();
        ArrayList<scheduleList> scheduleLists = new ArrayList<>();


        Intent receivedIntent = getIntent();

        switch(receivedIntent.getStringExtra("int")){
            case "1":
                roomContent.setText("C사모");
                mettingName.setText("c언어를 즐기는 사람들의 모임 ");
                memberInfoLists.add(new memberList(R.drawable.testimage, "이용진", "주사모 모임장 입니다", "모임장"));
                memberInfoLists.add(new memberList(R.drawable.testimage, "김주운", "ㅎㅎㅎ", "운영진"));
                scheduleLists.add(new scheduleList("번개모임", "6월 21일", "수유"));
                scheduleLists.add(new scheduleList("신입환영회", "7월 17일", "노원"));
                break;
            case "2":
                roomContent.setText("이보게 저보게(보드게임)");
                mettingName.setText("이 세상 보드게임에서 저세상 보드게임 까지 !!\n 다함께 즐기자! ");
                memberInfoLists.add(new memberList(R.drawable.testimage, "용준영", "보드게임 모임장 입니다", "모임장"));
                memberInfoLists.add(new memberList(R.drawable.testimage, "이담재", "카페운영", "운영진"));
                memberInfoLists.add(new memberList(R.drawable.testimage, "김인호", "다이아", "회원"));
                scheduleLists.add(new scheduleList("토요정모", "6월 31일", "광운대"));
                scheduleLists.add(new scheduleList("신입환영회", "7월 17일", "노원"));
                break;
            case "3":
                roomContent.setText("뉴턴");
                mettingName.setText("배드민턴 모임인데요? 들어 오실래요? ");
                memberInfoLists.add(new memberList(R.drawable.testimage, "김하민", "배드민턴 모임장 입니다", "모임장"));
                memberInfoLists.add(new memberList(R.drawable.testimage, "최예림", "안뇽", "운영진"));
                memberInfoLists.add(new memberList(R.drawable.testimage, "윤건우", "", "회원"));
                memberInfoLists.add(new memberList(R.drawable.testimage, "정한필", "", "회원"));
                memberInfoLists.add(new memberList(R.drawable.testimage, "김혜수", "", "회원"));
                scheduleLists.add(new scheduleList("배드민턴 정모", "6월 11일", "체육관"));
                scheduleLists.add(new scheduleList("신입환영회", "7월 17일", "강동"));
                break;
            case "4":
                roomContent.setText("헤이 온 와이");
                mettingName.setText("hey 책에게 말을 걸어\n On 계속해서\n WHY 질문하는 독서 모임 ");
                memberInfoLists.add(new memberList(R.drawable.testimage, "록", "독서모임 모임장 입니다", "모임장"));
                memberInfoLists.add(new memberList(R.drawable.testimage, "배진경", "안뇽", "운영진"));
                memberInfoLists.add(new memberList(R.drawable.testimage, "채정석", "", "회원"));
                memberInfoLists.add(new memberList(R.drawable.testimage, "박빛나", "", "회원"));
                memberInfoLists.add(new memberList(R.drawable.testimage, "석진", "", "회원"));
                scheduleLists.add(new scheduleList("자유책 모임", "6월 8일", "노원문고"));
                scheduleLists.add(new scheduleList("자유책 정모", "7월 17일", "노원"));
                break;

        }


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

                Intent intent = new Intent(MainActivity.this, Board.class);
                startActivity(intent);
            }
        });

    }
}



