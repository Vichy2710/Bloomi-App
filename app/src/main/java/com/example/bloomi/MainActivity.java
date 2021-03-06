package com.example.bloomi;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Shader;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.bloomi.CallAPI.Call_API;
import com.example.bloomi.Login.LogIn;
import com.example.bloomi.Login.SharedPrefManager;
import com.example.bloomi.Login.User_login;
import com.example.bloomi.homePage.MainNav;
import com.example.bloomi.post_Bloom.OnePost;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity {


    Timer time;
    public static User_login user_login;
    public static List<OnePost> list=new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        time = new Timer();
        time.schedule(new TimerTask() {
            @Override
            public void run() {
                //SharedPrefManager.getInstance(MainActivity.this).logout();
                if(SharedPrefManager.getInstance(MainActivity.this).isLoggedIn()){
                    user_login=SharedPrefManager.getInstance(MainActivity.this).getUser();
                    Call_API call_api=new Call_API(MainActivity.this);
                    call_api.call_Api_Get_Post(3,list);
                    System.out.println("Check list in Main");
                    System.out.println(list);
                    Intent go_to_signup = new Intent(MainActivity.this, MainNav.class);
                    startActivity(go_to_signup);
                    finish();
                }
                else {
                    Intent go_to_signup = new Intent(MainActivity.this, LogIn.class);
                    startActivity(go_to_signup);
                    finish();
                }
            }
        }, 3000);
        TextView bloomi = new TextView(this);
        Shader textShader=new LinearGradient(0, 0, 0, 1,
                new int[]{Color.parseColor("#D66D75"),Color.parseColor("#FFC3A0")},
                new float[]{0, 1}, Shader.TileMode.CLAMP);
        bloomi.getPaint().setShader(textShader);
    }
    View t;

}