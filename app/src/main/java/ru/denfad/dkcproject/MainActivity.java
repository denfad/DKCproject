package ru.denfad.dkcproject;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.CalendarView;
import android.widget.TextView;
import android.widget.Toast;

import java.time.Month;
import java.time.format.TextStyle;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

import sun.bob.mcalendarview.MCalendarView;
import sun.bob.mcalendarview.MarkStyle;
import sun.bob.mcalendarview.listeners.OnDateClickListener;
import sun.bob.mcalendarview.listeners.OnMonthChangeListener;
import sun.bob.mcalendarview.views.BaseMarkView;
import sun.bob.mcalendarview.vo.DateData;

public class MainActivity extends AppCompatActivity {

    String[] monthes = {"Январь", "Февраль", "Март", "Апрель","Май","Июнь","Июль","Август","Сентябрь", "Октябрь", "Ноябрь", "Декабрь"};
    MCalendarView calendarView;
    int work=2;
    int week=2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        Intent intent = getIntent();
        work = intent.getIntExtra("work", 2);
         week = intent.getIntExtra("week", 2);
        calendarView = findViewById(R.id.calendar);
        calendarView.setMarkedStyle(MarkStyle.BACKGROUND, Color.RED);

        redraw(work,week,Calendar.getInstance().get(Calendar.MONTH)+1,Calendar.getInstance().get(Calendar.YEAR));



        final TextView monthYear = findViewById(R.id.month_year);





        calendarView.setOnMonthChangeListener(new OnMonthChangeListener() {

            @Override
            public void onMonthChange(int year, int month) {
                monthYear.setText(year + "\n"+monthes[month-1]);
                redraw(work,week,month,year);
            }
        });

        calendarView.setOnDateClickListener(new OnDateClickListener() {
            @Override
            public void onDateClick(View view, DateData date) {
                Toast.makeText(MainActivity.this, String.format("%d-%d", date.getMonth(), date.getDay()), Toast.LENGTH_SHORT).show();
            }
        });

        calendarView.hasTitle(false);

    }

    private void redraw(int work, int week, int month,  int year){
        for(int i = 0; i<32; i=i+work+week){
            for(int j=1; j<=work; j++){
                calendarView.markDate(new DateData(year, month, j+i));
            }
            for(int k=1; k<=week; k++){
                calendarView.markDate(new DateData(year, month, work+i+k).setMarkStyle(new MarkStyle(MarkStyle.DOT, Color.GREEN)));
            }
        }
    }
}