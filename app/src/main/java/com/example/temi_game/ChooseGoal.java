package com.example.temi_game;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class ChooseGoal extends AppCompatActivity {
    private TextView txtSeconds;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose_goal);

        txtSeconds = findViewById(R.id.txtSeconds);
        SeekBar seekBar = findViewById(R.id.seekBar);
        seekBar.setMax(100);
        seekBar.setProgress(20);
        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                txtSeconds.setText(String.valueOf(progress)+" seconds");
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
            }
        });

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


