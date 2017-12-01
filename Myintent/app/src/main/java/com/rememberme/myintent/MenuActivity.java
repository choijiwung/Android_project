package com.rememberme.myintent;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class MenuActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        Button button2 = (Button) findViewById(R.id.button2);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
//                시스템을 통과할때는 Intent 객체를 사용
                intent.putExtra("name","mike");
//               값을 다른데이터에 전달할때 putExtra를사용 예시는 키가 name 값이 mike
                setResult(Activity.RESULT_OK,intent);
//               응답이 정삭적이면 시스템에 intent객체를전달
                finish();
//                finish란 메뉴화면을 없애는것
            }
        });
    }
}
