package com.example.bloomi.Home;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import com.example.bloomi.Adapter.PostAdapter;
import com.example.bloomi.Notification.FragmentNotification;
import com.example.bloomi.R;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link FragmentHome#newInstance} factory method to
 * create an instance of this fragment.
 */
public class FragmentHome extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public FragmentHome() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment FragmentHome.
     */
    // TODO: Rename and change types and number of parameters
    public static FragmentHome newInstance(String param1, String param2) {
        FragmentHome fragment = new FragmentHome();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

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
                //dialog_new_post();
                FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
                fragmentTransaction.add(R.id.mainNav_layout, new FragmentCreatePost());
                fragmentTransaction.commit();
            }


        });

        ImageView f_home_notification= view.findViewById(R.id.f_home_notification);
        f_home_notification.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
                fragmentTransaction.add(R.id.mainNav_layout, new FragmentNotification());
                fragmentTransaction.commit();
            }
        });

        String avatar = null;
        String userName = null;

        List<OnePost> posts = new ArrayList<>();
        RecyclerView recyclerView = view.findViewById(R.id.f_home_rv);
        PostAdapter postAdapter;

        postAdapter = new PostAdapter(getContext(), posts, avatar, userName);
        LinearLayoutManager linearLayoutManager =new LinearLayoutManager(getContext(), RecyclerView.VERTICAL, false);
        recyclerView.setAdapter(postAdapter);
        recyclerView.setLayoutManager(linearLayoutManager);

        return view;
    }
    /*private void dialog_new_post() {
        Dialog dialogNewPost = new Dialog(getActivity());
        dialogNewPost.setContentView(R.layout.dialog_new_post);
        dialogNewPost.getWindow().setBackgroundDrawableResource(android.R.color.transparent);

        // constraintlayout must have
        Window window = dialogNewPost.getWindow();
        window.setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);

        LinearLayout d_newPost_addPhoto = dialogNewPost.findViewById(R.id.d_newPost_addPhoto);
        ImageView d_newPost_image = dialogNewPost.findViewById(R.id.d_newPost_image);

        d_newPost_addPhoto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

        dialogNewPost.show();
    }*/

}