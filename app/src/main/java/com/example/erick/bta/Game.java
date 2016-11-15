package com.example.erick.bta;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.widget.Button;

import java.sql.Time;
import java.util.ArrayList;
import java.util.Random;
import java.util.concurrent.RunnableFuture;
import java.util.concurrent.TimeUnit;


public class Game extends AppCompatActivity {

    Button _red;
    Button _blue;
    static ArrayList _pattern = new ArrayList();
    static int _score;
    boolean _flashBackplaying;
    int _listElemToCheck;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);
        _listElemToCheck = 0;
        _flashBackplaying = true;
        _red = (Button)findViewById(R.id.Red);
        _blue = (Button)findViewById(R.id.Blue);
        Random randNum = new Random();
        Integer r = ((randNum.nextInt(100))%2);
        _pattern.add(r);
        startAnimation();
        _flashBackplaying = false;
    }

    public void startAnimation(){
        int sizeOfPatter = _pattern.size();
        System.out.println("about to start for loop");
        int j = 1;
        for(int i = 0; i < sizeOfPatter; i++){
            System.out.println(_pattern);
            if((Integer)_pattern.get(i) == 0){
                Runnable endWith = new Runnable() {
                    @Override
                    public void run() {
                        _red.setBackgroundColor(Color.RED);
                    }
                };
                Runnable startWith = new Runnable() {
                    @Override
                    public void run() {
                        _red.setBackgroundColor(Color.WHITE);
                    }
                };
                _red.animate().setDuration(1000);
                _red.animate().setStartDelay(2000*j);
                _red.animate().withStartAction(startWith);
                _red.animate().withEndAction(endWith);
                _red.animate().start();
                /*_red.setBackgroundColor(Color.WHITE);

                _red.setBackgroundColor(Color.RED);*/
            } else {Runnable endWith = new Runnable() {
                @Override
                public void run() {
                    _blue.setBackgroundColor(Color.BLUE);
                }
            };
                Runnable startWith = new Runnable() {
                    @Override
                    public void run() {
                        _blue.setBackgroundColor(Color.WHITE);
                    }
                };
                _blue.animate().setDuration(1000);
                _blue.animate().setStartDelay(2000*j);
                _blue.animate().withStartAction(startWith);
                _blue.animate().withEndAction(endWith);
                _blue.animate().start();
            }
            j++;
        }
        System.out.println("exiting the loop");
    }

    public void onClick(View view){
        // 2. find button clicked on id by name.
        // 3. test make sure correct.
        // 4. if correct reload activity.
        if(_flashBackplaying == true) {
            // you lose.

        }
        int check;
        System.out.println("insde the onClick method");
     /*   Intent intent = new Intent(this, Game.class);
        startActivity(intent);*/

        //start playback if correct.
        //if(_pattern.get(_listElemToCheck) == )
    }

    public void quit(View view){
        // show high score.
        // new scene to show score and ask if they wanted to play again.
        _pattern = new ArrayList();
        System.out.println("insde the quit method");
    }

}
