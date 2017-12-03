package com.rememberme.mylifecycle;

import android.app.Activity;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
//        수명주기 메소드 onCreate
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toast.makeText(this, "onCreate 호출", Toast.LENGTH_LONG).show();


        Button button = (Button) findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
             finish();

            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
        Toast.makeText(this, "onStart 호출", Toast.LENGTH_LONG).show();
    }

    @Override
    protected void onStop() {
        super.onStop();
        Toast.makeText(this, "OnStop 호출", Toast.LENGTH_LONG).show();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Toast.makeText(this, "onDestroy 호출", Toast.LENGTH_LONG).show();
    }

    @Override
    protected void onPause() {
        super.onPause();
        Toast.makeText(this, "onPause 호출", Toast.LENGTH_LONG).show();
//        보통 onPause 상태에서 파일을 저장을 많이한다. shareReferences
        SharedPreferences pref = getSharedPreferences("pref", Activity.MODE_PRIVATE);
//        간단한 설정을 저장하는 방법이다.
        SharedPreferences.Editor editor = pref.edit();
        editor.putString("name", "소녀시대");
        editor.commit();

    }

    @Override
    protected void onResume() {
        super.onResume();
        Toast.makeText(this, "onResume 호출", Toast.LENGTH_LONG).show();

        SharedPreferences pref = getSharedPreferences("pref", Activity.MODE_PRIVATE);
        if (pref != null){
            String name = pref.getString("name", "");
            Toast.makeText(this, "복구된이름"+ name, Toast.LENGTH_LONG).show();


        }
    }
//    모든것이 수명주기 메소드
}
