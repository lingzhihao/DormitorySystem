package com.example.dormitorysystem;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

import static com.blankj.utilcode.util.ActivityUtils.startActivity;

public class CameraBroadcastReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        Toast.makeText(context,"接收广播",Toast.LENGTH_SHORT).show();
        intent = new Intent(context, IdInputActivity.class);
        startActivity(intent);
    }
}
