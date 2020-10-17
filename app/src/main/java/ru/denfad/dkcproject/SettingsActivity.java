package ru.denfad.dkcproject;


import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class SettingsActivity extends AppCompatActivity {

    public SharedPreferences sharedPreferencesLectures;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.settings_activity);

        final EditText numWork = findViewById(R.id.numWork);
        final EditText numWeek = findViewById(R.id.numWeek);
        Button b = findViewById(R.id.button);

        sharedPreferencesLectures = PreferenceManager.getDefaultSharedPreferences(SettingsActivity.this);

        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences.Editor editor = sharedPreferencesLectures.edit();
                editor.putInt("work", Integer.parseInt(numWork.getText().toString()));
                editor.putInt("week", Integer.parseInt(numWeek.getText().toString()));
                editor.apply();
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent);
            }
        });



    }
}
