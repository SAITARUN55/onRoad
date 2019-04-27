package com.bdp.onroad;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.util.Log;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.AutoCompleteTextView;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.bdp.onroad.LoginActivity;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;


public class UserTypeActivity extends AppCompatActivity {

    private DrawerLayout dl;
    private ActionBarDrawerToggle t;
    private NavigationView nv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_usertype);
        dl = (DrawerLayout)findViewById(R.id.activity_usertype);
        t = new ActionBarDrawerToggle(this, dl,R.string.app_name, R.string.about_us);

        dl.addDrawerListener(t);
        t.syncState();

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        nv = (NavigationView)findViewById(R.id.nv);
        nv.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
        @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                int id = item.getItemId();
                switch(id)
                {
                    case R.id.nav_home:
                        Toast.makeText(UserTypeActivity.this, "Home",Toast.LENGTH_SHORT).show();break;
                    case R.id.nav_aboutUs:
                        Toast.makeText(UserTypeActivity.this, "About Us",Toast.LENGTH_SHORT).show();break;
                    case R.id.nav_profile:
                        Toast.makeText(UserTypeActivity.this, "Profile",Toast.LENGTH_SHORT).show();break;
                    case R.id.nav_logout:
                        FirebaseAuth.getInstance().signOut();
                        Intent I = new Intent(UserTypeActivity.this, LoginActivity.class);
                        startActivity(I);
                        Toast.makeText(UserTypeActivity.this, "Logged You Out",Toast.LENGTH_SHORT).show();
                        break;
                    default:
                        return true;
                }
                return true;
            }
        });
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        if(t.onOptionsItemSelected(item))
            return true;

        return super.onOptionsItemSelected(item);
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