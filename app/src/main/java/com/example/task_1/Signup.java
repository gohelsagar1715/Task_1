package com.example.task_1;

import android.os.Bundle;
import android.util.Patterns;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class Signup extends AppCompatActivity {


    EditText edtName, edtEmail, edtMobile;
    EditText edtPassword, edtConfirmPassword;

    Button btnSignup;
    TextView txtLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        edtName = findViewById(R.id.edtName);
        edtEmail = findViewById(R.id.edtEmail);
        edtMobile = findViewById(R.id.edtMobile);
        edtPassword = findViewById(R.id.edtPassword);
        edtConfirmPassword = findViewById(R.id.edtConfirmPassword);

        btnSignup = findViewById(R.id.btnSignup);
        txtLogin = findViewById(R.id.txtLogin);

        btnSignup.setOnClickListener(v -> {

            String name = edtName.getText().toString().trim();
            String email = edtEmail.getText().toString().trim();
            String mobile = edtMobile.getText().toString().trim();
            String password = edtPassword.getText().toString();
            String confirmPassword =
                    edtConfirmPassword.getText().toString();

            if (name.isEmpty()) {
                edtName.setError("Enter your name");
                edtName.requestFocus();

            } else if (email.isEmpty()) {
                edtEmail.setError("Enter your email");
                edtEmail.requestFocus();

            } else if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
                edtEmail.setError("Enter valid email");
                edtEmail.requestFocus();

            } else if (!mobile.matches("[0-9]{10}")) {
                edtMobile.setError("Enter valid 10 digit mobile");
                edtMobile.requestFocus();

            } else if (password.length() < 6) {
                edtPassword.setError("Password must be 6 characters");
                edtPassword.requestFocus();

            } else if (!password.equals(confirmPassword)) {
                edtConfirmPassword.setError("Password does not match");
                edtConfirmPassword.requestFocus();

            } else {

                Toast.makeText(
                        Signup.this,
                        "Registration details are valid!",
                        Toast.LENGTH_SHORT
                ).show();

            }
        });

        txtLogin.setOnClickListener(v -> {
            finish();
        });
    }
}



