package com.terheyden.saandroid;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

/**
 * Class that is notified when the device boots up.
 */
public class UserPresentReceiver extends BroadcastReceiver {

    /**
     * Handler for when the device is unlocked.
     */
    @Override
    public void onReceive(Context context, Intent intent) {

        if (!intent.getAction().equals(Intent.ACTION_USER_PRESENT)) {
            // It's some other event we don't care about.
            return;
        }

        Toast.makeText(context, "You're here!!", Toast.LENGTH_SHORT).show();
    }
}
