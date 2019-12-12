package com.bdp.onroad;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;

public class AboutUs extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        LayoutInflater inflater = (LayoutInflater) this.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        //inflate your activity layout here!
        View contentView = inflater.inflate(R.layout.activity_about_us, null, false);
        dl.addView(contentView, 0);
    }


}
