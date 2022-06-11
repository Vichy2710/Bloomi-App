package com.example.bloomi.Home;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.bloomi.MainNav;
import com.example.bloomi.R;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link FragmentCreatePost#newInstance} factory method to
 * create an instance of this fragment.
 */
public class FragmentCreatePost extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public FragmentCreatePost() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment FragmentCreatePost.
     */
    // TODO: Rename and change types and number of parameters
    public static FragmentCreatePost newInstance(String param1, String param2) {
        FragmentCreatePost fragment = new FragmentCreatePost();
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
        View view = inflater.inflate(R.layout.fragment_create_post, container, false);

        ImageView f_createPost_cancel = view.findViewById(R.id.f_createPost_cancel);
        f_createPost_cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent backToHomeFromCreatePost = new Intent(getActivity(), MainNav.class);
                startActivity(backToHomeFromCreatePost);
            }
        });

        LinearLayout f_createPost_choosePrivacy = view.findViewById(R.id.f_createPost_choosePrivacy);
        f_createPost_choosePrivacy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog_choose_privacy();
            }

        });
        LinearLayout f_createPost_chooseStorage = view.findViewById(R.id.f_createPost_chooseStorage);
        f_createPost_chooseStorage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog_choose_storage();
            }
        });
        return view;
    }
    private void dialog_choose_privacy(){
        Dialog dialog = new Dialog(getActivity());
        dialog.setContentView(R.layout.dialog_choose_privacy);
        dialog.getWindow().setBackgroundDrawableResource(android.R.color.transparent);

        // constraintlayout must have
        Window window = dialog.getWindow();
        window.setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);

        ImageView f_createPost_iconPrivacy = getActivity().findViewById(R.id.f_createPost_iconPrivacy);
        TextView f_createPost_textPrivacy = getActivity().findViewById(R.id.f_createPost_textPrivacy);

        LinearLayout d_choosePrivacy_friends = dialog.findViewById(R.id.d_choosePrivacy_friends);
        d_choosePrivacy_friends.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TextView d_choosePrivacy_friendsText = dialog.findViewById(R.id.d_choosePrivacy_friendsText);
                f_createPost_iconPrivacy.setImageResource(R.drawable.icon_friends);
                f_createPost_textPrivacy.setText(d_choosePrivacy_friendsText.getText().toString());
                dialog.dismiss();
            }
        });

        LinearLayout d_choosePrivacy_only= dialog.findViewById(R.id.d_choosePrivacy_only);
        d_choosePrivacy_only.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TextView d_choosePrivacy_onlyText = dialog.findViewById(R.id.d_choosePrivacy_onlyText);
                f_createPost_iconPrivacy.setImageResource(R.drawable.icon_private);
                f_createPost_textPrivacy.setText(d_choosePrivacy_onlyText.getText().toString());
                dialog.dismiss();
            }
        });
        dialog.show();

    }
    private void dialog_choose_storage(){
        Dialog dialog = new Dialog(getActivity());
        dialog.setContentView(R.layout.dialog_choose_storage);
        dialog.getWindow().setBackgroundDrawableResource(android.R.color.transparent);

        // constraintlayout must have
        Window window = dialog.getWindow();
        window.setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);

        ImageView f_createPost_iconStorage = getActivity().findViewById(R.id.f_createPost_iconStorage);
        TextView f_createPost_textStorage = getActivity().findViewById(R.id.f_createPost_textStorage);

        LinearLayout d_chooseStorage_upload = dialog.findViewById(R.id.d_chooseStorage_upload);
        d_chooseStorage_upload.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TextView d_chooseStorage_uploadText = dialog.findViewById(R.id.d_chooseStorage_uploadText);
                f_createPost_iconStorage.setImageResource(R.drawable.icon_upload);
                f_createPost_textStorage.setText(d_chooseStorage_uploadText.getText().toString());
                dialog.dismiss();
            }
        });

        LinearLayout d_chooseStorage_addAlbum = dialog.findViewById(R.id.d_chooseStorage_addAlbum);
        d_chooseStorage_addAlbum.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TextView d_chooseStorage_addAlbumText = dialog.findViewById(R.id.d_chooseStorage_addAlbumText);
                f_createPost_iconStorage.setImageResource(R.drawable.icon_album);
                f_createPost_textStorage.setText(d_chooseStorage_addAlbumText.getText().toString());
                dialog.dismiss();
            }
        });
        dialog.show();

    }
}