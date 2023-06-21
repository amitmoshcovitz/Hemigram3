package com.example.hemigram;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;

import android.content.res.Configuration;
import android.os.Bundle;
import android.widget.CompoundButton;
import android.widget.Switch;

public class Settings extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);


        androidx.appcompat.widget.SwitchCompat darkmodeSwitch = findViewById(R.id.darkmodeSwitch);
        int nightModeFlags = getResources().getConfiguration().uiMode & Configuration.UI_MODE_NIGHT_MASK;

        switch(nightModeFlags) {
            case Configuration.UI_MODE_NIGHT_YES:
                darkmodeSwitch.setChecked(true);
                break;
            case Configuration.UI_MODE_NIGHT_NO:
            case Configuration.UI_MODE_NIGHT_UNDEFINED:
                darkmodeSwitch.setChecked(false);
                break;
        }

        darkmodeSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                // Toggle the theme between light and dark
                int currentNightMode = getResources().getConfiguration().uiMode & Configuration.UI_MODE_NIGHT_MASK;
                if (isChecked) {
                    if (currentNightMode != Configuration.UI_MODE_NIGHT_YES) {
                        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
                        recreate(); // Restart the activity to apply the new theme
                    }
                } else {
                    if (currentNightMode != Configuration.UI_MODE_NIGHT_NO) {
                        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
                        recreate(); // Restart the activity to apply the new theme
                    }
                }
            }
        });
    }
}