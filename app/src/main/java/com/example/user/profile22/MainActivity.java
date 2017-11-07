package com.example.user.profile22;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    public static final int REQUEST_PROFILE_UPDATE = 1;
    public static final String PROFILE_NAME = "com.example.user.profile22.name";
    public static final String PROFILE_EMAIL = "com.example.user.profile22.email";
    TextView textViewName,textViewEmail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textViewEmail=(TextView)findViewById(R.id.textViewEmail);
        textViewName=(TextView)findViewById(R.id.textViewName);

    }

    public void updateButton(View view){
        Intent intent = new Intent(this,Profile.class);
        startActivityForResult(intent,REQUEST_PROFILE_UPDATE);
    }

    public void visitTARUC(View view){
        String uri = "http://www.tarc.edu.my";
        Intent intent = new Intent(Intent.ACTION_VIEW);
        intent.setData(Uri.parse(uri));
        startActivity(intent);
    }

    public void showMain(View v){
        Intent intent = new Intent(Intent.ACTION_MAIN);
        startActivity(intent);
    }

    public void showDial(View v){
        Intent intent = new Intent(Intent.ACTION_DIAL,Uri.parse("tel:" + "123456789"));
        startActivity(intent);
    }

    public void showSendTo(View v){
        Intent intent = new Intent(Intent.ACTION_SENDTO);

        intent.setData(Uri.parse("mailto:" + "seekt@tarc.edu.my"));

        startActivity(intent);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        //Requeast code = a unique code to identify an intent
        //Result code = result of an intent call;either OR or cancel
        //data = the actualy data returned by an intent

        if(requestCode==REQUEST_PROFILE_UPDATE){
            String name,email;
            name = data.getStringExtra(PROFILE_NAME);
            email = data.getStringExtra(PROFILE_EMAIL);
            textViewName.setText(getString(R.string.textViewName)+name);
            textViewEmail.setText(getString(R.string.textViewEmail)+email);
        }
    }
}
