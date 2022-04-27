package com.example.traveljournal.View;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.traveljournal.R;

public class CreateAccountActivity extends AppCompatActivity {
    EditText password, passwordConfirm, email, name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_account);

        password = findViewById(R.id.passwordRegister);
        passwordConfirm = findViewById(R.id.passwordRegisterConfirmation);
        email = findViewById(R.id.emailRegister);
        name = findViewById(R.id.nameRegister);

        getSupportActionBar().hide();

    }

    public void createAccount(View view) {

        String passwordString = password.getText().toString();
        String passwordConfirmString = passwordConfirm.getText().toString();
        String emailString = email.getText().toString();
        String nameString = name.getText().toString();

        if(nameString.isEmpty()) {
            name.setError("Please add a name");
        } else if (emailString.isEmpty()) {
            email.setError("Please add an email address");
        } else if (!Patterns.EMAIL_ADDRESS.matcher(emailString).matches()) {
            email.setError("Wrong format of email address");
        } else if(!passwordString.equals(passwordConfirmString) || passwordString.isEmpty()) {
            passwordConfirm.setError("Passwords do not match. Try again.");
        } else {
            Toast.makeText(this,"Hello from Create an Account Activity!",Toast.LENGTH_SHORT).show();
        }
    }

    public void alreadyHaveAnAccount(View view) {
        Intent intent = new Intent(CreateAccountActivity.this, LoginActivity.class);
        startActivity(intent);
    }
}