package com.hong.hi_fragex;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.Toolbar;

import com.google.android.material.navigation.NavigationView;

public class HomeForm extends Fragment  {

    MainActivity mainActivity;
    NavigationView navigationView;
    DrawerLayout drawerLayout;
    Fragment LoginForm;

    EditText main_editText1,main_editText2;
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
        ViewGroup rootview = (ViewGroup) inflater.inflate(R.layout.home_form, container, false);

        mainActivity = (MainActivity) getActivity();
/*

        ActionBar actionBar = mainActivity.getSupportActionBar();
        actionBar.setTitle("HiMES HOME");
        actionBar.setDisplayHomeAsUpEnabled(true);

*/


/*        Toolbar toolbar = mainActivity.findViewById(R.id.toolbar);*/
     /*   ((AppCompatActivity)getActivity()).setSupportActionBar(toolbar);*/


        drawerLayout = mainActivity.findViewById(R.id.home_drawer);
        navigationView = mainActivity.findViewById(R.id.nav_view);

        main_editText1 = rootview.findViewById(R.id.main_editText1);
        main_editText1.setInputType(0);
        main_editText2 = rootview.findViewById(R.id.main_editText2);
        main_editText2.setInputType(0);

/*        toolbar = rootview.findViewById(R.id.toolbar);*/


/*        navigationView.setNavigationItemSelectedListener(this);*/

        initLayout();
        return rootview;

    }

    private void initLayout() {

/*        Toolbar toolbar = mainActivity.findViewById(R.id.toolbar);*/

/*        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.Open, R.string.Close);*/

/*        drawerLayout = mainActivity.findViewById(R.id.drawer_layout);
        navigationView = mainActivity.findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);*/

    }



/*
    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {

        switch (item.getItemId()) {
            case R.id.nav_logout:
                mainActivity.pageChange(0);
                break;

        }
*/
/*
        int id = item.getItemId();
        if (id == R.id.nav_logout) {

            mainActivity.LoginForm = new LoginForm();
            mainActivity.getSupportFragmentManager().beginTransaction().replace(R.id.frame1, LoginForm).commit();

        }*//*

        drawerLayout.closeDrawer(GravityCompat.START);
        return true;
    }
*/

}
