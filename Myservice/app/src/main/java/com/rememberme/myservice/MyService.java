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

        try{
        Thread.sleep(5000);
        }catch(Exception e){}

        Intent showIntent = new Intent(getApplicationContext(), MainActivity.class);
//       MainActivity.class로 보내겠다.
        showIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK|
                            Intent.FLAG_ACTIVITY_SINGLE_TOP|
//                화면을 재활용 해달라
                            Intent.FLAG_ACTIVITY_CLEAR_TOP);
//                화면이 있으면 없애달라
        showIntent.putExtra("command","show");
        showIntent.putExtra("name", name + " from service");
//      add flag만 하면 문제가 생긴다.
//
        startActivity(showIntent);
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
