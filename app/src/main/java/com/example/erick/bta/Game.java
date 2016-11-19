package com.example.erick.bta;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.LinearInterpolator;
import android.widget.Button;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.sql.Time;
import java.util.ArrayList;
import java.util.Random;
import java.util.concurrent.RunnableFuture;
import java.util.concurrent.TimeUnit;


public class Game extends AppCompatActivity {

    Button _red;
    Button _blue;
    Button _yellow;
    Button _green;
    int _delay = 0;
    int _replay = 0;
    TextView text;
    TextView _count;
    static ArrayList<Integer> _pattern ;
    static int _score;
    boolean _flashBackplaying;
    int _listElemToCheck;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);
        _listElemToCheck = 0;
        _score = 0;
        _flashBackplaying = true;
        _pattern = new ArrayList<Integer>();
        _red = (Button)findViewById(R.id.Red);
        _red.setBackgroundColor(Color.RED);
        _blue = (Button)findViewById(R.id.Blue);
        _blue.setBackgroundColor(Color.BLUE);
        _yellow = (Button)findViewById(R.id.Yellow);
        _yellow.setBackgroundColor(Color.YELLOW);
        _green = (Button)findViewById(R.id.Green);
        _green.setBackgroundColor(Color.GREEN);
        text = (TextView)findViewById(R.id.Score);
        _count = (TextView)findViewById(R.id.Count);
        Random randNum = new Random();
        Integer r = 3;
                //((randNum.nextInt(1000000))%4);
        _pattern.add(r);
        startAnimation();
        _flashBackplaying = false;
    }

    public void startAnimation(){
        int sizeOfPatter = _pattern.size();
        int durationLength = 1000;
        int startDelay = 2000;
        if(_score < 5){
            durationLength = 1000;
            startDelay = 2000;
        } else if(_score > 4){
            durationLength = 800;
            startDelay = 1500;
        } else if(_score > 9){
            durationLength = 600;
            startDelay = 1000;
        } else if(_score > 14){
            durationLength = 100;
            startDelay = 200;
        }
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
                _red.animate().setDuration(durationLength);
                _red.animate().setStartDelay(2000*j);
                _red.animate().withStartAction(startWith);
                _red.animate().withEndAction(endWith);
                _red.animate().start();
                //_red.setBackgroundColor(Color.WHITE);
                //_red.setBackgroundColor(Color.RED);
            } else if((Integer)_pattern.get(i) == 1) {
                Runnable endWith = new Runnable() {
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
                _blue.animate().setDuration(durationLength);
                _blue.animate().setStartDelay(startDelay*j);
                _blue.animate().withStartAction(startWith);
                _blue.animate().withEndAction(endWith);
                _blue.animate().start();
            } else if((Integer)_pattern.get(i) == 2){
                //yellow
                Runnable endWith = new Runnable() {
                    @Override
                    public void run() {
                        _yellow.setBackgroundColor(Color.YELLOW);
                    }
                };
                Runnable startWith = new Runnable() {
                    @Override
                    public void run() {
                        _yellow.setBackgroundColor(Color.WHITE);
                    }
                };
                _yellow.animate().setDuration(durationLength);
                _yellow.animate().setStartDelay(startDelay*j);
                _yellow.animate().withStartAction(startWith);
                _yellow.animate().withEndAction(endWith);
                _yellow.animate().start();
            } else if((Integer)_pattern.get(i) == 3){
                //green
                Runnable endWith = new Runnable() {
                    @Override
                    public void run() {
                        _green.setBackgroundColor(Color.GREEN);
                    }
                };
                Runnable startWith = new Runnable() {
                    @Override
                    public void run() {
                        _green.setBackgroundColor(Color.WHITE);
                    }
                };
                _green.animate().setDuration(durationLength);
                _green.animate().setStartDelay(startDelay*j);
                _green.animate().withStartAction(startWith);
                _green.animate().withEndAction(endWith);
                _green.animate().start();
            }
            j++;
        }
        System.out.println("exiting the loop");
    }


    public void onClick(View view){
        // 2. find button clicked on id by name.
        // 3. test make sure correct.
        // 4. if correct add element and start animation again.
        if(_flashBackplaying == true) {
            // you lose.
        }
        int check;
        System.out.println("insde the onClick method");
        switch (view.getId()){
            case R.id.Red:
                testCorrect(0);
                break;
            case R.id.Blue:
                testCorrect(1);
                break;
            case R.id.Yellow:
                testCorrect(2);
                break;
            case R.id.Green:
                testCorrect(3);
                break;
        }
    }

    public void testCorrect(int x){
        if((Integer)_pattern.get(_listElemToCheck) == x){
            _listElemToCheck++;
            _count.setText("Count: " + Integer.toString(_listElemToCheck));
        } else{
            // you lose
            lose();
            _listElemToCheck = 0;
            _pattern = new ArrayList();
        }

        if(_listElemToCheck >= _pattern.size()) {
            // Add new element
            //if listElemToCheck less less than do this:
            _listElemToCheck = 0;
            _score++;
            text.setText("Score: " + Integer.toString(_score*5));
            _count.setText("Count: " + _listElemToCheck);
            Random randNum = new Random();
            Integer r = (randNum.nextInt(1000000)) % 4;
            _pattern.add(r);
            _flashBackplaying = true;
            startAnimation();
            _flashBackplaying = false;
            //else start new scene with more boxes.
        }
    }

    public void lose(){
        Intent i = new Intent(Game.this,Score.class);
        Bundle bundle = new Bundle();
        bundle.putString("score",Integer.toString(_score));
        i.putExtras(bundle);
        startActivity(i);
    }

    public void quit(View view){
        // show high score.
        // new scene to show score and ask if they wanted to play again.
        lose();
    }

    public void replay(View view) {
        if(_replay < 4){
            _flashBackplaying = true;
            startAnimation();
            _flashBackplaying = false;
            _replay++;
        }
    }

}