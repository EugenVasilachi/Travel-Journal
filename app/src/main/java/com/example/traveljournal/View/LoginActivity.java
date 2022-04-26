package com.example.traveljournal.View;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.EditText;

import com.example.traveljournal.R;

public class LoginActivity extends AppCompatActivity {
    private EditText editTextEmail, editTextPassword;
    private static final String TAG_ACTIVITY = "FirstActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        //editTextEmail = findViewById(R.id.editTextEmail);
        //editTextPassword = findViewById(R.id.editTextPassword);
        editTextEmail = findViewById(R.id.username);
        editTextPassword = findViewById(R.id.password);

        getSupportActionBar().hide();
    }

    public void loginOnClick(View view) {
        String email = editTextEmail.getText().toString();
        String password = editTextPassword.getText().toString();

        checkEmail(email, editTextEmail);

        if(password.isEmpty()){
            editTextPassword.setError("Please add a password");
        }
    }

    public static void checkEmail(String email, EditText editTextEmail) {
        if (email.isEmpty()) {
            editTextEmail.setError("Please add an email address");

        } else if (!Patterns.EMAIL_ADDRESS.matcher(email).matches())
            editTextEmail.setError("Wrong format of email address");
    }

    public void createAnAccount(View view) {
        Intent intent = new Intent(LoginActivity.this, CreateAccountActivity.class);
        startActivity(intent);
    }

    public void forgotPassword(View view) {
        Intent intent = new Intent(LoginActivity.this, ForgotPasswordActivity.class);
        startActivity(intent);
    }
}