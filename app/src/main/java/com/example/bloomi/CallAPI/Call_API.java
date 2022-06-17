package com.example.bloomi.CallAPI;

import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

import androidx.annotation.Nullable;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.VolleyLog;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.bloomi.Login.LogIn;
import com.example.bloomi.Login.SharedPrefManager;
import com.example.bloomi.Login.User_login;
import com.example.bloomi.Register.User;
import com.example.bloomi.homePage.MainNav;
import com.example.bloomi.post_Bloom.oneNewPost;
import com.example.bloomi.uses_manage;


import org.json.JSONException;
import org.json.JSONObject;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;

public class Call_API {


    public Context context;

    public Call_API(Context context) {
        this.context = context;
    }
    // dk: http://test-env-1.eba-ypwmzh2b.us-east-1.elasticbeanstalk.com/?fbclid=IwAR2c48bl-Ww5L8rOczfbu9iA4wue8G4HEuvXiIHtIIFwHD6jBxI-dGsdhuo
    static String url_signup = "http://test-env-1.eba-ypwmzh2b.us-east-1.elasticbeanstalk.com/api/v1/auth/signup";
    static String url_signin = "http://bloomi.eba-u3ypmzpm.us-east-1.elasticbeanstalk.com/api/v1/auth/signin";

    public void call_API_SignUp(User user) {
        RequestQueue referenceQueue = Volley.newRequestQueue(context);
        StringRequest jsonArrayRequest = new StringRequest(Request.Method.POST, url_signup, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try {
                    JSONObject jsonObject= new JSONObject(response);
                    System.out.println("NGuyenVanDat");
                    System.out.println(response);
                    if(jsonObject.getString("status").equals("SUCCESS"))
                    {
                        Toast.makeText(context,"successful registration",Toast.LENGTH_SHORT).show();
                        //Intent intent=new Intent(context, LogIn.class);
                        //context.startActivity(intent);
                    }

                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }

        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(context, "Not Found Account", Toast.LENGTH_SHORT).show();
            }
        }) {
            @Nullable
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> param = new HashMap<>();

                param.put("birthday", user.getBirthDay().toString());
                param.put("email", "vandat@gmail.com");
                param.put("firstName", user.getFirstName().toString());
                param.put("gender", user.getSex().toString());
                param.put("lastName", user.getLastName().toString());
                param.put("password", user.getPassword().toString());
                param.put("phone", user.getPhone().toString());
                return param;
            }
        };
        referenceQueue.add(jsonArrayRequest);
    }

    public void callAPISignIn(String name, String pass) throws JSONException {
        RequestQueue requestQueue = Volley.newRequestQueue(context);

        StringRequest jsonArrayRequest = new StringRequest(Request.Method.POST, url_signin, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try {

                    JSONObject jsonObject = new JSONObject(response);
                    System.out.println(jsonObject.getString("status"));
                    if (!jsonObject.getString("status").equals("SUCCESS")) {
                        Toast.makeText(context, "asdfsd", Toast.LENGTH_SHORT).show();
                    } else {
                        JSONObject userJson = jsonObject.getJSONObject("data");

                        //creating a new user object
                        User_login user = new User_login(
                                userJson.getString("token"),new uses_manage(
                                userJson.getJSONObject("account").getInt("id"),
                                userJson.getJSONObject("account").getBoolean("activeFlag"),
                                userJson.getJSONObject("account").getBoolean("deleteFlag"),
                                userJson.getJSONObject("account").getString("createdDate"),
                                userJson.getJSONObject("account").getString("email"),
                                userJson.getJSONObject("account").getString("phone"),
                                userJson.getJSONObject("account").getString("firstName"),
                                userJson.getJSONObject("account").getString("lastName"),
                                userJson.getJSONObject("account").getString("gender"),
                                userJson.getJSONObject("account").getString("birthday"),
                                userJson.getJSONObject("account").getString("avatarUrl"),
                                userJson.getJSONObject("account").getString("coverImageUrl"),
                                userJson.getJSONObject("account").getString("address"),
                                userJson.getJSONObject("account").getString("authProvider")
                        )
                        );

                        //storing the user in shared preferences
                        SharedPrefManager.getInstance(context).userLogin(user);
                        Intent goToHomeFromLogIn = new Intent(context, MainNav.class);
                        //System.out.println("Nguyen Van Dat");
                        context.startActivity(goToHomeFromLogIn);
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(context, "Not Found Account", Toast.LENGTH_SHORT).show();
            }
        }) {

//            @Override
//            public String getBodyContentType() {
//                return "application/json; charset=utf-8";
//            }
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> param = new HashMap<>();
                //System.out.println(name);
                param.put("emailOrPhone",name.toLowerCase());
                param.put("password",pass);
                return param;}
        };
        requestQueue.add(jsonArrayRequest);
    }
    public void call_Api_CreateNewPost(oneNewPost newPost)
    {
        String Url_new_Post="http://bloomi.eba-u3ypmzpm.us-east-1.elasticbeanstalk.com/api/v1/post/create/";
        RequestQueue requestQueue=Volley.newRequestQueue(context.getApplicationContext());
        StringRequest jsonArrayRequest=new StringRequest(Request.Method.POST, Url_new_Post+newPost.getAccountId(), new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                System.out.println(response);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(context,error.getMessage(),Toast.LENGTH_SHORT).show();
            }
        }){
            @Nullable
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
               Map<String,String > param=new HashMap<>();
               //param.put("", newPost.getAccountId()+"");
               param.put("content",newPost.getContent());
               param.put("displayMode",newPost.getDisplayMode()+"");
               return param;
            }


        };
       requestQueue.add(jsonArrayRequest);
    }
}
