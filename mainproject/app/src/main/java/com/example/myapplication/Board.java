package com.example.myapplication;

import android.content.Intent;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FilenameFilter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class Board extends AppCompatActivity {

    private ListView listView;
    private ListAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.boardlayout);
        listView = (ListView) findViewById(R.id.listview_boarder);

        adapter = new com.example.myapplication.ListAdapter(Board.this);

        String path = Environment.getExternalStorageDirectory()+"/path/";
        File file = new File(path);

        if (!file.exists()) {
            file.mkdir();
        }


        String[] imgList = file.list(new FilenameFilter() {
            public boolean accept(File dir, String filename) {
                Boolean bOK = false;
                if(filename.toLowerCase().endsWith(".txt")) bOK = true;
                return bOK;
            }
        });
        for(int i=0;i<imgList.length;i++)
        {
            String path2 = Environment.getExternalStorageDirectory() + "/path/"+imgList[i];
            File file2= new File(path2);
            if (!file2.exists()) {
                Toast.makeText(this, "전 작업이 없습니다", Toast.LENGTH_SHORT).show();
            } else {
                StringBuilder sb = new StringBuilder();
                try {
                    InputStream is = new FileInputStream(path2);
                    BufferedReader reader = new BufferedReader(new InputStreamReader(is));

                    // read line
                    String line;
                    while ((line = reader.readLine()) != null) {
                        sb.append(line).append("\n");
                    }

                    // close stream
                    reader.close();
                    is.close();
                    JSONObject parsedData = new JSONObject();
                    try {
                        parsedData = new JSONObject(sb.toString());
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }

                    try {
                        String name = parsedData.getString("name");
                        String title = parsedData.getString("title");
                        String content = parsedData.getString("content");
                        String day = parsedData.getString("day");

                        ((com.example.myapplication.ListAdapter) adapter).addVO(title,day,"",name,content,"");
                        listView.setAdapter(adapter);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }

                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }

    public void onClick(View view) {
        Intent intent = new Intent(Board.this, board_write.class);
        startActivity(intent);
    }
}
