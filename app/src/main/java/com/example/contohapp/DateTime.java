package com.example.contohapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.TextView;
import android.widget.TimePicker;
import java.time.*;
import java.time.Month;
import java.time.temporal.ChronoField;

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
    private String datetime_string;

    private CalendarView calendar;
    private TimePicker time;
    private Calendar c;
//    private TextView datetime_show;

    private Intent prevIntent;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_datetime);
        prevIntent = getIntent();

        calendar = (CalendarView) findViewById(R.id.datetime_calendar);
        calendar.setDate(Calendar.getInstance().getTimeInMillis(),false,true);
        calendar.setMinDate(System.currentTimeMillis());

        time = (TimePicker) findViewById(R.id.datetime_time);
        time.setIs24HourView(true);
        time.setCurrentHour(Calendar.getInstance().get(Calendar.HOUR_OF_DAY));

        datetime_text = (TextView) findViewById(R.id.datetime_text);

        c = Calendar.getInstance();

//        datetime_show = (TextView) findViewById(R.id.CreateOrder_dateTimeShow);

        calendar.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(@NonNull CalendarView view, int year, int month, int dayOfMonth) {
                showDateTime(year, month, dayOfMonth, hour, minute);
            }
        });

        time.setOnTimeChangedListener(new TimePicker.OnTimeChangedListener() {
            @Override
            public void onTimeChanged(TimePicker view, int hourOfDay, int minute) {
                showDateTime(year, month, day, hourOfDay, minute);
            }
        });

        year = c.get(Calendar.YEAR);
        month = c.get(Calendar.MONTH);
        day = c.get(Calendar.DAY_OF_MONTH);
        hour = c.get(Calendar.HOUR_OF_DAY);
        minute = c.get(Calendar.MINUTE);

        //show ke layar
        showDateTime(year, month, day, hour, minute);

        Button setButton = (Button) findViewById(R.id.datetime_setbutton);
        setButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v)
            {
//                Intent intent = new Intent(view.getContext(), DateTime.class);
                Intent intent = new Intent(DateTime.this, CreateOrder.class);
                intent.putExtras(prevIntent);
                intent.putExtra(CreateOrder.DATE_TIME, datetime_string);
                startActivity(intent);
            }
        });

    }


    public void showDateTime(int year, int month, int day, int hour, int minute){
        String mname = "";
        switch(month){
            case 0:
                mname = "January";
                break;
            case 1:
                mname = "February";
                break;
            case 2:
                mname = "March";
                break;
            case 3:
                mname = "April";
                break;
            case 4:
                mname = "May";
                break;
            case 5:
                mname = "June";
                break;
            case 6:
                mname = "July";
                break;
            case 7:
                mname = "August";
                break;
            case 8:
                mname = "September";
                break;
            case 9:
                mname = "October";
                break;
            case 10:
                mname = "November";
                break;
            case 11:
                mname = "December";
                break;
            default:
                mname = "";
        }
        String s = "";
        this.year = year;
        this.month = month;
        this.day = day;
        this.hour = hour;
        this.minute = minute;

        if (hour < 10){
            if (minute < 10){
                s = String.format("%d %s %d 0%d:0%d", day, mname, year, hour, minute);
            } else{
                s = String.format("%d %s %d 0%d:%d", day, mname, year, hour, minute);
            }
        } else {
            if (minute < 10) {
                s = String.format("%d %s %d %d:0%d", day, mname, year, hour, minute);
            } else {
                s = String.format("%d %s %d %d:%d", day, mname, year, hour, minute);
            }
        }
        datetime_text.setText(s);
        datetime_string = s;
    }

//    public void setDatetime(View view) {
//        Intent intent = new Intent(this, CreateOrder.class);
//        intent.putExtras(this.prevIntent);
////        intent.putExtra(DATE_TIME, datetime_string);
//        startActivity(intent);
//    }



}
