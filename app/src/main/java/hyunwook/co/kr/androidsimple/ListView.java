package hyunwook.co.kr.androidsimple;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ArrayAdapter;

/**
 * Created by hyunwook on 2018-06-15.
 */

public class ListView extends Activity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.listview);

        //ListView
        // 데이터 원본 준비
        String[] items = {"item1", "item2", "item3",
                "item4","item5","item6","item7","item8", "item9", "item9","item10","item11","item12","item13","item14","item15","item16","item17","item18",};

        //어댑터 생성
        ArrayAdapter<String> adapt = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, items);

        //어댑터 연결
        android.widget.ListView list = (android.widget.ListView) findViewById(R.id.listView);
        list.setAdapter(adapt);
    }
}
