package com.rememberme.myintent;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button button = (Button) findViewById(R.id.button);
//        #id 값으로 버튼을 찾는다.
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), MenuActivity.class);
//                menu activity를지정
                startActivityForResult(intent,101);
//                응답을 받고싶을때 ForResult를사용 intent뒤에다가
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode ==101){
            String name = data.getStringExtra("name");
            Toast.makeText(getApplicationContext(), "응답 " + name, Toast.LENGTH_LONG).show();


        }

    }
}
