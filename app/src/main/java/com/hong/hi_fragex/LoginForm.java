package com.hong.hi_fragex;

import android.os.AsyncTask;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.os.StrictMode;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class LoginForm extends Fragment implements View.OnClickListener {

    MainActivity mainActivity;
    Button loginBtn;
    EditText edit_id, edit_pw;
    ProgressBar progressBar;
    Fragment HomeForm2;

    Connection conn;
    String dbip, dbname, dbid, dbpw;

    Boolean isSuccess = false;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        final ViewGroup rootview = (ViewGroup) inflater.inflate(R.layout.loginform, container, false);

        mainActivity = (MainActivity) getActivity();
        HomeForm2 = (Fragment) new HomeForm2();

        loginBtn = (Button) rootview.findViewById(R.id.loginButton);
        loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mainActivity.pageChange(2);
            }
        });
        edit_id = (EditText) rootview.findViewById(R.id.edit_id);
        edit_id.setInputType(0);
        edit_pw = rootview.findViewById(R.id.edit_pw);
        edit_pw.setInputType(0);
        progressBar = (ProgressBar) rootview.findViewById(R.id.progressBar);


        dbip = "192.168.0.71/";
        dbname = "Hi_AndroidTest";
        dbid = "SA";
        dbpw = "hidata2312357!";

        loginBtn.setOnClickListener(this);

        return rootview;

    }

    @Override
    public void onClick(View v) {

        /* getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.frame1, HomeForm2).commit();*/

        CheckLogin checklogin = new CheckLogin();
        checklogin.execute("");

    }

    public class CheckLogin extends AsyncTask<String, String, String> {

        String z = "";


        @Override
        protected void onPreExecute() {

            progressBar.setVisibility(View.VISIBLE);
        }

        @Override
        protected void onPostExecute(String r) {
            progressBar.setVisibility(View.GONE);
            Toast.makeText(getActivity(), r, Toast.LENGTH_SHORT).show();
            if (isSuccess) {
                /*Toast.makeText(getActivity(), "Login Successfull", Toast.LENGTH_LONG).show();*/
                getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.frame1, HomeForm2).commit();
                //finish();
            }
        }

        @Override
        public String doInBackground(String... strings) {
            String usernam = edit_id.getText().toString();
            String passwordd = edit_pw.getText().toString();
            if (usernam.trim().equals("") || passwordd.trim().equals(""))
                z = "사원번호와 비밀번호를 입력하여주십시오.";
            else {
                try {
                    conn = connectionclass(dbip, dbname, dbid, dbpw);        // Connect to database
                    if (conn == null) {
                        z = "DB 접속을 확인하여 주십시오.";
                    } else {
                        // Change below query according to your own database.
                        String query = "select * from MD_UserInfo where user_id= '" + usernam.toString() + "' and user_pw = '" + passwordd.toString() + "'  ";
                        Statement stmt = conn.createStatement();
                        ResultSet rs = stmt.executeQuery(query);
                        if (rs.next()) {


                            z = "로그인 성공";
                            isSuccess = true;

                            edit_id.setText("");
                            edit_pw.setText("");

                            conn.close();



                        } else {
                            z = "로그인 실패\n사원번호와 비밀번호를 확인하여 주십시오.";
                            isSuccess = false;
                        }
                    }
                } catch (Exception ex) {
                    isSuccess = false;
                    z = ex.getMessage();
                }

            }

            return z;

        }

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


    }
}

