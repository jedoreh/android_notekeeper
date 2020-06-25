package com.example.notekeeper;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import static android.content.Intent.FLAG_ACTIVITY_NEW_TASK;

public class EditNameActivity extends AppCompatActivity {

    EditText editName;
    Button submitName;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_name);

        submitName = findViewById(R.id.submit_name);
        editName = findViewById(R.id.enter_name);

        submitName.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String enterName = editName.getText().toString();
                PreferenceClass.init(getApplicationContext());
                PreferenceClass.write(PreferenceClass.NAME, enterName);

                /*Intent i = new Intent(EditNameActivity.this,MainActivity.class);
                startActivity(i);*/
                Intent i = getBaseContext().getPackageManager().getLaunchIntentForPackage( getBaseContext().getPackageName() );
                i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(i);
                finish();

            }
        });
    }

}