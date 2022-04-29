package com.example.traveljournal.View;

import android.util.Patterns;
import android.widget.EditText;

public class UiValidator {
   public static boolean validateEmailInput(String email, EditText editTextEmail)
   {
       if (email.isEmpty()) {
           editTextEmail.setError("Please add an email address");
           return false;
       }

        else if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
           editTextEmail.setError("Wrong format of email address");
           return false;
       }
        return true;
   }
   public static boolean validateNameInput(String nameString, EditText name )
   {
       if(nameString.isEmpty()) {
           name.setError("Please add a name");
           return false;
       }
       return true;
   }

   public static boolean validateInputPassword(String password,
                                             EditText EditTextPassword)
   {
       if(password.isEmpty()) {
           EditTextPassword.setError("Please add a password");
           return false;
       }
       return true;
   }

    public static boolean validateInputPasswordConfirm(String password,
                                             EditText EditTextPassword)
    {
        if(password.isEmpty()) {
            EditTextPassword.setError("Please add a password");
            return false;
        }
        return true;
    }

   public static boolean validatePasswordsEquals(String password, String passwordConfirm,
                                              EditText editTextPasswordConfirm)
   {
       if(!password.equals(passwordConfirm)) {
           editTextPasswordConfirm.setError("Passwords do not match. Try again.");
           return false;
       }
       return true;

   }
}
