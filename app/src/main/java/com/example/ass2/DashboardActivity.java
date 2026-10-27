package com.example.ass2;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class DashboardActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_dashboard);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        CardView cardCourses = findViewById(R.id.cardCourses);
        CardView cardMessages = findViewById(R.id.cardMessages);
        CardView cardReports = findViewById(R.id.cardReports);
        CardView cardSettings = findViewById(R.id.cardSettings);
        CardView cardProfile = findViewById(R.id.cardProfile);
        CardView cardLogout = findViewById(R.id.cardLogout);

        cardCourses.setOnClickListener(v -> Toast.makeText(this, "Opening Courses Module", Toast.LENGTH_SHORT).show());
        cardMessages.setOnClickListener(v -> Toast.makeText(this, "Opening Messages Module", Toast.LENGTH_SHORT).show());
        cardReports.setOnClickListener(v -> Toast.makeText(this, "Opening Reports Module", Toast.LENGTH_SHORT).show());
        cardSettings.setOnClickListener(v -> Toast.makeText(this, "Opening Settings Module", Toast.LENGTH_SHORT).show());

        cardProfile.setOnClickListener(v -> {
            Intent intent = new Intent(DashboardActivity.this, ProfileActivity.class);
            startActivity(intent);
        });

        cardLogout.setOnClickListener(v -> {
            Intent intent = new Intent(DashboardActivity.this, LoginActivity.class);
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
            startActivity(intent);
            finish();
        });
    }
}
