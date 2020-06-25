package com.example.notekeeper;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class EditEmail extends AppCompatActivity {

    EditText editEmail;
    Button submitName;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_email);

        submitName = findViewById(R.id.submit_name);
        editEmail = findViewById(R.id.enter_email);

        submitName.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String enterEmail = editEmail.getText().toString();
                PreferenceClass.init(getApplicationContext());
                PreferenceClass.write(PreferenceClass.EMAIL, enterEmail);

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