package com.example.rxpractise;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.rxpractise.data.model.TB_Key;
import com.example.rxpractise.event.EventResponse;
import com.raizlabs.android.dbflow.config.FlowLog;
import com.raizlabs.android.dbflow.config.FlowManager;
import com.raizlabs.android.dbflow.sql.language.SQLite;

import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.util.List;

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
//        saveKey ();
        select();

    }

    public void saveKey (){

        TB_Key key = new TB_Key();
        key.book_id = 1000;
        key.key = "sdafdagdfsgdfsgsdf";
        key.save();
    }

    public void select(){
        List<TB_Key> list = SQLite.select().from(TB_Key.class).queryList();

    }


    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onResponse(EventResponse response) {
        txt_response.setText(response.bodytext);

    }

    public void buybook(View view) {
        parctiseRXInte.buybook();
    }

    public void getdowninfo(View view) {
        parctiseRXInte.downinfo();
    }


    public void addToCar(View view){
        parctiseRXInte.addToCar();
    }

    public void getCar(View view){
        parctiseRXInte.getCar();
    }

    public void deleteCar(View view){
        parctiseRXInte.clearCar();
    }

    public void delectBook(View view){
        parctiseRXInte.removeBook();
    }

}