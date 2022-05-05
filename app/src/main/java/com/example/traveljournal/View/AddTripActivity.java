package com.example.traveljournal.View;
import androidx.appcompat.app.AppCompatActivity;
import android.annotation.SuppressLint;
import android.app.DatePickerDialog;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RatingBar;
import android.widget.TextView;
import com.example.traveljournal.Model.Profile;
import com.example.traveljournal.Model.Trip;
import com.example.traveljournal.R;
import com.example.traveljournal.Controller.Controller;
import com.example.traveljournal.View.ui.home.HomeFragment;
import com.google.android.material.slider.RangeSlider;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Currency;
import java.util.List;
import java.util.Objects;

public class AddTripActivity extends AppCompatActivity {
    private EditText editTextName, editTextDestination;
    private TextView textViewDate, textViewDate2;
    private RadioButton button1, button2, button3;
    private RatingBar ratingBar;
    int year, month, day, hour, minute;
    RangeSlider rangeSlider;
    Profile profile;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_trip);
        Objects.requireNonNull(getSupportActionBar()).hide();
        editTextName = findViewById(R.id.nametrip);
        editTextDestination = findViewById(R.id.destination);
        textViewDate = findViewById(R.id.textviewDate);
        textViewDate2 = findViewById(R.id.textviewEndDate);
        button1 = findViewById(R.id.buton1);
        button2 = findViewById(R.id.buton2);
        button3 = findViewById(R.id.button3);
        rangeSlider = findViewById(R.id.slider);
        ratingBar = findViewById(R.id.ratingBar);

        Bundle extras = getIntent().getExtras();
        profile = (Profile) extras.getSerializable("profil");

        rangeSlider.setLabelFormatter(value -> {
            NumberFormat format = NumberFormat.getCurrencyInstance();
            format.setCurrency(Currency.getInstance("EUR"));
            return format.format(value);
        });

        Calendar calendar = Calendar.getInstance();
        year = calendar.get(Calendar.YEAR);
        month = calendar.get(Calendar.MONTH);
        day = calendar.get(Calendar.DAY_OF_MONTH);
        hour = calendar.get(Calendar.HOUR_OF_DAY);
        minute = calendar.get(Calendar.MINUTE);
    }

    public void addTrip(View view) {
        Controller controller = new Controller(profile);
        String name = editTextName.getText().toString();

        String destination = editTextDestination.getText().toString();

        String tripType = "";
        if(button1.isChecked())
            tripType = button1.getText().toString();
        if(button2.isChecked())
            tripType = button2.getText().toString();
        if(button3.isChecked())
            tripType = button3.getText().toString();

        String startDate = textViewDate.getText().toString();
        String endDate = textViewDate2.getText().toString();
        int price = 200; // trebuie sa o luam din activity_add_trip.xml
        float rate = ratingBar.getRating();
        @SuppressLint("UseCompatLoadingForDrawables") Drawable image = getResources().getDrawable(R.drawable.newyork2); // trebuie sa  o luam din activity_add_trip.xml
        controller.addTrip(name, destination, tripType, price, startDate, endDate, rate, image);
        //Trip trip = new Trip(name, destination, tripType, price, startDate, endDate, rate, image);
    }

    public void openDatePickerOnClick(View view) {
        @SuppressLint("DefaultLocale") DatePickerDialog datePickerDialog =
                new DatePickerDialog(AddTripActivity.this,
                        (datePicker, selectedYear, selectedMonth, selectedDay)
                                -> textViewDate.setText(String.format("%d-%d-%d", selectedDay, selectedMonth + 1,
                                selectedYear)), year, month, day);
        datePickerDialog.show();
    }

    public void openEndDatePickerOnClick(View view) {
        @SuppressLint("DefaultLocale") DatePickerDialog datePickerDialog =
                new DatePickerDialog(AddTripActivity.this, (datePicker,
                                                            selectedYear, selectedMonth, selectedDay)
                        -> textViewDate2.setText(String.format("%d-%d-%d", selectedDay, selectedMonth + 1,
                        selectedYear)), year, month, day);
        datePickerDialog.show();
    }
}