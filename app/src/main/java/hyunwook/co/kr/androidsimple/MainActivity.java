package hyunwook.co.kr.androidsimple;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

/**
 * 18-06-15
 * AndroidStudio 설치
 * JDK :자바개발도구 (컴파일러) + AndroidStudio
 */
public class MainActivity extends FullScreenActivity {

    static final String TAG = MainActivity.class.getSimpleName();

    Button relBtn, linBtn, gravityBtn, listBtn, impBtn, intentBtn, actionBtn;
    static final int REQUEST_CODE = 1111;
    /**
     * Activity가 생성되어 시작될때 처음으로 호출됨
     * 리소스 초기화, 레이아웃 및 데이터바인딩
     *
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mainContext = this;

        relBtn = (Button) findViewById(R.id.relativeBtn);
        relBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(mainContext, RelativeActivity.class);
                startActivity(intent);
            }
        });

        linBtn = (Button) findViewById(R.id.linearBtn);
        linBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(mainContext, LinearActivity.class);
                startActivity(intent);
            }
        });

        gravityBtn = (Button) findViewById(R.id.gravityBtn);
        gravityBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(mainContext, hyunwook.co.kr.androidsimple.Gravity.class);
                startActivity(intent);
            }
        });

        listBtn = (Button) findViewById(R.id.listBtn);
        listBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(mainContext, ListView.class);
                startActivity(intent);

            }
        });

        impBtn = (Button) findViewById(R.id.imp);
        impBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:01027327899"));
                startActivity(intent);
            }
        });


        intentBtn = (Button) findViewById(R.id.intent);
        intentBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(mainContext, IntentActivity.class);
                intent.putExtra("MID", "IOSYSTEM");
                intent.putExtra("SCODE", "BONSA");
                //startActivity(intent);
                startActivityForResult(intent ,REQUEST_CODE);
            }
        });

        actionBtn = (Button) findViewById(R.id.actionBtn);
        actionBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(mainContext, ActionBarActivity.class);
                startActivity(intent);
            }
        });

    }

    /**
     *
     * @param requestCode : MainACTIVITY에서 IntentActivity를 구별
     * @param resultCode : IntentActivity에서 어떤 결과코드를 주었는지
     * @param data : IntentActivity에서 보낸 결과데이터
     */
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (resultCode == RESULT_OK) {
            switch (requestCode) {
                case REQUEST_CODE:
                    Log.d(TAG, "onActivityResult");

                    Log.d(TAG, "result -->" + data.getStringExtra("resultSetting"));
            break;
            }
            }
    }
    /**
     * Activity가 사용자에게 화면을 보여줄 준비가 되었을때 호출
     */
    @Override
    public void onStart() {
        super.onStart();

        //시계표시
        //WallClocks.startClock();

        //keyboard, numlock 연걸 검사 후 화면표시

        //db, cardreader,datasender
    }

    /**
     * Activity가 화면을 보여주고, 사용자의 입력을 처리할수있을 때
     * 애니메이션, 오디오, 동영상같이 화면 맨앞에서 실행되고있을때 필요한 리소스 처리
     */
    @Override
    public void onResume() {
        super.onResume();

        //CCTV가 실행이아닐경우 리스타트

        //Wi-fi 변화 감지 및, 시간변화

    }

    /**
     * Activity가 사용자 초점을 잃었을때 호출되는 메소드
     * onResume에서 설정했던 리소스 -> 이부분에서 해제
     *
     * onResume과 쌍
     */
    @Override
    public void onPause() {
        super.onPause();

        //CCTV가 실행중일경우 중지
    }

    /**
     * 다른 Activity가 Activity stack의 최상위에 놓이면서 이 액티비티가 보이지않을때
     * onStart과 쌍
     *
     * onStart에서 설정했던 리소스는 여기서해제
     *
     */
    @Override
    public void onStop() {
        super.onStop();

        //시계 중지, 실행중인 관련 작업 중지
    }

    /**
     * Activity가 파괴되기전에 호출
     *
     * --> 메모리부족으로 안드로이드 플랫폼이 강제로파괴시킬때
     * --> 앱완전종료
     */
    @Override
    public void onDestroy() {
        super.onDestroy();

        //녹화 모듈 종료
        //CCTV 종료
        //커넥션종료

        //네트워크상태및 WIFI 감도 체크 리시버 종료

    }

    /**
     * 액티비티가 화면에보이지않다가 다시 화면에보여줘야할때
     * onStart가 호출되기전에 필요한 설정 작업
     */
    @Override
    public void onRestart() {
        super.onRestart();
    }


}
