package com.rememberme.mybasicwedget;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.RadioButton;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        RadioButton radioButton = (RadioButton) findViewById(R.id.radioButton2);
        RadioButton radioButton1 = (RadioButton) findViewById(R.id.radioButton3);

    }


}
