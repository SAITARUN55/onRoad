package com.bdp.onroad;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.util.Log;
import android.view.KeyEvent;
import android.view.LayoutInflater;
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


public class UserRiderActivity extends BaseActivity
{
    private HikeListAdapter mAdapter;
    private DatabaseReference mDatabaseRefrence;
    private ListView mHikeListView;
   // private LinearLayout mSingleHikeContainer;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        LayoutInflater inflater = (LayoutInflater) this.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        //inflate your activity layout here!
        View contentView = inflater.inflate(R.layout.activity_user_rider, null, false);
        dl.addView(contentView, 0);

        mDatabaseRefrence= FirebaseDatabase.getInstance().getReference();
        mHikeListView=(ListView) findViewById(R.id.hike_list_view);
        //mSingleHikeContainer=(LinearLayout)findViewById(R.id.singleHikeInfoContainer);

        mHikeListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                // getting hike object from the ListView's tapped Item
                Hike hike= mAdapter.getItem(position);
                Log.d("hey","You tapped on object with name:"+hike.getmName());

                Log.d("hey","on tapping bubble, driver we got was on email:"+hike.getmDriverEmail());

                FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
                String name = user.getDisplayName();
                String email= user.getEmail();
                String ContactNumber="SOME PHONE NUMBER";
                Hitch myNewHitch= new Hitch(name,email,ContactNumber,hike.getmDriverEmail());
                mDatabaseRefrence.child("hitch").child(alterToMakeFBPath(hike.getmDriverEmail())).push().setValue(myNewHitch);
            }
        });

    }


    private String alterToMakeFBPath(String str)
    {
        Log.d("hey","got here");
        String ret="";
        for(int i=0;i<str.length();i++)
        {
            if(str.charAt(i)=='.'||str.charAt(i)=='#'||str.charAt(i)=='$'||str.charAt(i)=='['||str.charAt(i)==']')
                ret+='_';

            else
                ret+=str.charAt(i);

        }
        return ret;
    }

    @Override
    public void onStart()
    {
        super.onStart();
        mAdapter=new HikeListAdapter(this,mDatabaseRefrence);
        mHikeListView.setAdapter(mAdapter);

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
        startActivity(new Intent(UserRiderActivity.this, UserTypeActivity.class));
        finish();
    }
}