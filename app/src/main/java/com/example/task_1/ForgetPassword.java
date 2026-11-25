
package com.example.task_1;

import android.os.Bundle;
import android.util.Patterns;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class ForgetPassword extends AppCompatActivity {

    EditText edtEmail, edtOldPassword, edtNewPassword;
    Button btnUpdatePassword;
    TextView txtBackLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgot_password);

        edtEmail = findViewById(R.id.edtEmail);
        edtOldPassword = findViewById(R.id.edtOldPassword);
        edtNewPassword = findViewById(R.id.edtNewPassword);

        btnUpdatePassword = findViewById(R.id.btnUpdatePassword);
        txtBackLogin = findViewById(R.id.txtBackLogin);

        btnUpdatePassword.setOnClickListener(v -> {

            String email = edtEmail.getText().toString().trim();
            String oldPassword = edtOldPassword.getText().toString().trim();
            String newPassword = edtNewPassword.getText().toString().trim();

            if (email.isEmpty()) {
                edtEmail.setError("Enter your email");
                edtEmail.requestFocus();

            } else if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
                edtEmail.setError("Enter valid email");
                edtEmail.requestFocus();

            } else if (oldPassword.isEmpty()) {
                edtOldPassword.setError("Enter old password");
                edtOldPassword.requestFocus();

            } else if (newPassword.isEmpty()) {
                edtNewPassword.setError("Enter new password");
                edtNewPassword.requestFocus();

            } else if (newPassword.length() < 6) {
                edtNewPassword.setError("Password must be at least 6 characters");
                edtNewPassword.requestFocus();

            } else if (oldPassword.equals(newPassword)) {
                edtNewPassword.setError("New password must be different");
                edtNewPassword.requestFocus();

            } else {

                Toast.makeText(this,
                        "All fields are valid. Connect database to update password.",
                        Toast.LENGTH_LONG).show();
            }
        });

        txtBackLogin.setOnClickListener(v -> finish());
    }
}
