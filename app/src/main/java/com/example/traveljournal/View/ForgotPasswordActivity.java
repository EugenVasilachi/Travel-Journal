package com.example.traveljournal.View;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.traveljournal.R;

public class ForgotPasswordActivity extends AppCompatActivity {
    private EditText email;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgot_password);

        email = findViewById(R.id.emailAddress);

        getSupportActionBar().hide();
    }

    public void sendEmail(View view) {
        String emailAddress = email.getText().toString();

        if (emailAddress.isEmpty()) {
            email.setError("Please add an email address");

        } else if (!Patterns.EMAIL_ADDRESS.matcher(emailAddress).matches()) {
            email.setError("Wrong format of email address");
        } else {
            Toast.makeText(this,"Email send to Register Email Address",Toast.LENGTH_LONG).show();
        }
    }
}