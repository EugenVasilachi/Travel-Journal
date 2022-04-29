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

import java.util.Objects;

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

        Objects.requireNonNull(getSupportActionBar()).hide();

    }

    public void createAccount(View view) {

        String passwordString = password.getText().toString();
        String passwordConfirmString = passwordConfirm.getText().toString();
        String emailString = email.getText().toString();
        String nameString = name.getText().toString();

        boolean verify = true;

        if (!UiValidator.validateNameInput(nameString, name))
            verify = false;
        if (!UiValidator.validateEmailInput(emailString, email))
            verify = false;

        if (!UiValidator.validateInputPassword(passwordString, password))
            verify = false;

        if (!UiValidator.validateInputPasswordConfirm(passwordConfirmString, passwordConfirm))
            verify = false;

        if (!UiValidator.validatePasswordsEquals(passwordString, passwordConfirmString, passwordConfirm))
            verify = false;
        if(verify)
        {
            // validam unicitatea contului
            // salvam contul in baza de date
            // daca este unic, trecem la urmatoare activitate (cu datele contului respectiv)
            Toast.makeText(this, "Your account has been successfully created!", Toast.LENGTH_SHORT).show();

            // mai jos presupun ca totul a fost bine
            Intent intent = new Intent(CreateAccountActivity.this, DrawerActivity.class);
            startActivity(intent);
        }
    }


    public void alreadyHaveAnAccount(View view) {
        Intent intent = new Intent(CreateAccountActivity.this, LoginActivity.class);
        startActivity(intent);
    }
}