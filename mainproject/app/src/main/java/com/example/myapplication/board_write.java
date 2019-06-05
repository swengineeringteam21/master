package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class board_write extends AppCompatActivity {

    private EditText mMemoEdit = null;
    private EditText mMemotitle = null;
    private String txt_filename = null;
    private File file = null;
    String timeStamp=null;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.board_write_layout);
        Log.i("activity_memo", "onCreate()");
        mMemoEdit = (EditText) findViewById(R.id.et_memo);
        mMemotitle = (EditText)findViewById(R.id.et_title);



        timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss", Locale.US).format(new Date());
        String captureName = String.format("%s.txt", timeStamp);
        //추후에 점에 따라 디렉토리명 바꿈
        String path = Environment.getExternalStorageDirectory()+"/path/"+captureName;
        file = new File(path);
    }

    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_save: {
                String memoStr = mMemoEdit.getText().toString();
                String titleStr = mMemotitle.getText().toString();
                JSONObject jsonObject = new JSONObject();
                try{
                    if(!file.exists()) {
                        try {
                            FileOutputStream fos = new FileOutputStream(file);
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                    try {
                        jsonObject.put("name", "김인호");
                        jsonObject.put("title", titleStr);
                        jsonObject.put("content", memoStr);
                        jsonObject.put("day", timeStamp);
                        //jsonObject.put("picture", "김인호");

                    }catch (Exception e){

                    }
                    FileOutputStream fos = new FileOutputStream(file);
                    BufferedWriter buw = new BufferedWriter(new OutputStreamWriter(fos, "UTF8"));
                    buw.write(jsonObject.toString());
                    buw.close();
                    fos.close();
                    Toast.makeText(this, "저장완료", Toast.LENGTH_SHORT).show();
                }catch(IOException e){
                    e.printStackTrace();
                }
                Toast.makeText(this, "저장 완료", Toast.LENGTH_LONG).show();
                Intent intent = new Intent(this, Board.class);
                startActivity(intent);
                break;
            }
            case R.id.btn_delete: {
                mMemoEdit.setText("");
                file.delete();
                Toast.makeText(this, "삭제 완료", Toast.LENGTH_LONG).show();
                break;
            }
            case R.id.btn_picture: {

                break;
            }
        }
    }
}
