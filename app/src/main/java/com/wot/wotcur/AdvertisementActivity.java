package com.wot.wotcur;

import androidx.fragment.app.FragmentActivity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class AdvertisementActivity extends FragmentActivity {

    ImageView close;
    TextView success;

    public static Intent getCallingIntent(Context context) {
        return new Intent(context, AdvertisementActivity.class);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_advertisement);

        close = (ImageView) findViewById(R.id.img_close);
        success = (TextView) findViewById(R.id.txt_success);

        close.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.e("test","1");
                ad_exit();
            }
        });
        success.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.e("test","2");
                ad_exit();
            }
        });

    }

    @Override
    public void onBackPressed() {
        ad_exit();
    }

    public void ad_exit(){
        Intent intent = new Intent (AdvertisementActivity.this, MainActivity.class);
        startActivity(intent);
        finish();
    }

}
