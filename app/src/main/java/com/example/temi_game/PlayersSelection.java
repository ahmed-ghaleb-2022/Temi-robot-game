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

        Button btn2 = findViewById(R.id.btn2);
        btn2.setOnClickListener(v -> {
            GameData.getInstance().setPlayerCount(2);
            navigateToGoalSelection();
        });

        Button btn3 = findViewById(R.id.btn3);
        btn3.setOnClickListener(v -> {
            GameData.getInstance().setPlayerCount(3);
            navigateToGoalSelection();
        });

        Button btn4 = findViewById(R.id.btn4);
        btn4.setOnClickListener(v -> {
            GameData.getInstance().setPlayerCount(4);
            navigateToGoalSelection();
        });
    }

    private void navigateToGoalSelection() {
        Intent intent = new Intent(PlayersSelection.this, ChooseGoal.class);
        startActivity(intent);
    }
}


