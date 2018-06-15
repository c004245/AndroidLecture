package hyunwook.co.kr.androidsimple;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

/**
 * Created by hyunwook on 2018-06-15.
 */

public class IntentActivity extends Activity {

    String mid, scode;
    Intent intent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.intent);

         intent = getIntent();
        mid = intent.getStringExtra("MID");
        scode = intent.getStringExtra("SCODE");

        TextView tvMid = (TextView) findViewById(R.id.tvMid);
        tvMid.setText("MID --->" + mid);

        TextView tvScode = (TextView) findViewById(R.id.tvScode);
        tvScode.setText("SCODE --->" + scode);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Log.d("IntentActivity", "Backpressed");
        Intent intent = new Intent();
        intent.putExtra("resultSetting", "결과를 처리하였습니다..");
        setResult(RESULT_OK, intent);
        finish();

    }

}
