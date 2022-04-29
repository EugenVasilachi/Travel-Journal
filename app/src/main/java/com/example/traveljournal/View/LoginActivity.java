package com.example.traveljournal.View;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.EditText;

import com.example.traveljournal.R;
import com.example.traveljournal.View.UiValidator;

public class LoginActivity extends AppCompatActivity {
    private EditText editTextEmail, editTextPassword;
    private static final String TAG_ACTIVITY = "FirstActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        editTextEmail = findViewById(R.id.email);
        editTextPassword = findViewById(R.id.password);

        getSupportActionBar().hide();
    }

    public void loginOnClick(View view) {
        String email = editTextEmail.getText().toString();
        String password = editTextPassword.getText().toString();
        boolean verify = true;
        if(!UiValidator.validateEmailInput(email, editTextEmail))
            verify = false;

        if(!UiValidator.validateInputPassword(password, editTextPassword))
            verify = false;

        if (verify)
        {
            // cautam profilul in baza de date dupa email
            // daca il gasim, verificam parola introdusa (corespunzatoare unicului email)
            // daca parola este corecta, trecem la urmatoarea activitate (cu datele contului respectiv)

            // mai jos presupun ca totul a fost bine
            Intent intent = new Intent(LoginActivity.this, DrawerActivity.class);
            startActivity(intent);
        }
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