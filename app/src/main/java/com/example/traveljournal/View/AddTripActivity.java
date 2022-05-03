package com.example.traveljournal.View;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.TimePicker;

import com.example.traveljournal.R;

import com.example.traveljournal.Controller.Controller;
import com.google.android.material.slider.LabelFormatter;
import com.google.android.material.slider.RangeSlider;

import java.text.NumberFormat;
import java.util.Calendar;
import java.util.Currency;
import java.util.Objects;

public class AddTripActivity extends AppCompatActivity {
    private EditText editTextName, editTextDestination, editTextPrice;
    private TextView textViewDate, textViewTime, textViewDate2, textViewTime2;
    int year, month, day, hour, minute;
    RangeSlider rangeSlider;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_trip);
        Objects.requireNonNull(getSupportActionBar()).hide();
        textViewDate = findViewById(R.id.textviewDate);
        textViewTime = findViewById(R.id.textviewTime);
        textViewDate2 = findViewById(R.id.textviewEndDate);
        textViewTime2 = findViewById(R.id.textviewEndTime);

        rangeSlider = findViewById(R.id.slider);

        rangeSlider.setLabelFormatter(new LabelFormatter() {
            @NonNull
            @Override
            public String getFormattedValue(float value) {
                NumberFormat format = NumberFormat.getCurrencyInstance();
                format.setCurrency(Currency.getInstance("EUR"));
                return format.format(value);
            }
        });

        Calendar calendar = Calendar.getInstance();
        year = calendar.get(Calendar.YEAR);
        month = calendar.get(Calendar.MONTH);
        day = calendar.get(Calendar.DAY_OF_MONTH);
        hour = calendar.get(Calendar.HOUR_OF_DAY);
        minute = calendar.get(Calendar.MINUTE);
    }

    public void addTrip(View view) {
        Controller controller = new Controller();
        String name = editTextName.getText().toString();
        String destination = editTextDestination.getText().toString();
        String priceString = editTextPrice.getText().toString();
        float price = Float.parseFloat(priceString);
        //controller.addTrip(name, destination, price);
    }

    public void openDatePickerOnClick(View view) {
        DatePickerDialog datePickerDialog = new DatePickerDialog(AddTripActivity.this, new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int selectedYear, int selectedMonth, int selectedDay) {
                textViewDate.setText(String.format("%d-%d-%d", selectedDay, selectedMonth + 1, selectedYear));
            }
        }, year, month, day);
        datePickerDialog.show();
    }

    public void openTimePickerOnClick(View view) {
        TimePickerDialog timePickerDialog = new TimePickerDialog(AddTripActivity.this, new TimePickerDialog.OnTimeSetListener() {
            @Override
            public void onTimeSet(TimePicker timePicker, int selectedHour, int selectedMinute) {
                textViewTime.setText(String.format("%d:%d", selectedHour, selectedMinute));
            }
        }, hour, minute, true);
        timePickerDialog.show();
    }

    public void openEndDatePickerOnClick(View view) {
        DatePickerDialog datePickerDialog = new DatePickerDialog(AddTripActivity.this, new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int selectedYear, int selectedMonth, int selectedDay) {
                textViewDate2.setText(String.format("%d-%d-%d", selectedDay, selectedMonth + 1, selectedYear));
            }
        }, year, month, day);
        datePickerDialog.show();
    }

    public void openEndTimePickerOnClick(View view) {
        TimePickerDialog timePickerDialog = new TimePickerDialog(AddTripActivity.this, new TimePickerDialog.OnTimeSetListener() {
            @Override
            public void onTimeSet(TimePicker timePicker, int selectedHour, int selectedMinute) {
                textViewTime2.setText(String.format("%d:%d", selectedHour, selectedMinute));
            }
        }, hour, minute, true);
        timePickerDialog.show();
    }
}