package com.example.contohapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.CalendarView;
import android.widget.TextView;
import android.widget.TimePicker;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import java.util.Calendar;


public class DateTime extends AppCompatActivity{
    public static final String DATE_TIME = "com.example.contohapp.dtime";

    protected Integer day = 0;
    protected Integer month = 0;
    protected Integer year = 0;
    protected Integer hour = 0;
    protected Integer minute = 0;

    protected Integer savedDay = 0;
    protected Integer savedMonth = 0;
    protected Integer savedYear = 0;
    protected Integer savedHour = 0;
    protected Integer savedMinute = 0;

    private TextView datetime_text;


    private CalendarView calendar;
    private TimePicker time;

    private Intent prevIntent;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_datetime);
        prevIntent = getIntent();

        calendar = (CalendarView) findViewById(R.id.datetime_calendar);
        time = (TimePicker) findViewById(R.id.datetime_time);
        datetime_text = (TextView) findViewById(R.id.datetime_text);

        calendar.setOnDateChangeListener((calendar, i, i1, i2) -> {
            day = i1+1;
            month= i2;
            year=i;

//            String date = (i1+1) + "/" + i2 + "/" + i;

        });

        //time picker?


    }

    private void getDateTimeCalendar(){
        Calendar calendar = Calendar.getInstance();
        day = calendar.get(Calendar.DAY_OF_MONTH);
        month = calendar.get(Calendar.MONTH);
        year = calendar.get(Calendar.YEAR);
        hour = calendar.get(Calendar.HOUR);
        minute = calendar.get(Calendar.MINUTE);


    }

    public void setDatetime(View view) {
        Intent intent = new Intent(this, CreateOrder.class);
        intent.putExtras(this.prevIntent);
//        intent.putExtra(DATE_TIME, this.dtime);
        startActivity(intent);
    }



}
