package com.example.temi_game;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class PlayersSelection extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_players_selection);

        // Assuming your buttons have ids btn2, btn3 and btn4
        Button btn2 = findViewById(R.id.btn2);
        btn2.setOnClickListener(v -> {
            GameData.getInstance().setPlayerCount(2);
            navigateToGoalSelection();
        });

        // Add similar logic for the rest of the buttons
    }

    private void navigateToGoalSelection() {
        Intent intent = new Intent(PlayersSelection.this, ChooseGoal.class);
        startActivity(intent);
    }
}


