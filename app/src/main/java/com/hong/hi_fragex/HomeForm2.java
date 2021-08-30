package com.hong.hi_fragex;

import android.content.Context;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.Toolbar;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import com.google.android.material.navigation.NavigationView;

public class HomeForm2 extends Fragment implements NavigationView.OnNavigationItemSelectedListener {


    MainActivity mainActivity;
    NavigationView navigationView;
    DrawerLayout drawerLayout;
    FrameLayout frameLayout, homeframe;
    Fragment LoginForm, WearHousing;

    Toolbar toolbar;

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);

        mainActivity = (MainActivity) getActivity();
    }

    @Override
    public void onDetach() {
        super.onDetach();

        mainActivity = null;
    }


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        ViewGroup rootview = (ViewGroup) inflater.inflate(R.layout.home_form2, container, false);

        mainActivity = (MainActivity) getActivity();
        frameLayout = mainActivity.findViewById(R.id.main_frame);
        homeframe = mainActivity.findViewById(R.id.frame1);


        /*        initLayout();*/
        return rootview;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {


        FragmentManager childFragment = getChildFragmentManager();
        childFragment.beginTransaction().add(R.id.main_frame, new HomeMain()).commit(); // 메인화면에 넣을 화면

        drawerLayout = mainActivity.findViewById(R.id.home_drawer);
        navigationView = mainActivity.findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);


        super.onViewCreated(view, savedInstanceState);
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.nav_a1) {
            FragmentManager childFragment = getChildFragmentManager();

            childFragment.beginTransaction().replace(R.id.main_frame, new WearHousing()).commit();


        } else if (id == R.id.nav_home) {
            FragmentManager childFragment = getChildFragmentManager();

            childFragment.beginTransaction().replace(R.id.main_frame, new HomeMain()).commit();

        } else if (id == R.id.nav_logout) {

            FragmentManager childFragment = getChildFragmentManager();
            childFragment.beginTransaction().add(R.id.main_frame, new FirstForm()).commit();
/*            mainActivity.getSupportFragmentManager().beginTransaction().replace(R.id.frame1, LoginForm).commit();*/

        }


        drawerLayout.closeDrawer(Gravity.LEFT);
        return false;
    }

/*    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();

        if(id==R.id.nav_notice){
            FragmentManager childFragment = getChildFragmentManager();
            childFragment.beginTransaction().add(R.id.main_frame, new WearHousing()).commit();
        }

        return false;
    }*/
}