package com.rememberme.myparcelable;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.ArrayList;

public class MenuActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        Button button2 = (Button) findViewById(R.id.button2);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               finish();
//                돌아가기 하면 스택구조이기 때문에 그전화면으로 돌아간다.

            }
        });
        Intent passedIntent = getIntent();
        processIntent(passedIntent);
    }

    public void processIntent(Intent intent){
        if (intent != null){
            ArrayList<String> names =(ArrayList<String>) intent.getSerializableExtra("names");
            if (names != null){
                Toast.makeText(getApplicationContext(), "전달받은 리스트 개수:" + names.size(),Toast.LENGTH_LONG).show();
//                토스트 메시지 띄우기

                SimpleData data = (SimpleData) intent.getParcelableExtra("data");

                if (data != null){
                Toast.makeText(getApplicationContext(), "전달받은 데이타:" + data.number + data.message,Toast.LENGTH_LONG).show();
                }
            }
        }
    }
}
