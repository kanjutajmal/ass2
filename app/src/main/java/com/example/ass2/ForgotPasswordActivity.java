package com.example.ass2;

import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.material.textfield.TextInputEditText;

public class ForgotPasswordActivity extends AppCompatActivity {

    private TextInputEditText etEmail;
    private Button btnSendRecovery;
    private TextView tvBackToLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_forgot_password);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        etEmail = findViewById(R.id.etEmail);
        btnSendRecovery = findViewById(R.id.btnSendRecovery);
        tvBackToLogin = findViewById(R.id.tvBackToLogin);

        btnSendRecovery.setOnClickListener(v -> handleRecovery());

        tvBackToLogin.setOnClickListener(v -> finish());
    }

    private void handleRecovery() {
        String email = etEmail.getText() != null ? etEmail.getText().toString().trim() : "";

        if (email.isEmpty()) {
            Toast.makeText(this, R.string.error_empty_fields, Toast.LENGTH_SHORT).show();
            return;
        }

        if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            Toast.makeText(this, R.string.error_invalid_email, Toast.LENGTH_SHORT).show();
            return;
        }

        Toast.makeText(this, R.string.success_recovery, Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(ForgotPasswordActivity.this, ResetPasswordActivity.class);
        startActivity(intent);
        finish();
    }
}
