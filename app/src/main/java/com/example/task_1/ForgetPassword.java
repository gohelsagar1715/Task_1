package com.example.task_1;

import android.os.Bundle;
import android.util.Patterns;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class ForgetPassword extends AppCompatActivity {

    EditText edtEmail;
    Button btnReset;
    TextView txtBackLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgot_password);

        edtEmail = findViewById(R.id.edtEmail);
        btnReset = findViewById(R.id.btnReset);
        txtBackLogin = findViewById(R.id.txtBackLogin);

        btnReset.setOnClickListener(v -> {
            String email = edtEmail.getText().toString().trim();

            if (email.isEmpty()) {
                edtEmail.setError("Enter your email");
            } else if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
                edtEmail.setError("Enter valid email");
            } else {
                Toast.makeText(this,
                        "Email is valid. Connect Firebase to send reset link.",
                        Toast.LENGTH_LONG).show();
            }
        });

        txtBackLogin.setOnClickListener(v -> finish());
    }
}

