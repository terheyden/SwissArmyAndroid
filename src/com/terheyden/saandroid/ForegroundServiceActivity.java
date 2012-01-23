package com.terheyden.saandroid;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class ForegroundServiceActivity extends Activity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fg_svc_activity);
    }

    public void onStartSvcButtonClick(View button) {
        startService(new Intent(this, SimpleForegroundService.class));
    }

    public void onStopSvcButtonClick(View button) {
        stopService(new Intent(this, SimpleForegroundService.class));
    }
}
