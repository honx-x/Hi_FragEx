package com.hong.hi_fragex;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.MotionEventCompat;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;
import android.widget.ListView;

public class WearPopup extends Fragment {

    MainActivity mainActivity;
    Button wear_pop_save, wear_pop_back;
    ListView wear_popup_list;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        ViewGroup rootview = (ViewGroup) inflater.inflate(R.layout.kiosk_wear_popup, container, false);

        mainActivity = (MainActivity) getActivity();

        mainActivity.requestWindowFeature(Window.FEATURE_NO_TITLE);






    return rootview;

    }

    public void wear_save(MotionEvent event){

        if(event.getAction()==MotionEvent.ACTION_OUTSIDE){
            return; //false
        }
        return;
    }




}

