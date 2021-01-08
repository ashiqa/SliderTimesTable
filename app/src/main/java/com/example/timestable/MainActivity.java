package com.example.timestable;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SeekBar;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ListView timesTableListView;
    public void generateTimesTable(int times){
        ArrayList<String> multTable= new ArrayList<String>();
        for(int i=1 ; i<=10;++i){
            multTable.add(Integer.toString(i*times));
        }
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,multTable);
        timesTableListView.setAdapter(arrayAdapter);
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        timesTableListView = (ListView) findViewById(R.id.timesTableListView);
        SeekBar timesTableSeekBar = (SeekBar) findViewById(R.id.timesTableSeekBar);
        timesTableSeekBar.setMax(20);
        timesTableSeekBar.setProgress(10);
        timesTableSeekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                int min=1 ;
                int timesTable;
                if(progress<min){
                    timesTable=min ;
                    timesTableSeekBar.setProgress(min);
                }else{
                    timesTable=progress ;
                }
                Log.i("seekbar value : ",Integer.toString(timesTable));
                generateTimesTable(timesTable);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
        generateTimesTable(10);
    }
}