package com.samtech.dev.alnikah_matchfinder;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.WindowManager;

import com.google.android.material.textfield.TextInputLayout;

public class RegisterActivity extends AppCompatActivity {


    String userName, email, password, confirmPassword, fullName, phoneNo;
    TextInputLayout UserName, Email, Password, ConfirmPassword, FullName, PhoneNo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_register);

        FullName = findViewById(R.id.fullname);
        UserName = findViewById(R.id.username);
        Email = findViewById(R.id.email);
        Password = findViewById(R.id.passwordText);
        ConfirmPassword = findViewById(R.id.ConfirmPasswordText);
        PhoneNo = findViewById(R.id.phonenumber);

    }


    public void OpenLoginActivity(View view) {
        finish();
    }

    Boolean validateFullName() {
        String s = FullName.getEditText().getText().toString();
        if (s.isEmpty()) {
            FullName.setError("Field cannot be empty");
            return false;
        } else {
            FullName.setError(null);
            FullName.setErrorEnabled(false);
            return true;
        }
    }

    Boolean validateUserName() {
        String s = UserName.getEditText().getText().toString();

        if (s.isEmpty()) {
            UserName.setError("Field cannot be empty");
            return false;
        } else if (s.length() >= 15) {
            UserName.setError("Username too long");
            return false;
        } else if (s.contains(" ")) {
            UserName.setError("White spaces are not allowed");
            return false;
        } else if (s.length() < 4) {
            UserName.setError("Minimum 4 characters required");
            return false;
        } else {
            UserName.setError(null);
            UserName.setErrorEnabled(false);
            return true;
        }

    }

    Boolean validateEmail() {
        String s = Email.getEditText().getText().toString();
        String emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";
        if (s.isEmpty()) {
            Email.setError("Field cannot be empty");
            return false;
        } else if (!s.matches(emailPattern)) {
            Email.setError("Invalid email address");
            return false;
        } else {
            Email.setError(null);
            Email.setErrorEnabled(false);
            return true;
        }
    }

    Boolean validatePhone(){
        String s = PhoneNo.getEditText().getText().toString();
        if (s.isEmpty()) {
            PhoneNo.setError("Field cannot be empty");
            return false;
        }
        else {
            PhoneNo.setError(null);
            PhoneNo.setErrorEnabled(false);
            return true;
        }
    }

    Boolean validatePassword(){
        String s= Password.getEditText().getText().toString();
        if (s.isEmpty()) {
            Password.setError("Field cannot be empty");
            return false;
        }
        if(s.length() < 6){
            Password.setError("Minimum 6 characters required");
            return false;
        }
        else {
            Password.setError(null);
            Password.setErrorEnabled(false);
            return true;
        }
    }
    Boolean validateConfirmPassword(){
        String s1= Password.getEditText().getText().toString();
        String s2= ConfirmPassword.getEditText().getText().toString();
        if (s2.isEmpty()) {
            ConfirmPassword.setError("Field cannot be empty");
            return false;
        }

        else if(s1 !=
                 s2){
            ConfirmPassword.setError("Passwords do not match");
            return false;
        }
        else {
            ConfirmPassword.setError(null);
            ConfirmPassword.setErrorEnabled(false);
            return true;
        }
    }

    public void RegisterNewUsr(View view) {
        if(!validateFullName() | !validateUserName() | !validateEmail() |!validatePhone() | !validatePassword() | !validateConfirmPassword())
        {
            return;
        }


    }
}