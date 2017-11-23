package com.example.jw.tutorial2;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void addClick(View v){
    EditText number1 = (EditText) findViewById(R.id.number1);
    EditText number2 = (EditText) findViewById(R.id.number2);
    TextView result = (TextView) findViewById(R.id.result);
    int n1 = Integer.parseInt(number1.getText().toString());
    int n2 = Integer.parseInt(number2.getText().toString());
    result.setText(Integer.toString(n1+n2));
    }
    public void substractClick(View v) {
        EditText number1 = (EditText) findViewById(R.id.number1);
        EditText number2 = (EditText) findViewById(R.id.number2);
        TextView result = (TextView) findViewById(R.id.result);
        int n1 = Integer.parseInt(number1.getText().toString());
        int n2 = Integer.parseInt(number2.getText().toString());
        result.setText(Integer.toString(n1 - n2));
    }
    public void multiplyClick(View v) {
        EditText number1 = (EditText) findViewById(R.id.number1);
        EditText number2 = (EditText) findViewById(R.id.number2);
        TextView result = (TextView) findViewById(R.id.result);
        int n1 = Integer.parseInt(number1.getText().toString());
        int n2 = Integer.parseInt(number2.getText().toString());
        result.setText(Integer.toString(n1 * n2));
    }
    public void devideClick(View v){
        EditText number1 = (EditText) findViewById(R.id.number1);
        EditText number2 = (EditText) findViewById(R.id.number2);
        TextView result = (TextView) findViewById(R.id.result);
        float n1 =  Float.parseFloat(number1.getText().toString());
        float n2 = Float.parseFloat(number2.getText().toString());
        result.setText(Float.toString(n1 / n2));
    }
    public void sayHelloClick(View v){
        Toast.makeText(this, "안녕하세요", Toast.LENGTH_LONG).show();

    }

    public void webPageClicked(View v){
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://m.naver.com"));
        startActivity(intent);
    }

    public void phoneCallClick(View v){
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("tel:010-1000-0100"));
        startActivity(intent);
    }
    public void onButtonClick(View v){
        Toast.makeText(this, "다음화면으로넘어갑니다",Toast.LENGTH_LONG).show();

        Intent intent = new Intent(this, menuActivity.class);
        startActivity(intent);
    }
}
