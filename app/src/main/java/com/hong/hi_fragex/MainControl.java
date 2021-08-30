package com.hong.hi_fragex;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

public class MainControl extends AppCompatActivity {

    Fragment LoginForm, HomeForm;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        LoginForm = (Fragment) new LoginForm();
        HomeForm = (Fragment) new HomeForm();

    }


}
