package com.example.settings;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private final static String SETTING_NAME = "settings";

    private SharedPreferences preferences;
    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView = findViewById(R.id.tv);
        (findViewById(R.id.b)).setOnClickListener(this);

        preferences = getPreferences(MODE_PRIVATE);
        String result = preferences.getString(SETTING_NAME, textView.getText().toString());
        textView.setText(result);
    }

    @Override
    public void onClick(View v) {

        String value = "" + Math.round(Math.random() * 100);


        SharedPreferences.Editor edit = preferences.edit();
        edit.putString(SETTING_NAME, value);

        edit.apply();
    }
}
