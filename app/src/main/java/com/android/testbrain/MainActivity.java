package com.android.testbrain;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    ImageButton btnPlay;
    Button btnHighScore;
    SharedPreferences sharedpreferences;
    int HighScore = 0;
    Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        btnHighScore = findViewById(R.id.btnHighSocre);
        btnPlay = findViewById(R.id.btnPlay);


        btnPlay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent = new Intent(MainActivity.this, GameActivity.class);
                intent.putExtra("HighScore", 0);
                startActivity(intent);

            }
        });
        intent = getIntent();
        sharedpreferences = getSharedPreferences("MyRef", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedpreferences.edit();
        int temp  = intent.getIntExtra("HighScore", 0);
        int tempScore = sharedpreferences.getInt("HighScore", 0);
        if(temp >= tempScore)
            tempScore = temp;

        editor.putInt("HighScore", tempScore);
        editor.commit();
        btnHighScore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(sharedpreferences.contains("HighScore"))
                Toast.makeText(MainActivity.this, "HighScore is "  + sharedpreferences.getInt("HighScore", 0), Toast.LENGTH_SHORT).show();
            }
        });
    }
}
