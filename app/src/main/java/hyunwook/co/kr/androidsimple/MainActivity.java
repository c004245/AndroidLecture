package hyunwook.co.kr.androidsimple;

import android.os.Bundle;

/**
 * 18-06-15
 * AndroidStudio 설치
 * JDK :자바개발도구 (컴파일러) + AndroidStudio
 */
public class MainActivity extends FullScreenActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mainContext = this;

    }
}
