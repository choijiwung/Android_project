package com.rememberme.myservice;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;

public class MyService extends Service {
    private static final String TAG = "MYSERVICE";

    public MyService() {
    }

    @Override
    public void onCreate() {
        super.onCreate();
        Log.d(TAG, "onCreate()호출됨");
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.d(TAG, "onStartCommand호출됨");
//      서비스는 계속 실행되니때문에 intent로 정보를 전달할때 확인할수가없다.
//      그럴때는 onstartCommand를 사용한다.
        if (intent == null){
            return Service.START_STICKY;
//          서비스가 종료 되었을 때 자동으로 다시 실행 된다는 뜻
        }else{
            procesCommand(intent);
        }
        return super.onStartCommand(intent, flags, startId);

    }
    public void procesCommand(Intent intent){
        String command = intent.getStringExtra("command");
        String name = intent.getStringExtra("name");

        Log.d(TAG,"전달받은 데이터" + command + name);
    }

    @Override
    public void onDestroy() {
        Log.d(TAG, "onDestroy()호출됨");
        super.onDestroy();
    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        throw new UnsupportedOperationException("Not yet implemented");
    }
}
