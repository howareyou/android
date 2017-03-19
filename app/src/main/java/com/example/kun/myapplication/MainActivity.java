package com.example.kun.myapplication;

import android.content.Intent;
import android.provider.Settings;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.List;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Intent intent = this.getIntent();
        Bundle bundle =new Bundle();
        String name = "";
        if(bundle!=null) {
            if (bundle.get("skipwifiname") != null) {
                name = bundle.get("skipwifiname").toString();
            } else {
                name = "没有收到参数";
            }
        }
        String str1 = intent.getStringExtra("skipwifiname");
        bundle = this.getIntent().getExtras();
        //String name = bundle.getString("skipwifiname");
        Log.i("获取到的name值为",name);

        WifiAdmin wa = new WifiAdmin(MainActivity.this);
        //wa.openWifi(MainActivity.this);
        //wa.closeWifi(MainActivity.this);
        //System.out.print(wa.getWifiList());
        //Log.i("获取到的wifi值为",wa.getWifiList().toString());
        //List<String> wifiList = wa.getWifiList();
        //ArrayAdapter<String> wifiListAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, wa.getWifiList());
        //ListView listView = (ListView) findViewById(R.id.wifilist);
        //listView.setAdapter(wifiListAdapter);
        //wa.addNetwork(wa.CreateWifiInfo("Android","jikun123456",3));
        TextView successMsg = (TextView) findViewById(R.id.msgText);
        successMsg.setText("成功连接热点Android ！"+str1);
        intent.putExtra("tree","返回值");
    }
}
