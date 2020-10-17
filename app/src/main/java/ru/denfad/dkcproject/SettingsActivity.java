package ru.denfad.dkcproject;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class SettingsActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.settings_activity);

        final EditText numWork = findViewById(R.id.numWork);
        final EditText numWeek = findViewById(R.id.numWeek);
        Button b = findViewById(R.id.button);

        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                intent.putExtra("work", Integer.valueOf(numWork.getText().toString()));
                intent.putExtra("week", Integer.valueOf(numWeek.getText().toString()));
                startActivity(intent);
            }
        });



    }
}
