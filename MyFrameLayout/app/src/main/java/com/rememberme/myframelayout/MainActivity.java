package com.rememberme.myframelayout;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {
    ImageView imageView;
    ImageView imageView2;
    int index = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        imageView = (ImageView) findViewById(R.id.imageView);
        imageView2 = (ImageView) findViewById(R.id.imageView2);

    }
//   R은 RES를뜻한다.
//    변수의 scope 때문에 위에서 클래스에서 선언을 해야 아래 메소드에서도 접근 가능하다.

    public void onButton1Click(View v){
        index += 1;
        if (index >1) {
            index = 0;
        }

        if (index==0){
            imageView.setVisibility(View.VISIBLE);
            imageView2.setVisibility(View.INVISIBLE);
        }else if (index==1){
            imageView.setVisibility(View.INVISIBLE);
            imageView2.setVisibility(View.VISIBLE);
        }
    }
}

