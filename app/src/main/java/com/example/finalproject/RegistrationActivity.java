package com.example.finalproject;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.airbnb.lottie.LottieAnimationView;
import com.google.android.material.textfield.TextInputEditText;

import java.util.Date;
import java.util.regex.Pattern;

public class RegistrationActivity extends AppCompatActivity {
    public static SaveDataProfile saveDataProfile;
    private static  Pattern PASSWORD_PATTERN = null;
    private static Pattern NAME_PATTERN = null;
    TextInputEditText e1;
    TextInputEditText e2;
    TextInputEditText firstInput;
    LottieAnimationView lottie;
    Button buttonForRegistration;
    DBHelper DB;
    public static SharedPreferences sharedPreferences;
    String fullname;
    String user;
    String pass;
    Date date;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);
        NAME_PATTERN = Pattern.compile("^" + ".{6,}");
        PASSWORD_PATTERN= Pattern.compile("^" +
                //"(?=.*[0-9])" +         //at least 1 digit
                //"(?=.*[a-z])" +         //at least 1 lower case letter
                //"(?=.*[A-Z])" +         //at least 1 upper case letter
                "(?=.*[a-zA-Z])" +      //any letter
                "(?=.*[@#$%^&+=])" +    //at least 1 special character
                "(?=\\S+$)" +           //no white spaces
                ".{6,}" +               //at least 4 characters
                "$");
        DB = new DBHelper(this);
        firstInput = (TextInputEditText) findViewById(R.id.firstInput);
        e1 = (TextInputEditText)findViewById(R.id.secondInput);
        e2 = (TextInputEditText)findViewById(R.id.thirdInput);
        buttonForRegistration = (Button)findViewById(R.id.buttonforRegistration);
        lottie = (LottieAnimationView)findViewById(R.id.lottiefirst);

        lottie.animate();

        sharedPreferences = getSharedPreferences("MyUserPrefs", Context.MODE_PRIVATE);
        buttonForRegistration.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                user = firstInput.getText().toString();
                pass = e2.getText().toString();
                fullname = e1.getText().toString();
                String dateOfEntering;

                if (validateEmail() && validatePassword() && validateName()) {
                    if (user.equals("") || pass.equals("")) {
                        Toast.makeText(RegistrationActivity.this, "Please enter the text", Toast.LENGTH_SHORT).show();
                    } else {
                        //implement DB before using it
                        Boolean checkuser = DB.checkusername(user);
                        date = java.util.Calendar.getInstance().getTime();

                        if (checkuser == false) {
                            dateOfEntering = date.toString();
                            Boolean insert = DB.insertData(user, pass);
                            if (insert == true) {
                                Toast.makeText(RegistrationActivity.this, "Registered successfully", Toast.LENGTH_SHORT);
                                SharedPreferences.Editor editor = sharedPreferences.edit();
                                editor.putString("user", user);
                                editor.putString("pass", pass);
                                editor.putString("fullname", fullname);
                                editor.putString("date", date.toString());
                                editor.commit();
//
                                Intent intents = new Intent(RegistrationActivity.this, success.class);
                                startActivity(intents);
                            } else {
                                Toast.makeText(RegistrationActivity.this, "Registration failed", Toast.LENGTH_SHORT);
                            }
                        } else {
                            Toast.makeText(RegistrationActivity.this, "User exists!", Toast.LENGTH_SHORT);
                        }
                    }
                }
            }
        });

    }

        public static SaveDataProfile getSave() {
                return saveDataProfile;
        }
        private boolean validateEmail()
        {
            String emailInput = firstInput.getText().toString().trim();

            if (emailInput.isEmpty()) {
                String emptyEmailError = "Email can't be empty";
                firstInput.setError(emptyEmailError);
                Toast.makeText(RegistrationActivity.this, emptyEmailError, Toast.LENGTH_SHORT).show();
                return false;
            } else if (!Patterns.EMAIL_ADDRESS.matcher(emailInput).matches()) {
                String validEmail = "Enter a valid email address";
                firstInput.setError(validEmail);
                Toast.makeText(RegistrationActivity.this, validEmail, Toast.LENGTH_SHORT).show();
                return false;
            } else {
                firstInput.setError(null);
                return true;
            }
        }
        private boolean validateName() {
            String nameInput = e1.getText().toString().trim();

            if (nameInput.isEmpty()) {
                String nameInputError = "Name can't be empty";
                e1.setError(nameInputError);
                Toast.makeText(RegistrationActivity.this, nameInputError, Toast.LENGTH_SHORT).show();
                return false;
            } else if (!NAME_PATTERN.matcher(nameInput).matches()) {
                String nameWarning = "Name is too weak";
                e1.setError(nameWarning);
                Toast.makeText(RegistrationActivity.this, nameWarning, Toast.LENGTH_SHORT).show();
                return false;
            } else {
                e1.setError(null);
                return true;
            }
        }
    private boolean validatePassword()
    {
        String passwordInput = e2.getText().toString().trim();

        if (passwordInput.isEmpty()) {
            String emptyError = "Field can't be empty";
            e2.setError(emptyError);
            Toast.makeText(RegistrationActivity.this, emptyError, Toast.LENGTH_SHORT).show();
            return false;
        } else if (!PASSWORD_PATTERN.matcher(passwordInput).matches()) {
            String warning = "Password is too weak";
            e2.setError(warning);
            Toast.makeText(RegistrationActivity.this, warning, Toast.LENGTH_SHORT).show();
            return false;
        } else {
            e2.setError(null);
            return true;
        }
    }

}















