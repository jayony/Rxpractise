package com.example.rxpractise;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.rxpractise.event.EventResponse;

import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

public class MainActivity extends AppCompatActivity {

    TextView txt_response;
    public ParctiseRXInte parctiseRXInte = new ParctiseRXInte();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        txt_response = findViewById(R.id.txt_response);
        EventManager.getInstance().getEvent().register(this);

        parctiseRXInte.createRequest();

    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onResponse(EventResponse response){
        txt_response.setText(response.bodytext);

    }

    public void buybook(View view){
        parctiseRXInte.buybook();

    }

    public void getdowninfo(View view){
        parctiseRXInte.downinfo();

    }

}