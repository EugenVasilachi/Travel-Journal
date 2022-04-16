package View;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.example.traveljournal.R;

import Controller.Controller;

public class AddTripActivity extends AppCompatActivity {
    private EditText editTextName, editTextDestination, editTextPrice;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_trip);

        editTextName = findViewById(R.id.tripName);
        editTextDestination = findViewById(R.id.tripDestination);
        editTextPrice = findViewById(R.id.tripPrice);

    }

    public void addTrip(View view) {
        Controller controller = new Controller();
        String name = editTextName.getText().toString();
        String destination = editTextDestination.getText().toString();
        String priceString = editTextPrice.getText().toString();
        float price = Float.parseFloat(priceString);
        controller.addTrip(name, destination, price);
    }
}