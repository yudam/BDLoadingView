package view.com.blxview;

import android.app.ActivityManager;
import android.app.Application;
import android.os.Process;
import android.util.Log;

import java.util.List;

/**
 * Created by Administrator on 2017/8/23.
 */

public class MyApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        int pid = Process.myPid();
        String processName = "";
        ActivityManager activityManager = (ActivityManager) getSystemService(ACTIVITY_SERVICE);

        List<ActivityManager.RunningAppProcessInfo> list = activityManager.getRunningAppProcesses();
        for (ActivityManager.RunningAppProcessInfo runningAppProcessInfo : list){
            if (runningAppProcessInfo.pid == pid){
                processName = runningAppProcessInfo.processName;
            }
        }

        Log.i("mao","process="+processName);
        Log.i("mao","processpid="+pid);
    }




}
