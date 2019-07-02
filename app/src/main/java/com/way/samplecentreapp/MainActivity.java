package com.way.samplecentreapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.centre.CentreApp;
import com.centre.CentreListeners.CentreCallbacks;

public class MainActivity extends AppCompatActivity  implements CentreCallbacks {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //Replace with your keys
        CentreApp.initialize(MainActivity.this, "YOUR_API_KEY",  "USER_GOOGLE_ADVERTISER_ID");
        CentreApp.start("testing transaction");
        CentreApp.addTrait("string", "name", "myname");
        CentreApp.addTrait("string", "email", "myemail@gmail.com");
        CentreApp.addTrait("date", "stratdate", "20192233");
        CentreApp.send();

    }

    @Override
    public void onDataSuccess(String message, String data) {
        Log.i("onDataSuccess",""+data);
        Toast.makeText(this,message.toString(),2000).show();

    }

    @Override
    public void onDataFailure(String message) {
        Log.i("onDataFailure",""+message);
        Toast.makeText(this,message.toString(),2000).show();
    }
}
