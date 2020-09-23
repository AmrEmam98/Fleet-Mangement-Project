package com.example.fleetmanagementsystem;

import android.widget.EditText;

public class InputValidation {


    public static boolean validatePhoneNumber(EditText et) {
        if( et.getText().toString().length()==11)
            return true;
        else {
            et.setError("Phone Number must be consist of 11 digit");
            return false;
        }
    }
    public static boolean validateEmptyString(EditText et) {
        if( et.getText().toString().isEmpty()){
            et.setError("Field cannot be empty");
            return false;
        }
        return true;
    }


    public static boolean emailValidation(EditText et_email) {
        String emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";
        String email = et_email.getText().toString();
        if( email.matches(emailPattern) && email.length() > 0)
            return true;
        else {
            et_email.setError("Invalid email");
            return false;
        }
    }

    public static boolean validatePassword(EditText et_password) {
        if( et_password.getText().toString().length() >= 6)
            return true;
        else{
            et_password.setError("Password must be at least 6 character");
            return false;
        }
    }

}
