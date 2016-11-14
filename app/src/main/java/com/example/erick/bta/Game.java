package com.example.erick.bta;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;
import java.util.Random;
import java.util.concurrent.TimeUnit;


public class Game extends AppCompatActivity {

    Button _red;
    Button _blue;
    static ArrayList _pattern;
    boolean _flashBackplaying;
    int _listElemToCheck;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);
        _listElemToCheck = 0;
        _pattern = new ArrayList();
        _flashBackplaying = true;
        _red = (Button)findViewById(R.id.Red);
        _blue = (Button)findViewById(R.id.Blue);
        Random randNum = new Random();
        Integer r = ((randNum.nextInt(100))%2);
        _pattern.add(r);
        int sizeOfPatter = _pattern.size();
        for(int i = 0; i < sizeOfPatter; i++){
            if(_pattern.get(i) == 0){
                _red.setBackgroundColor(Color.WHITE);
                try{
                    TimeUnit.SECONDS.wait(1);
                }catch (Exception e){
                    System.out.println("something went wrong.");
                }
                _red.setBackgroundColor(Color.RED);
            } else {
                _blue.setBackgroundColor(Color.WHITE);
                try{
                    TimeUnit.SECONDS.wait(1);
                }catch (Exception e){
                    System.out.println("something else went wrong");
                }
                _blue.setBackgroundColor(Color.BLUE);
            }
        }
        _flashBackplaying = false;
    }

    public void onClick(View view){
        // 2. find button clicked on id by name.
        // 3. test make sure correct.
        // 4. if correct reload activity.
        if(_flashBackplaying) {
            // you lose.
        }
        int check;



        //if(_pattern.get(_listElemToCheck) == )
    }

    public void quit(){
        // show high score.
        // new scene to show score and ask if they wanted to play again.
    }

}
