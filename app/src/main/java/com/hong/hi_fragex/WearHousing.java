package com.hong.hi_fragex;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.os.AsyncTask;
import android.os.Bundle;
import android.os.StrictMode;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class WearHousing extends Fragment implements View.OnClickListener, View.OnGenericMotionListener, TextWatcher {

    private Connection conn;
    MainActivity mainActivity;
    Button btn_Reset, btn_Enter, btn_list_Reset, btn_list_Enter;
    EditText editText, editText2, editText3, editText4, editText5;

    ListView listView;
    listviewAdapter arrayAdapter;
    ArrayList<Model> arrayList;

    String dbip, dbname, dbid, dbpw;

    Boolean isSuccess = false;

    static String query = "select * from state order by curdate desc ";
    private TextWatcher loadWatcher;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        ViewGroup rootview = (ViewGroup) inflater.inflate(R.layout.kiosk_wearhousing, container, false);

        mainActivity = (MainActivity) getActivity();

        btn_Reset = rootview.findViewById(R.id.btn_reset);
        btn_Enter = rootview.findViewById(R.id.btn_enter);
        btn_list_Reset = rootview.findViewById(R.id.btn_list_reset);
        btn_list_Enter = rootview.findViewById(R.id.btn_list_enter);
        btn_Reset.setOnClickListener(this);
        btn_Enter.setOnClickListener(this);
        btn_list_Reset.setOnClickListener(this);
        btn_list_Enter.setOnClickListener(this);

        editText = rootview.findViewById(R.id.editText);
        editText.addTextChangedListener(this);
        editText2 = rootview.findViewById(R.id.editText2);
        editText3 = rootview.findViewById(R.id.editText3);
        editText4 = rootview.findViewById(R.id.editText4);
        editText5 = rootview.findViewById(R.id.editText5);


        editText.setInputType(0);
        editText2.setInputType(0);
        editText3.setInputType(0);
        editText4.setInputType(0);
        editText5.setInputType(0);

        editText.requestFocus();


        listView = rootview.findViewById(R.id.wear_list);
        arrayList = new ArrayList<Model>();
        arrayAdapter = new listviewAdapter(getActivity(), arrayList);



        /*populateList();*/


        dbip = "192.168.0.71/";
        dbname = "Hi_AndroidTest";
        dbid = "SA";
        dbpw = "hidata2312357!";

        return rootview;
    }

    private void populateList() {


        Model item;

        item = new Model("1", "Apple (Northern Spy)", "Fruits", "₹. 200", "10");
        arrayList = new ArrayList<Model>();
        arrayList.add(item);

        //arrayList.add(item);


        /*Model item1, item2, item3, item4, item5;

        item1 = new Model("1", "Apple (Northern Spy)", "Fruits", "₹. 200", "10");
        arrayList.add(item1);

        item2 = new Model("2", "Orange (Sunkist navel)", "Fruits", "₹. 100", "10");
        arrayList.add(item2);

        item3 = new Model("3", "Tomato", "Vegetable", "₹. 50", "10");
        arrayList.add(item3);

        item4 = new Model("4", "Carrot", "Vegetable", "₹. 80", "10");
        arrayList.add(item4);

        item5 = new Model("5", "Banana (Cavendish)", "Fruits", "₹. 100", "10");
        arrayList.add(item5);*/

    }

    @Override
    public boolean onGenericMotion(View v, MotionEvent event) {

        LoadMerterial loadMerterial = new LoadMerterial();
        loadMerterial.execute("");

        return false;
    }


    @Override
    public void beforeTextChanged(CharSequence s, int start, int count, int after) {

    }

    @Override
    public void onTextChanged(CharSequence s, int start, int before, int count) {
        /*String labelNo = editText.getText().toString().trim();*/

        /*LoadMerterial loadMerterial = new LoadMerterial();
        loadMerterial.execute("");
        editText.requestFocus();
*/
    }

    @Override
    public void afterTextChanged(Editable s) {

        LoadMerterial loadMerterial = new LoadMerterial();
        loadMerterial.execute("");
        editText.requestFocus();

    }


    public class LoadMerterial extends AsyncTask<String, String, String> {

        String z = "";
        /*ArrayList<String> list = new ArrayList<String>();*/


        private Connection connectionclass(String server, String database, String user, String password) {

            StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
            StrictMode.setThreadPolicy(policy);
            Connection connection = null;
            String ConnectionURL = null;
            try {
                Class.forName("net.sourceforge.jtds.jdbc.Driver");
                ConnectionURL = "jdbc:jtds:sqlserver://" + server + database + ";user=" + user + ";password=" + password + ";";
                connection = DriverManager.getConnection(ConnectionURL);
            } catch (SQLException se) {
                Log.e("error here 1 : ", se.getMessage());
            } catch (ClassNotFoundException e) {
                Log.e("error here 2 : ", e.getMessage());
            } catch (Exception e) {
                Log.e("error here 3 : ", e.getMessage());
            }
            return connection;
        }


        @Override
        protected String doInBackground(String... strings) {

            String labelNo = editText.getText().toString().trim();

          /*  if (usernam.trim().equals("") || passwordd.trim().equals(""))
                z = "사원번호와 비밀번호를 입력하여주십시오.";
            else {*/
            try {
                conn = connectionclass(dbip, dbname, dbid, dbpw);        // Connect to database
                if (conn == null) {
                    z = "DB 접속을 확인하여 주십시오.";
                } else {
                    // Change below query according to your own database.
                    String query = "select * from MD_Wearhousing where LabelNo = '" + labelNo.toString() + "'  ";
                    Statement stmt = conn.createStatement();
                    ResultSet rs = stmt.executeQuery(query);
                    if (rs.next()) {
                        z = "조회 성공";
                        /*editText.setText();*/
                        editText2.setText(rs.getString(2)); // 제품명
                        editText3.setText(rs.getString(3)); // 제품코드
                        editText4.setText(rs.getString(4)); // 중량(추후 DB값이 아닌 전자저울에서 현재값 받아오도록)
                        editText5.setText(rs.getString(5)); // 수량(추후 DB값이 아닌 공백으로 표출, notNull로 현재수량 꼭 입력하도록 조치)

                        isSuccess = true;
                        conn.close();

                    } else {
                        z = "로그인 실패. ID와 비밀번호를 확인하여 주십시오.";
                        isSuccess = false;
                    }
                }
            } catch (Exception ex) {
                isSuccess = false;
                z = ex.getMessage();
            }
            return z;

        }


    }

    @Override
    public void onClick(View v) {

        String loadStr = "";

        if (v instanceof Button) {
            switch (v.getId()) {

                case R.id.btn_list_reset:

                    listView.setAdapter(arrayAdapter);
                    arrayList.clear();

                    editText.requestFocus();

                    break;


                case R.id.btn_reset:
                    editText.setText("");
                    editText2.setText("");
                    editText3.setText("");
                    editText4.setText("");
                    editText5.setText("");

                    editText.requestFocus();
                    break;


                case R.id.btn_enter:
                    /*addListStack();*/


                    String labelNo_1 = editText.getText().toString().trim();
                    String materialNm = editText2.getText().toString().trim();
                    String materialCd = editText3.getText().toString().trim();
                    String materialWh = editText4.getText().toString().trim();
                    String materialEa = editText5.getText().toString().trim();

                    if (editText.getText() != null || editText2.getText() != null) {

                        Model item;
                        item = new Model(labelNo_1, materialNm, materialCd, materialWh, materialEa);

                        listView.setAdapter(arrayAdapter);
                        arrayList.add(item);

                        item = null;

                        editText.setText("");
                        editText2.setText("");
                        editText3.setText("");
                        editText4.setText("");
                        editText5.setText("");


                        editText.requestFocus();


                    } else {

                    }

                    break;


                /*loadStr = "라벨번호 : " + labelNo_1 + " / 원자재명 : " + materialNm + " / 제품코드 : " + materialCd + " / 제품중량 : " + materialWh + "kg / 제품수량 : " + materialEa + "ea";*/

/*
                    listView.setAdapter(arrayAdapter);
                    arrayList.add(loadStr);
*/


            }
        }


    }

/*    public void addListStack() {




    }*/


}





