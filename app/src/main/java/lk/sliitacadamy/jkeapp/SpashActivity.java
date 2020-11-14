package lk.sliitacadamy.jkeapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.ProgressBar;

public class SpashActivity extends AppCompatActivity {
    ProgressBar progressBar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_spash);
        progressBar=findViewById(R.id.progressBar);
        progressBar.setVisibility(View.VISIBLE);

        SharedPreferences sharedPref = getApplicationContext().getSharedPreferences(getString(R.string.PREF_User),Context.MODE_PRIVATE);
        final String userEmail =null;
        sharedPref.getString(getString(R.string.PREF_User),userEmail);

        Handler handler=new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent=null;
                if (userEmail==null)
                {
                    intent=new Intent(SpashActivity.this,RegisterActivity.class);

                }else
                {
                    intent=new Intent(SpashActivity.this,MainActivity.class);
                }


                startActivity(intent);
            }
        },15000);
    }
}