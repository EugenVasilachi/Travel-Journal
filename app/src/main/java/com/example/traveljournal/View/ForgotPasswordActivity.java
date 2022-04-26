package com.example.traveljournal.View;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.example.traveljournal.R;

public class ForgotPasswordActivity extends AppCompatActivity {
    private EditText editTextEmail, editTextCode;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgot_password);

        editTextEmail = findViewById(R.id.verifyEmail);
        editTextCode = findViewById(R.id.verifyCode);
    }

    public void searchEmail(View view) {
        String email = editTextEmail.getText().toString();
        LoginActivity.checkEmail(email, editTextEmail);
    }

    public void verifyCode(View view) {
        String code = editTextCode.getText().toString();
        if(code.isEmpty()){
            editTextCode.setError("Please add a code");
        }
    }
}