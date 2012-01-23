package com.terheyden.saandroid;

import android.app.Activity;
import android.os.Bundle;

/**
 * Simple Activity created when you first create an Android project.
 */
public class RuntimeChangingActivity extends Activity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.runtime_changing_activity);
    }
}
