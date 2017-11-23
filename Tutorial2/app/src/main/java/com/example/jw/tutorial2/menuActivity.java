package com.example.jw.tutorial2;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

public class menuActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
    }

    public void onbackButtonClicked(View v){
        Toast.makeText(this, "전화면으로 돌아갑니다", Toast.LENGTH_LONG.show());

        finish();
    }
}
