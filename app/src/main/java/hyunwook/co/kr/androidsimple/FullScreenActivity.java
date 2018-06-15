package hyunwook.co.kr.androidsimple;

import android.app.Activity;
import android.app.FragmentManager;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.widget.Toast;


/**
 * Created by Administrator on 2015-03-13.
 */
public abstract class FullScreenActivity extends FragmentActivity {

    protected static FragmentManager mFragment = null;

    protected static Context mainContext = null;
    protected static Activity mainActivity = null;

    protected static MainActivity mainBEActivity = null;
    private static int currentUiPid = 0;
    private static int currentTid = 0;

    /*private static void resourcesUpdate() {
        if (currentTid == android.os.Process.myTid()) {
            currentUiPid =
        }
    }*/

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //currentUiPid = android.os.Process.myUid();

        //mFragment = getSupportFragmentManager();
        mFragment = getFragmentManager();
        mainActivity = this;
        mainContext = this;
        mainBEActivity = new MainActivity();


        /*int tid = android.os.Process.myTid();
        if (currentUiPid == tid) {
            Log.d("ACTIVITY_TID_TEST", "current uid: " + currentUiPid +
                    " thread pid: " + tid);
        }*/
    }

    @Override
    protected void onStart() {
        super.onStart();

        getWindow().getDecorView().setSystemUiVisibility(
                View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                        | View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                        | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                        | View.SYSTEM_UI_FLAG_FULLSCREEN
                        | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY
                        | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
        );
    }

    @Override
    protected void onRestart() {
        super.onRestart();
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    protected void onPostResume() {
        super.onPostResume();
    }

    @Override
    protected void onPause() {
        super.onPause();
    }

    @Override
    protected void onStop() {
        super.onStop();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    @Override
    public void finish() {
        super.finish();


    }

    protected static Object findView(final int id) {
        return mainActivity.findViewById(id);
    }

    protected static void onUiThreadJab(final Runnable runnable) {
        if (mainActivity != null)
            mainActivity.runOnUiThread(runnable);
    }

    public static FragmentManager getMainFramgment() {

        return mFragment;
    }

    public static Activity getMainActivity() {
        return mainActivity;
    }

    public static MainActivity getBEMainActivity() {
        return mainBEActivity;
    }


    public static void showToast(final String msg, final int duration) {

        if (currentUiPid == android.os.Process.myTid())
            Toast.makeText(mainContext, msg, duration).show();
        else {
            onUiThreadJab(new Runnable() {
                @Override
                public void run() {
                    Toast.makeText(mainContext, msg, duration).show();
                }
            });
        }
    }
}
