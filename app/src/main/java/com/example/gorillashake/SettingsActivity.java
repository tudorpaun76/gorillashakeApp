package com.example.gorillashake;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.TextView;

import com.google.android.material.switchmaterial.SwitchMaterial;

import org.w3c.dom.Text;

public class SettingsActivity extends AppCompatActivity {
    private View parentView;
    private SwitchMaterial themeSwitch;
    private TextView themeTV, titleTV;
    private UserSettings settings;
    private EditText mNameEt,mAgeEt;
    private Button mSaveBtn, mInfoBtn ;
    private TextView mInfoTv;


    Button RETURNSETTINGS;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);

        settings = (UserSettings) getApplication();
        initWidgets();
        loadSharedPreferences();
        initSwitchListener();

        Button btn = (Button)findViewById(R.id.RETURNSETTINGS);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), HomeActivity.class));

            }
        });
        mNameEt =findViewById(R.id.nameEt);
        mAgeEt=findViewById(R.id.ageEt);
        mSaveBtn=findViewById(R.id.saveBtn);
        mInfoBtn=findViewById(R.id.showBtn);
        mInfoTv=findViewById(R.id.infoTV);

        SharedPreferences sharedPreferences = getSharedPreferences("SP_NAME", MODE_PRIVATE);

        mSaveBtn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                String name = mNameEt.getText().toString();
                int age = Integer.parseInt(mAgeEt.getText().toString().trim());
                SharedPreferences.Editor editor = sharedPreferences.edit();

                editor.putString("NAME", name);
                editor.putInt("AGE", age);
                editor.apply();
            }


        });
        mInfoBtn.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                String name =sharedPreferences.getString("NAME","");
                int age = sharedPreferences.getInt("AGE", 0);
                mInfoTv.setText("Name: "+name +"\nAge: "+age);

            }
        });

    }


    private void initWidgets() {
        themeTV = findViewById(R.id.themeTV);
        titleTV = findViewById(R.id.titleTV);
        themeSwitch = findViewById(R.id.themeSwitch);
        parentView = findViewById(R.id.parentView);
        mNameEt =findViewById(R.id.nameEt);
        mAgeEt=findViewById(R.id.ageEt);
        mSaveBtn=findViewById(R.id.saveBtn);
        mInfoBtn=findViewById(R.id.showBtn);
        mInfoTv=findViewById(R.id.infoTV);
    }

    private void loadSharedPreferences() {
        SharedPreferences sharedPreferences =getSharedPreferences(UserSettings.PREFERENCES, MODE_PRIVATE);
        String theme = sharedPreferences.getString(UserSettings.CUSTOM_THEME, UserSettings.LIGHT_THEME);
        settings.setCustomTheme(theme);
        updateView();
    }
    private void initSwitchListener() {
        themeSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean checked)
            {
                if(checked)
                    settings.setCustomTheme(UserSettings.DARK_THEME);
                else
                    settings.setCustomTheme(UserSettings.LIGHT_THEME);

                SharedPreferences.Editor editor =getSharedPreferences(UserSettings.PREFERENCES, MODE_PRIVATE).edit();
                editor.putString(UserSettings.CUSTOM_THEME,settings.getCustomTheme());
                editor.apply();
                updateView();
            }
        });
    }

    private void updateView() {
        final int black = ContextCompat.getColor(this, R.color.black);
        final int white = ContextCompat.getColor(this, R.color.white);

        if (settings.getCustomTheme().equals(UserSettings.DARK_THEME)) {
            titleTV.setTextColor(white);
            themeTV.setTextColor(white);
            mNameEt.setTextColor(white);
            mAgeEt.setTextColor(white);
            mInfoTv.setTextColor(white);
            themeTV.setText("Dark");
            parentView.setBackgroundColor(black);
            themeSwitch.setChecked(true);
        } else {
            titleTV.setTextColor(black);
            themeTV.setTextColor(black);
            mNameEt.setTextColor(black);
            mAgeEt.setTextColor(black);
            mInfoTv.setTextColor(black);
            themeTV.setText("Light");
            parentView.setBackgroundColor(white);
            themeSwitch.setChecked(false);
        }
    }


}

