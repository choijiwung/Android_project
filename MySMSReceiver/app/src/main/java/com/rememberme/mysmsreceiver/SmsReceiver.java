package com.rememberme.mysmsreceiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.telephony.SmsMessage;
import android.util.Log;

import java.util.Date;

public class SmsReceiver extends BroadcastReceiver {
        private static final  String TAG = "SmsReceiver";

    @Override
    public void onReceive(Context context, Intent intent) {
        Log.d(TAG, "onReceive() 호출됨");

        Bundle bundle = intent.getExtras();
        SmsMessage[] messages = parseSmsMessage(bundle);

        if(messages.length >0){
            String sender = messages[0].getOriginatingAddress();
            Log.d(TAG, "sender : " + sender);

            String contents = messages[0].getDisplayMessageBody().toString();
            Log.d(TAG, "contents : " + contents);

            Date receivedDate = new Date(messages[0].getTimestampMillis());
            Log.d(TAG, "received Date:" + receivedDate);
        }
    }

    private  SmsMessage[] parseSmsMessage(Bundle bundle){
        Object[] objs = (Object[]) bundle.get("pdus");
        SmsMessage[] messages = new SmsMessage[objs.length];

        for (int i=0; i <objs.length; i++){
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M){
                String format = bundle.getString("format");
                SmsMessage.createFromPdu((byte[])objs[i], format);

            }else {
                SmsMessage.createFromPdu((byte[]) objs[i]);
            }
        }
        return messages;
    }

}
