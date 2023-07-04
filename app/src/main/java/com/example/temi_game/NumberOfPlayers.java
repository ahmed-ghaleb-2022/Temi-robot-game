package com.example.temi_game;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

public class NumberOfPlayers extends AppCompatActivity {

    public int numberOfPlyaers;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_number_of_players);
    }


    private void SetPlayers(int num){
        numberOfPlyaers = num;
        // TODO: next activity
    }

    public void SetPlayers2(View view) {
        SetPlayers(2);
    }

    public void SetPlayers3(View view) {
        SetPlayers(3);
    }

    public void SetPlayers4(View view) {
        SetPlayers(4);
    }
}