package com.donhat.musicplayerapp;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    private Button _startBtn;
    private Button _stopBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        initializeViews();

        handleEvents();
    }

    private void initializeViews() {
        _startBtn = findViewById(R.id.start_btn);
        _stopBtn = findViewById(R.id.stop_btn);
    }

    private void handleEvents() {
        _startBtn.setOnClickListener(v1 -> {
            Intent serviceIntent = new Intent(this, MusicService.class);
            startService(serviceIntent);
        });

        _stopBtn.setOnClickListener(v1 -> {
            Intent serviceIntent = new Intent(this, MusicService.class);
            stopService(serviceIntent);
        });
    }
}