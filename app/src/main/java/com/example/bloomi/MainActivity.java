package com.example.bloomi;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity {

    Timer time;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        time = new Timer();
        time.schedule(new TimerTask() {
            @Override
            public void run() {
                Intent go_to_signup = new Intent(MainActivity.this, LogIn.class);
                startActivity(go_to_signup);
                finish();
            }
        }, 3000);
    }
}