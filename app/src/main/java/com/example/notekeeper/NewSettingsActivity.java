package com.example.notekeeper;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

public class NewSettingsActivity extends AppCompatActivity {
    private LinearLayout displayName;
    private LinearLayout displayEmail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_settings);

        displayName = findViewById(R.id.display_name);

        displayName.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(NewSettingsActivity.this, EditNameActivity.class);
                startActivity(intent);
            }
        });

        displayEmail = findViewById(R.id.display_email);

        displayEmail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(NewSettingsActivity.this, EditEmail.class);
                startActivity(intent);
            }
        });

    }
}