package com.example.traveljournal.View;

import androidx.appcompat.app.AppCompatActivity;


import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.traveljournal.Model.Profile;
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
        if (UiValidator.validateEmailInput(emailAddress, email)) {
            // cautam in baza de date acest profil (dupa email)
            Toast.makeText(this, "Please check your email inbox!", Toast.LENGTH_LONG).show();
            // daca exista profilul, validam ca utilizatorul are acces la acest email
            Intent intent = new Intent(ForgotPasswordActivity.this, ResetPasswordActivity.class);
            startActivity(intent);
        }
    }
}
