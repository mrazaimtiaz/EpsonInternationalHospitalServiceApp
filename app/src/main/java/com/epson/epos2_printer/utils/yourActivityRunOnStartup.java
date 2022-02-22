package com.epson.epos2_printer.utils;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

import com.epson.epos2_printer.ui.SplashActivity;

public class yourActivityRunOnStartup extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        if (intent.getAction().equals(Intent.ACTION_BOOT_COMPLETED)) {
            Intent i = new Intent(context, SplashActivity.class);
            i.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            context.startActivity(i);
        }
    }

}
