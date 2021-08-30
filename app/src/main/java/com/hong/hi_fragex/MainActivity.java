package com.hong.hi_fragex;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Fragment LoginForm, HomeForm, HomeForm2, FirstForm,WearHousing;
    public Button btn_Num1, btn_Num2, btn_Num3, btn_Enter,
            btn_Num4, btn_Num5, btn_Num6, btn_Back,
            btn_Num7, btn_Num8, btn_Num9, btn_Num0, btn_Backspace;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        LoginForm = (Fragment) new LoginForm();
        HomeForm = (Fragment) new HomeForm();
        HomeForm2 = new HomeForm2();
        FirstForm = (Fragment) new FirstForm();
        WearHousing = (Fragment) new WearHousing();


        btn_Num1 = (Button) findViewById(R.id.key_Num1);
        btn_Num1.setOnClickListener(this);
        btn_Num2 = (Button) findViewById(R.id.key_Num2);
        btn_Num2.setOnClickListener(this);
        btn_Num3 = (Button) findViewById(R.id.key_Num3);
        btn_Num3.setOnClickListener(this);
        btn_Num4 = (Button) findViewById(R.id.key_Num4);
        btn_Num4.setOnClickListener(this);
        btn_Num5 = (Button) findViewById(R.id.key_Num5);
        btn_Num5.setOnClickListener(this);
        btn_Num6 = (Button) findViewById(R.id.key_Num6);
        btn_Num6.setOnClickListener(this);
        btn_Num7 = (Button) findViewById(R.id.key_Num7);
        btn_Num7.setOnClickListener(this);
        btn_Num8 = (Button) findViewById(R.id.key_Num8);
        btn_Num8.setOnClickListener(this);
        btn_Num9 = (Button) findViewById(R.id.key_Num9);
        btn_Num9.setOnClickListener(this);
        btn_Num0 = (Button) findViewById(R.id.key_Num0);
        btn_Num0.setOnClickListener(this);
        btn_Enter = (Button) findViewById(R.id.key_Enter);
        btn_Enter.setOnClickListener(this);
        btn_Back = (Button) findViewById(R.id.key_Back);
        btn_Back.setOnClickListener(this);
        btn_Backspace = (Button) findViewById(R.id.key_Backspace);
        btn_Backspace.setOnClickListener(this);

        getSupportFragmentManager().beginTransaction().replace(R.id.frame1, FirstForm).commit();

    }

    public void pageChange(int index) {
        if (index == 0) {
            getSupportFragmentManager().beginTransaction().replace(R.id.frame1, FirstForm).commit();
        } else if (index == 1) {
            getSupportFragmentManager().beginTransaction().replace(R.id.frame1, LoginForm).commit();
        } else if (index == 2) {
            getSupportFragmentManager().beginTransaction().replace(R.id.frame1, HomeForm2).commit();
        }
    }



    @Override
    public void onClick(View keyView) {

        View view = getCurrentFocus();

        if (view instanceof EditText) {
            switch (keyView.getId()) {
                case R.id.key_Num1:
                    ((EditText) view).append("1");
                    break;
                case R.id.key_Num2:
                    ((EditText) view).append("2");
                    break;
                case R.id.key_Num3:
                    ((EditText) view).append("3");
                    break;
                case R.id.key_Num4:
                    ((EditText) view).append("4");
                    break;
                case R.id.key_Num5:
                    ((EditText) view).append("5");
                    break;
                case R.id.key_Num6:
                    ((EditText) view).append("6");
                    break;
                case R.id.key_Num7:
                    ((EditText) view).append("7");
                    break;
                case R.id.key_Num8:
                    ((EditText) view).append("8");
                    break;
                case R.id.key_Num9:
                    ((EditText) view).append("9");
                    break;
                case R.id.key_Num0:
                    ((EditText) view).append("0");
                    break;
                case R.id.key_Back:
                    ((EditText) view).append("");
                    break;
                case R.id.key_Backspace:
                    if (((EditText) view).getText().length() > 0) {
                        ((EditText) view).getText().delete(((EditText) view).getText().length() - 1, ((EditText) view).getText().length());
                    }
                    break;
                case R.id.key_Enter:
                    ((EditText) view).append("");
                    break;


            }
        }

    }


}
