package com.example.user.profile22;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class Profile extends AppCompatActivity {

    private EditText editTextName,editTextEmail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        editTextEmail=(EditText)findViewById(R.id.editTextEmail);
        editTextName=(EditText)findViewById(R.id.editTextName);
    }

    public void saveProfile(View view){
        //who called me
        Intent intent = getIntent();

        String name = editTextName.getText().toString();
        String email = editTextEmail.getText().toString();

        intent.putExtra(MainActivity.PROFILE_NAME,name);
        intent.putExtra(MainActivity.PROFILE_EMAIL,email);

        setResult(MainActivity.REQUEST_PROFILE_UPDATE,intent);

        finish();
    }
}
