package com.example.rxpractise;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.example.rxpractise.bean.OkBindingData;
import com.example.rxpractise.common.view.BaseWebActivity;
import com.example.rxpractise.data.model.TB_Key;
import com.example.rxpractise.databinding.ActivityMain2Binding;
import com.example.rxpractise.event.EventResponse;
import com.raizlabs.android.dbflow.sql.language.SQLite;

import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.util.List;

import static android.widget.Toast.LENGTH_LONG;

public class MainActivity extends AppCompatActivity {

    TextView txt_response;
    public ParctiseRXInte parctiseRXInte = new ParctiseRXInte();

    ActivityMain2Binding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = DataBindingUtil.setContentView(this,R.layout.activity_main2);

        OkBindingData bindingData = new OkBindingData();
        bindingData.setCurray("LHNH");
        bindingData.setName("onyx___________________________Jay");
        bindingData.setCurray("10000000");

        binding.setOpt(bindingData);
        binding.setEventListener(new DataEventListener());

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

    public class DataEventListener{

        public void onClick(OkBindingData okBindingData) {
            Toast.makeText(MainActivity.this,"Data Click!  "+ okBindingData.getName(), LENGTH_LONG).show();
            MainActivity.this.startActivity(new Intent(MainActivity.this, BaseWebActivity.class));
        }

        public void onLauncher(OkBindingData okBindingData) {
            Toast.makeText(MainActivity.this,"Launcher Event!", LENGTH_LONG).show();
        }
    }
}