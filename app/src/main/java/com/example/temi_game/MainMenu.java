package com.example.temi_game;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainMenu extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_menu);
    }

    public void StartGame(View view) {
        Intent intent = new Intent(MainMenu.this, NumberOfPlayers.class);
        startActivity(intent);
    }

    public void Exit(View view){
        // TODO: exit logic
    }
}