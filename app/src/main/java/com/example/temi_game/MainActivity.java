package com.example.temi_game;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    public void StartMainMenu(View view) {
        Intent intent = new Intent(MainActivity.this, FirstScreen.class);
        startActivity(intent);
    }

    public void GoTOFirstActivity(View view){
        Intent intent = new Intent(MainActivity.this, FirstScreen.class);
        startActivity(intent);
    }
}