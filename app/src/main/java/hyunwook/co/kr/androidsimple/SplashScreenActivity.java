package hyunwook.co.kr.androidsimple;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;


/**
 * Created by Administrator on 2015-03-13.
 */
public class SplashScreenActivity extends FullScreenActivity {

    protected ImageView mGoldStar;
    private CountDownTimer countDownTimer;
    public TextView text;
    private final long startTime = 6 * 1000;
    private final long interval = 1 * 1000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_splash);

        mGoldStar = (ImageView) findViewById(R.id.rotate);

        Animation rotation = AnimationUtils.loadAnimation(this, R.anim.rotate);
        rotation.setRepeatCount(Animation.INFINITE);
        text = (TextView) this.findViewById(R.id.timer);

        countDownTimer = new MyCountDownTimer(startTime, interval);
        text.setText(text.getText() + String.valueOf(startTime / 1000));
        mGoldStar.startAnimation(rotation);
        countDownTimer.start();

    }

    public class MyCountDownTimer extends CountDownTimer {
        public MyCountDownTimer(long startTime, long interval) {
            super(startTime, interval);
        }

        @Override
        public void onFinish() {
            text.setText("0");
            Intent intent = new Intent(mainContext, MainActivity.class);
            startActivity(intent);
        }

        @Override
        public void onTick(long millisUntilFinished) {
            text.setText("" + millisUntilFinished / 1000);
        }
    }
}
