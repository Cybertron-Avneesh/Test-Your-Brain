package com.android.testbrain;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextSwitcher;
import android.widget.TextView;
import android.widget.Toast;

import java.security.SecureRandom;
import java.util.Random;

public class GameActivity extends AppCompatActivity {

    Button btnLeft;
    Button btnRight;
    TextView txtPoint;
    TextView txtLife;
    private int Life = 3;
    private int Points = 0;
    Random random = new Random();
    char curr_BTN = 'R';


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);
        btnLeft = findViewById(R.id.btnLeft);
        btnRight = findViewById(R.id.btnRight);
        txtLife = findViewById(R.id.txtLife);
        txtPoint = findViewById(R.id.txtPoint);
        //   Initialise the Life and Point
        txtPoint.setText(Points  + "");
        txtLife.setText(Life + "");
        final int[] color = {R.color.Black, R.color.Blue, R.color.Green, R.color.Red};
        final String[] text = {"Right", "Left"};
        final int[] btn = {1,2};

        int random_btn = random.nextInt(3-1) + 1;
        int random_color1 = random.nextInt(4-0) + 0;
        int random_color2 = random.nextInt(4-0) + 0;
        int random_targetBTN = random.nextInt(2-0) + 0;
        btnLeft.setBackgroundResource(color[random_color1]);
        btnRight.setBackgroundResource(color[random_color2]);
        if(random_btn == 1)
        {
            btnLeft.setText(text[random_targetBTN]);
            if(random_targetBTN == 0)
                curr_BTN = 'R';
            else if(random_targetBTN == 1)
                curr_BTN = 'L';
            btnRight.setText("");
        }
        if(random_btn == 2)
        {
            btnRight.setText(text[random_targetBTN]);
            if(random_targetBTN == 0)
                curr_BTN = 'R';
            else if(random_targetBTN == 1)
                curr_BTN = 'L';
            btnLeft.setText("");
        }


        btnRight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(curr_BTN == 'R')
                {
                    Points = Points + 20;
                    txtPoint.setText(Points  + "");
                }
                else
                {
                    Life = Life -1;
                    txtLife.setText(Life + "");
                    if(Life == 0)
                    {
                        Toast.makeText(GameActivity.this, "Your Score is " + Points, Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(GameActivity.this, MainActivity.class);
                        startActivity(intent);
                    }
                }
                int random_btn = random.nextInt(3-1) + 1;
                int random_color1 = random.nextInt(4-0) + 0;
                int random_color2 = random.nextInt(4-0) + 0;
                int random_targetBTN = random.nextInt(2-0) + 0;
                btnLeft.setBackgroundResource(color[random_color1]);
                btnRight.setBackgroundResource(color[random_color2]);
                if(random_btn == 1)
                {
                    btnLeft.setText(text[random_targetBTN]);
                    if(random_targetBTN == 0)
                        curr_BTN = 'R';
                    else if(random_targetBTN == 1)
                        curr_BTN = 'L';
                    btnRight.setText("");
                }
                if(random_btn == 2)
                {
                    btnRight.setText(text[random_targetBTN]);
                    if(random_targetBTN == 0)
                        curr_BTN = 'R';
                    else if(random_targetBTN == 1)
                        curr_BTN = 'L';
                    btnLeft.setText("");
                }
            }
        });

        btnLeft.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(curr_BTN == 'L')
                {
                    Points = Points + 20;
                    txtPoint.setText(Points  + "");
                }
                else
                {
                    Life = Life -1;
                    txtLife.setText(Life + "");
                    if(Life == 0)
                    {
                        Toast.makeText(GameActivity.this, "Your Score is " + Points, Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(GameActivity.this, MainActivity.class);
                        startActivity(intent);
                    }
                }
                int random_btn = random.nextInt(3-1) + 1;
                int random_color1 = random.nextInt(4-0) + 0;
                int random_color2 = random.nextInt(4-0) + 0;
                int random_targetBTN = random.nextInt(2-0) + 0;
                btnLeft.setBackgroundResource(color[random_color1]);
                btnRight.setBackgroundResource(color[random_color2]);
                if(random_btn == 1)
                {
                    btnLeft.setText(text[random_targetBTN]);
                    if(random_targetBTN == 0)
                        curr_BTN = 'R';
                    else if(random_targetBTN == 1)
                        curr_BTN = 'L';
                    btnRight.setText("");
                }
                if(random_btn == 2)
                {
                    btnRight.setText(text[random_targetBTN]);
                    if(random_targetBTN == 0)
                        curr_BTN = 'R';
                    else if(random_targetBTN == 1)
                        curr_BTN = 'L';
                    btnLeft.setText("");
                }

            }
        });

    }
}
