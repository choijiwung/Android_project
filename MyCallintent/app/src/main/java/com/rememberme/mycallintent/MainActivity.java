package com.rememberme.mycallintent;

import android.content.ComponentName;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    EditText editText;
//    변수의 스코프떄문에 method onClick에서 쓸려면

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final EditText editText = (EditText) findViewById(R.id.editText);

        Button button = (Button) findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
//                버튼이 클릭되었을때 코드
            @Override
            public void onClick(View v) {
            String receiver = editText.getText().toString();
                Intent intent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel : "+receiver));
//                #전화걸기를 띄운다, 전화번호가 있으면
                startActivity(intent);

                Intent intent2 = new Intent();
                ComponentName name = new ComponentName("org.techtown.callintent", "org.techtown.callintent.MenuActivity");
                intent2.setComponent(name);
                startActivity(intent2);



            }
        });
    }
}
