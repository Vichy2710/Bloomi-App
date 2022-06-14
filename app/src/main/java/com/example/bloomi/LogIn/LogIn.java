package com.example.bloomi.LogIn;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.Rect;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.bloomi.Detail.auth_controller.Account;
import com.example.bloomi.MainNav;
import com.example.bloomi.R;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class LogIn extends AppCompatActivity {

    String url = "https://bloomi.herokuapp.com/api/v1/auth/signin";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log_in);

        TextView LogIn_forgotPassword = findViewById(R.id.LogIn_ForgotPassword);
        LogIn_forgotPassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog_forgot_password();
            }
        });


        TextView Login_Login = findViewById(R.id.LogIn_LogIn);
        Login_Login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                com.google.android.material.textfield.TextInputEditText LogIn_Email = findViewById(R.id.LogIn_Email);
                com.google.android.material.textfield.TextInputEditText LogIn_Password = findViewById(R.id.LogIn_Password);

                //postAccount(LogIn_Email.getText().toString().trim(), LogIn_Password.getText().toString().trim());

                PostData(LogIn_Email.getText().toString().trim(), LogIn_Password.getText().toString().trim());

            }
        });

        // call API LogIn

    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent event) {
        if (event.getAction() == MotionEvent.ACTION_DOWN) {
            View v = getCurrentFocus();
            if (v instanceof EditText) {
                Rect outRect = new Rect();
                v.getGlobalVisibleRect(outRect);
                if (!outRect.contains((int) event.getRawX(), (int) event.getRawY())) {
                    v.clearFocus();
                    InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
                    imm.hideSoftInputFromWindow(v.getWindowToken(), 0);
                }
            }
        }
        return super.dispatchTouchEvent(event);
    }

    private void dialog_forgot_password() {
        Dialog dialogLogIn = new Dialog(this);
        dialogLogIn.setContentView(R.layout.dialog_forgot_password);
        dialogLogIn.getWindow().setBackgroundDrawableResource(android.R.color.transparent);

        // constraintlayout must have
        Window window = dialogLogIn.getWindow();
        window.setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);

        TextView forgotPassword = dialogLogIn.findViewById(R.id.d_forgotPassword_forgotPassword);
        forgotPassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialogLogIn.dismiss();
                RelativeLayout fragment_forgotPassword = findViewById(R.id.fragment_forgotPassword);
                fragment_forgotPassword.setVisibility(View.VISIBLE);
                FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
                fragmentTransaction.add(R.id.fragment_forgotPassword, new FragmentForgotPassword());
                fragmentTransaction.commit();

            }
        });
        TextView tryAgain = dialogLogIn.findViewById(R.id.d_forgotPassword_tryAgain);
        tryAgain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialogLogIn.dismiss();
            }
        });
        dialogLogIn.show();
    }

    private void PostData(String email, String password) {
        RequestQueue requestQueue = Volley.newRequestQueue(LogIn.this);
        StringRequest jsonObjectRequest = new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                {
                    try {
                        JSONObject jsonObject = new JSONObject(response);
                        if (!jsonObject.equals("SUCCESS")) {
                            JSONObject userJson = jsonObject.getJSONObject("data");
                            Account account = new Account(email, password, userJson.getString("jwt"), userJson.getInt("accountId"));

                            Intent goToHomeFromLogIn = new Intent(LogIn.this, MainNav.class);
                            Bundle sendAccountDetailToHome = new Bundle();
                            sendAccountDetailToHome.putSerializable("account_login", account);
                            goToHomeFromLogIn.putExtras(sendAccountDetailToHome);
                            startActivity(goToHomeFromLogIn);

                        }
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
            }

        }, new com.android.volley.Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

                TextView LogIn_noticeInvalidAccount = findViewById(R.id.LogIn_noticeInvalidAccount);
                CountDownTimer timer = new CountDownTimer(3000, 1000) {
                    @Override
                    public void onTick(long millisUntilFinished) {
                        LogIn_noticeInvalidAccount.setText("Wrong email or password");
                        LogIn_noticeInvalidAccount.setVisibility(View.VISIBLE);
                    }

                    @Override
                    public void onFinish() {
                        LogIn_noticeInvalidAccount.setText("");
                        LogIn_noticeInvalidAccount.setVisibility(View.INVISIBLE); //(or GONE)
                    }
                }.start();
            }
        }) {
            @Override
            protected Map<String, String> getParams() {
                Map<String, String> param = new HashMap<>();

                param.put("emailOrPhone", email.toLowerCase());
                param.put("password", password);

                return param;
            }
        };

        requestQueue.add(jsonObjectRequest);
    }

    /*@Override
    public String getBodyContentType() {
        return "application/json; charset=utf-8";
    }*/
    /*private void postAccount(String email, String password) {


        IAPIService.apiService.postAccountSignIn(email, password).enqueue(new Callback<com.example.bloomi.Account>() {
            @Override
            public void onResponse(Call<com.example.bloomi.Account> call, Response<com.example.bloomi.Account> response) {
                com.example.bloomi.Account result = response.body();
                if(result.getStatus().equals("SUCCESS")){
                    Intent goToHomeFromLogIn = new Intent(LogIn.this, MainNav.class);
                    startActivity(goToHomeFromLogIn);
                }
                else{
                    Toast.makeText(LogIn.this,"sai mat khau",Toast.LENGTH_SHORT).show();

                }
            }

            @Override
            public void onFailure(Call<com.example.bloomi.Account> call, Throwable t) {
                Toast.makeText(LogIn.this,"ko dc",Toast.LENGTH_SHORT).show();

            }
        });

    }*/
}