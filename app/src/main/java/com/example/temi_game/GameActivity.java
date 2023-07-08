package com.example.temi_game;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
import android.os.Looper;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;

import java.util.ArrayList;

public class GameActivity extends AppCompatActivity {
    private ArrayList<Player> players;
    private int goalSeconds;
    private Handler handler = new Handler(Looper.getMainLooper());
    private Player currentPlayer;
    private LinearLayout playerContainer; // Assuming a LinearLayout to contain all players' views

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        this.goalSeconds = GameData.getInstance().getGoalSeconds();
        int playerCount = GameData.getInstance().getPlayerCount();

        // Init players
        players = new ArrayList<>();
        for (int i = 0; i < playerCount; i++) {
            players.add(new Player(i, goalSeconds));
        }

        playerContainer = findViewById(R.id.playerContainer);
        createPlayerViews();

        Button btnExit = findViewById(R.id.btnExitGame);
        btnExit.setOnClickListener(v -> {
            // Stop all timers before exiting the game
            for (Player player : players) {
                player.stopTimer();
            }
            finishAffinity();
        });
    }

    private void createPlayerViews() {
        for (Player player : players) {
            Button playerButton = new Button(this);
            ProgressBar progressBar = new ProgressBar(this, null, android.R.attr.progressBarStyleHorizontal);
            TextView timerText = new TextView(this);

            playerButton.setText("Player " + (player.id + 1));
            playerButton.setOnClickListener(v -> {
                startTimer(player);
            });

            playerContainer.addView(playerButton);
            playerContainer.addView(progressBar);
            playerContainer.addView(timerText);

            player.setPlayerButton(playerButton);
            player.setProgressBar(progressBar);
            player.setTimerText(timerText);
        }
    }

    private void startTimer(Player player) {
        if (currentPlayer == player && player.isTimerRunning()) {
            currentPlayer.stopTimer();
            currentPlayer = null;
        } else {
            if (currentPlayer != null) {
                currentPlayer.stopTimer();
            }
            currentPlayer = player;
            currentPlayer.startTimer();
        }
    }

    class Player {
        private int id;
        private int totalSeconds;
        private int goalSeconds;
        private Button playerButton;
        private ProgressBar progressBar;
        private TextView timerText;
        private CountDownTimer timer;
        private boolean timerRunning = false;

        public Player(int id, int goalSeconds) {
            this.id = id;
            this.totalSeconds = 0;
            this.goalSeconds = goalSeconds;
        }

        public void setPlayerButton(Button playerButton) {
            this.playerButton = playerButton;
        }

        public void setProgressBar(ProgressBar progressBar) {
            this.progressBar = progressBar;
        }

        public void setTimerText(TextView timerText) {
            this.timerText = timerText;
        }

        public void incrementSeconds() {
            totalSeconds++;
            updateProgress();
            timerText.setText(totalSeconds + "/" + goalSeconds);
            if (totalSeconds >= goalSeconds) {
                stopTimer();
                playerButton.setBackgroundColor(Color.GREEN);
                progressBar.setProgressDrawable(new ColorDrawable(Color.GREEN));
                TextView winnerText = new TextView(GameActivity.this);
                winnerText.setText("Winner!");
                playerContainer.addView(winnerText);
            }
        }

        public void startTimer() {
            timer = new CountDownTimer(Long.MAX_VALUE, 1000) {
                public void onTick(long millisUntilFinished) {
                    incrementSeconds();
                }

                public void onFinish() {
                }
            }.start();
            timerRunning = true;
        }

        public void stopTimer() {
            if (timer != null) {
                timer.cancel();
            }
            timerRunning = false;
        }

        public boolean isTimerRunning() {
            return timerRunning;
        }

        private void updateProgress() {
            handler.post(() -> {
                progressBar.setProgress((totalSeconds * 100) / goalSeconds);
            });
        }
    }
}
