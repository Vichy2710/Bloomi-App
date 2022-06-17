package com.example.bloomi.homePage;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.example.bloomi.Notification.FragmentNotification;
import com.example.bloomi.R;
import com.example.bloomi.SearchAccount.FragmentSearchAccount;
import com.example.bloomi.post_Bloom.create_new_post;

public class FragmentHome extends Fragment {





    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =inflater.inflate(R.layout.fragment_home, container, false);
        ImageView f_home_searchAccount=view.findViewById(R.id.f_home_searchAccount);
        f_home_searchAccount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
                fragmentTransaction.add(R.id.fragmentContainer_main, new FragmentSearchAccount());
                fragmentTransaction.commit();
            }
        });

        RelativeLayout f_home_addPost = view.findViewById(R.id.f_home_addPost);
        f_home_addPost.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
                fragmentTransaction.add(R.id.fragmentContainer_main, new create_new_post());
                fragmentTransaction.commit();
            }


        });

        ImageView f_home_notification= view.findViewById(R.id.f_home_notification);
        f_home_notification.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
                fragmentTransaction.add(R.id.navView, new FragmentNotification());
                fragmentTransaction.commit();
            }
        });

        return view;
    }

    




}