package com.example.bloomi.post_Bloom;

import static android.app.Activity.RESULT_OK;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.bloomi.CallAPI.Call_API;
import com.example.bloomi.MainActivity;
import com.example.bloomi.R;
import com.example.bloomi.uses_manage;

import java.io.IOException;

public class create_new_post extends Fragment {
    private static final int PICK_IMAGE_REQUEST =100 ;
    ImageButton imagebutton;
    ImageView setImage;
    EditText content;
    uses_manage account=MainActivity.user_login.getAccout();
    Button post;
    public static oneNewPost NewPost=new oneNewPost();

    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_create_new_post, container, false);
        imagebutton=view.findViewById(R.id.f_createPost_addImage);
        setImage=view.findViewById(R.id.f_createPost_image);
        content=view.findViewById(R.id.f_createPost_content);
        imagebutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                chooseImageFromGallery();
            }
        });
        NewPost.setAccountId(account.getId());
        NewPost.setContent(content.getText().toString());
        post=view.findViewById(R.id.f_createPost_post);
        Call_API call=new Call_API(this.getActivity());
        post.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                call.call_Api_CreateNewPost(NewPost);
                onDestroy();
            }
        });


    return  view;
    }

    private void chooseImageFromGallery() {
        Intent intent = new Intent();
        intent.setType("image/*");
        intent.setAction(Intent.ACTION_GET_CONTENT);
        startActivityForResult(Intent.createChooser(intent, "Select Picture"), PICK_IMAGE_REQUEST);
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == PICK_IMAGE_REQUEST && resultCode == RESULT_OK
                && data != null && data.getData() != null )
        {
            Uri filePath = data.getData();
            try {
                Bitmap bitmap = MediaStore.Images.Media.getBitmap(this.requireActivity().getContentResolver(), filePath);
                setImage.setImageBitmap(bitmap);
            }
            catch (IOException e)
            {
                e.printStackTrace();
            }
        }
    }

}