package com.example.temi_game;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class FirstScreen extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first_screen);

        Button playButton = findViewById(R.id.btnPlay);
        playButton.setOnClickListener(v -> {
            Intent intent = new Intent(FirstScreen.this, PlayersSelection.class);
            startActivity(intent);
        });

        Button exitButton = findViewById(R.id.btnExit);
        exitButton.setOnClickListener(v -> finish());
    }
}
