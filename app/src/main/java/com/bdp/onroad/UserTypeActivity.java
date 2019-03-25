package com.bdp.onroad;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.AutoCompleteTextView;
import android.widget.EditText;
import android.widget.TextView;

import com.bdp.onroad.LoginActivity;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;


public class UserTypeActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_usertype);
    }
    public void setUserDriver(View V)
    {


        Intent intnt = new Intent(UserTypeActivity.this, UserDriverActivity.class);
        finish();
        startActivity(intnt);
        Log.d("hey","User is Driver") ;
    }
    public void setUserRider(View V)
    {

        Intent intnt = new Intent(UserTypeActivity.this, UserRiderActivity.class);
        finish();
        startActivity(intnt);
        Log.d("hey","User is Rider") ;
    }
}