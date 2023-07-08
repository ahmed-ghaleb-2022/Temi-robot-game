package com.example.temi_game;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.SeekBar;

import androidx.appcompat.app.AppCompatActivity;

public class ChooseGoal extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose_goal);

        SeekBar seekBar = findViewById(R.id.seekBar);
        seekBar.setMax(100);
        seekBar.setProgress(20);

        Button btnConfirm = findViewById(R.id.btnConfirm);
        btnConfirm.setOnClickListener(v -> {
            GameData.getInstance().setGoalSeconds(seekBar.getProgress());
            navigateToGameActivity();
        });
    }

    private void navigateToGameActivity() {
        Intent intent = new Intent(ChooseGoal.this, GameActivity.class);
        startActivity(intent);
    }
}

