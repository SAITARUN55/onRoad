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
import android.widget.AdapterView;
import android.widget.AutoCompleteTextView;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import com.bdp.onroad.LoginActivity;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;


public class UserDriverActivity2 extends AppCompatActivity
{

    private HitchListAdapter mAdapter;
    private DatabaseReference mDatabaseRefrence;
    private ListView mHitchListView;
    // private LinearLayout mSingleHikeContainer;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_driver_2);
        mDatabaseRefrence= FirebaseDatabase.getInstance().getReference();
        mHitchListView=(ListView) findViewById(R.id.hitch_list_view);
    }


    @Override
    public void onStart()
    {
        super.onStart();
        mAdapter=new HitchListAdapter(this,mDatabaseRefrence);
        mHitchListView.setAdapter(mAdapter);

    }

    @Override
    public void onStop()
    {
        super.onStop();
        mAdapter.cleanUp();
        // TODO: Remove the Firebase event listener on the adapter.

    }

    @Override
    public void onBackPressed()
    {
        super.onBackPressed();
        startActivity(new Intent(UserDriverActivity2.this, UserDriverActivity.class));
        finish();
    }
}