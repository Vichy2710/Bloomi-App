package com.example.bloomi.LogIn;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.EditorInfo;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.bloomi.R;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link FragmentForgotPassword#newInstance} factory method to
 * create an instance of this fragment.
 */
public class FragmentForgotPassword extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public FragmentForgotPassword() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment FragmentForgotPassword.
     */
    // TODO: Rename and change types and number of parameters
    public static FragmentForgotPassword newInstance(String param1, String param2) {
        FragmentForgotPassword fragment = new FragmentForgotPassword();
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
        View view = inflater.inflate(R.layout.fragment_forgot_password, container, false);
        ImageView f_ForgotPassword_ClearSearch = view.findViewById(R.id.f_ForgotPassword_ClearSearch);
        EditText f_ForgotPassword_enterPhoneOrEmail = view.findViewById(R.id.f_ForgotPassword_enterPhoneOrEmail);

        f_ForgotPassword_enterPhoneOrEmail.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View view, boolean b) {
                f_ForgotPassword_ClearSearch.setVisibility(View.VISIBLE);
            }

        });
        f_ForgotPassword_ClearSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                f_ForgotPassword_enterPhoneOrEmail.setText("");
            }
        });

        TextView f_ForgotPassword_Cancel = view.findViewById(R.id.f_ForgotPassword_Cancel);
        f_ForgotPassword_Cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), LogIn.class);
                startActivity(intent);
            }
        });
        f_ForgotPassword_enterPhoneOrEmail.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event){
                if(actionId == EditorInfo.IME_ACTION_SEARCH){
                    FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
                    fragmentTransaction.add(R.id.fragment_forgotPassword, new FragmentConfirmAccount_ChooseSendingMethod());
                    fragmentTransaction.commit();
                    return true;
                }
                return false;
            }
        });
        return view;
    }


}