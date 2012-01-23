package com.terheyden.saandroid;

import android.app.Activity;
import android.os.Bundle;

/**
 * Simple Activity created when you first create an Android project.
 */
public class SimpleActivity extends Activity {

    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.simple_activity);
    }
}
