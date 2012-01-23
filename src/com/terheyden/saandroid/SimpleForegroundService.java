package com.terheyden.saandroid;

import android.app.IntentService;
import android.app.Notification;
import android.app.PendingIntent;
import android.content.Intent;
import android.util.Log;

public class SimpleForegroundService extends IntentService {

    private static final String TAG = "SimpleForegroundService";

    public SimpleForegroundService() {
        super(TAG);
    }

    /**
     * Called when the service is started.
     */
    @Override
    public void onCreate() {

        super.onCreate();
        Log.d(TAG, "Foreground service created.");

        // Start foreground service stuff.
        startForegroundNotify();
    }

    /**
     * Main loop method.
     * Called when the service starts.
     * Service dies when this method ends.
     */
    @Override
    protected void onHandleIntent(Intent intent) {

        try {
            while (true) {
                Thread.sleep(5000);
            }
        } catch (InterruptedException e) {
            Log.d(TAG, e.getLocalizedMessage());
        }

        stopForeground(true);
    }

    private static final int ID_FG_SVC_ACTIVITY = 15;
    private static final int ID_SIMPLE_FG_SVC = 16;

    private void startForegroundNotify() {

        Log.i(TAG, "Starting foreground notification.");
        String notifyTitle = "Simple FG Service";
        String notifyMsg = "Tap to activate my sample Notification!";

        Notification notification = new Notification(
            R.drawable.ic_launcher,
            notifyTitle,
            System.currentTimeMillis());

        // When the notification is selected by the user, fire off a ClipsListActivity intent.
        Intent showClipsIntent = new Intent(this, ForegroundServiceActivity.class);
        PendingIntent pendingIntent = PendingIntent.getActivity(this, ID_FG_SVC_ACTIVITY, showClipsIntent, 0);
        notification.setLatestEventInfo(this, notifyTitle, notifyMsg, pendingIntent);
        startForeground(ID_SIMPLE_FG_SVC, notification);
    }
}
