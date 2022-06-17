package com.example.bloomi.homePage;

import static com.example.bloomi.MainActivity.list;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.bloomi.Adapter_Manage.PostAdapter;
import com.example.bloomi.CallAPI.Call_API;
import com.example.bloomi.MainActivity;
import com.example.bloomi.Notification.FragmentNotification;
import com.example.bloomi.R;
import com.example.bloomi.SearchAccount.FragmentSearchAccount;
import com.example.bloomi.post_Bloom.OnePost;
import com.example.bloomi.post_Bloom.create_new_post;

import java.util.ArrayList;
import java.util.List;

public class FragmentHome extends Fragment {




    RecyclerView recyclerView;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {


        //call_api.call_Api_Get_Post(MainActivity.user_login.getAccout().getId(),list);
        System.out.println("CHECK LIST IN CALL");
        PostAdapter postAdapter = new PostAdapter(getActivity(), list, "NguyenVanDat");
            // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_home, container, false);
            recyclerView = view.findViewById(R.id.f_home_rv);
            recyclerView.setAdapter(postAdapter);
            recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
            System.out.println(list);
            ImageView f_home_searchAccount = view.findViewById(R.id.f_home_searchAccount);
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

            ImageView f_home_notification = view.findViewById(R.id.f_home_notification);
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