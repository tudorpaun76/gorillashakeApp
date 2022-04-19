package com.example.gorillashake;

import android.app.Application;

public class UserSettings extends Application {
    public static final String PREFERENCES ="preferences";
    public static final String CUSTOM_THEME ="CustomTheme";
    public static final String LIGHT_THEME ="LightTheme";
    public static final String DARK_THEME ="DarkTheme";


    private String customTheme;

    public String getCustomTheme() {
        return customTheme;
    }

    public void setCustomTheme(String customTheme) {
        this.customTheme = customTheme;
    }


}
