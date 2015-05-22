package helloandroid.example.org.myapplication;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.telephony.TelephonyManager;
import android.util.Log;

/**
 * Created by aagr12 on 5/22/2015.
 */
public class CallReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        Bundle extras = intent.getExtras();
        if(extras!=null){
            String phoneState = extras.getString(TelephonyManager.EXTRA_STATE);
            Log.d("Call",phoneState);

            if(phoneState.equals(extras.getString(TelephonyManager.EXTRA_STATE_RINGING))){
                String phoneNumber = extras.getString(TelephonyManager.EXTRA_INCOMING_NUMBER);
                Log.d("Call",phoneNumber);
            }
        }
    }
}
