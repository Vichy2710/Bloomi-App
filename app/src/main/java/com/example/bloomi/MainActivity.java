package com.example.bloomi;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Shader;
import android.os.Bundle;
import android.widget.TextView;

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
        TextView bloomi = new TextView(this);
        Shader textShader=new LinearGradient(0, 0, 0, 1,
                new int[]{Color.parseColor("#D66D75"),Color.parseColor("#FFC3A0")},
                new float[]{0, 1}, Shader.TileMode.CLAMP);
        bloomi.getPaint().setShader(textShader);
    }
}