package com.example.traveljournal.View;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.traveljournal.Model.Profile;
import com.example.traveljournal.R;

public class ResetPasswordActivity extends AppCompatActivity {
    private EditText editPassword, editPasswordConfirm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reset_password);
        editPassword = findViewById(R.id.newpassword);
        editPasswordConfirm = findViewById(R.id.newpasswordconfirm);
        Toast.makeText(this, "Email verified!", Toast.LENGTH_SHORT).show();
        getSupportActionBar().hide();
    }

    public void resetOnClick(View view) {
        String password = editPassword.getText().toString();
        String passwordConfirm = editPasswordConfirm.getText().toString();
        boolean verify = true;

        if(!UiValidator.validateInputPassword(password, editPassword))
            verify = false;

        if(!UiValidator.validateInputPasswordConfirm(passwordConfirm, editPasswordConfirm))
            verify = false;

        if(!UiValidator.validatePasswordsEquals(password, passwordConfirm, editPasswordConfirm))
            verify = false;

        if(verify)
        {
            // extragem email ul contului din ForgotPasswordActivity.java
            // obtinem si editam parola respectivului profil din baza de date(dupa email)

            // ne intoarcem in LoginActivity
            Toast.makeText(this, "Your password has been changed successfully!", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(ResetPasswordActivity.this, LoginActivity.class);
            startActivity(intent);
        }
    }
}