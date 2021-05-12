package com.example.contohapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
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
    private TextView datetime_show;

    private Intent prevIntent;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_datetime);
        prevIntent = getIntent();

        calendar = (CalendarView) findViewById(R.id.datetime_calendar);

        time = (TimePicker) findViewById(R.id.datetime_time);
        time.setIs24HourView(true);
        time.setCurrentHour(Calendar.getInstance().get(Calendar.HOUR_OF_DAY));

        datetime_text = (TextView) findViewById(R.id.datetime_text);

        c = Calendar.getInstance();

        datetime_show = (TextView) findViewById(R.id.CreateOrder_dateTimeShow);

        calendar.setOnDateChangeListener((calendar, i, i1, i2) -> {
            day = i1+1;
            month= i2;
            year=i;

//            String date = (i1+1) + "/" + i2 + "/" + i;

        });

        hour = c.get(Calendar.HOUR_OF_DAY);
        minute = c.get(Calendar.MINUTE);

        //show ke layar
        showDateTime(year, month, day, hour, minute);

    }

//    private void getDateTimeCalendar(){
//        Calendar calendar = Calendar.getInstance();
//        day = calendar.get(Calendar.DAY_OF_MONTH);
//        month = calendar.get(Calendar.MONTH);
//        year = calendar.get(Calendar.YEAR);
//        hour = calendar.get(Calendar.HOUR_OF_DAY);
//        minute = calendar.get(Calendar.MINUTE);
//
//    }

    public void showDateTime(int year, int month, int day, int hour, int minute){
        String mname = "";
        switch(month){
            case 1:
                mname = "January";
                break;
            case 2:
                mname = "February";
                break;
            case 3:
                mname = "March";
                break;
            case 4:
                mname = "April";
                break;
            case 5:
                mname = "May";
                break;
            case 6:
                mname = "June";
                break;
            case 7:
                mname = "July";
                break;
            case 8:
                mname = "August";
                break;
            case 9:
                mname = "September";
                break;
            case 10:
                mname = "October";
                break;
            case 11:
                mname = "November";
                break;
            case 12:
                mname = "December";
                break;
            default:
                mname = "";
        }
        String s = "";
        s = String.format("%i %s %i %i:%i", day, mname, year, hour, minute);
        datetime_text.setText(s);
    }

    public void setDatetime(View view) {
        Intent intent = new Intent(this, CreateOrder.class);
        intent.putExtras(this.prevIntent);
//        intent.putExtra(DATE_TIME, this.dtime);
        startActivity(intent);
    }



}
