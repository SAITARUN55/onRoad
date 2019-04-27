package com.bdp.onroad;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.FragmentActivity;
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
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class UserDriverActivity  extends AppCompatActivity//FragmentActivity implements OnMapReadyCallback
{

    private AutoCompleteTextView mstartingTime,mstartingPlace,mDestination,mNoOfSeats,mContactNumber;
    private DatabaseReference mDatabaseRefrence;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_driver);
//
//        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.mapp);
//        mapFragment.getMapAsync(this);

        // NEW FROM HERE!!!
        mDatabaseRefrence= FirebaseDatabase.getInstance().getReference();
        mstartingTime = (AutoCompleteTextView)findViewById(R.id.startingTime);
        mstartingPlace= (AutoCompleteTextView)findViewById(R.id.startingPlace);
        mDestination=   (AutoCompleteTextView)findViewById(R.id.destination);
        mNoOfSeats=     (AutoCompleteTextView)findViewById(R.id.noOfSeats);
        mContactNumber= (AutoCompleteTextView)findViewById(R.id.contactNumber);

    }
    public void createHike(View V)
    {
        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();

        String name = user.getDisplayName();
        String startingTime=mstartingTime.getText().toString();
        String startingPlace=mstartingPlace.getText().toString();
        String stination=mDestination.getText().toString();
        String noOfSeats=mNoOfSeats.getText().toString();
        String contactNumber=mContactNumber.getText().toString();
        //  TODO:   Get Contact Number From DataBase and remove from here and from activity_user_driver layout form
        if(TextUtils.isEmpty(name)||TextUtils.isEmpty(startingTime)||TextUtils.isEmpty(stination)||TextUtils.isEmpty(startingPlace)||TextUtils.isEmpty(noOfSeats)||TextUtils.isEmpty(contactNumber))
        {
            Log.d("hey","HIKE Form not completely filled!!!!!!");
            new AlertDialog.Builder(this)
                    .setTitle("Waoh")
                    .setMessage("Please Fill All the Fields")
                    .setPositiveButton(android.R.string.ok,null)
                    .setIcon(android.R.drawable.ic_dialog_alert)
                    .show();
        }
        else
        {
            Hike myNewHike = new Hike(name,startingTime,startingPlace,stination,noOfSeats,contactNumber);
            mDatabaseRefrence.child("Hike").push().setValue(myNewHike);

            //TODO: Set init to different activity do not let Driver make the same hike again!

        }

    }





//    @Override
//    public void onMapReady(GoogleMap googleMap)
//    {
//
//
//
//    }

}