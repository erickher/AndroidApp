package com.example.erick.bta;

import android.content.Intent;
import android.support.v4.widget.TextViewCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Score extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_score);
        Bundle bundle = getIntent().getExtras();
        String score = bundle.getString("score");
        ((TextView)findViewById(R.id.Score)).setText(score);

        Button replay = (Button)findViewById(R.id.Replay);
        replay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Score.this,Game.class);
                startActivity(i);
            }
        });
    }
}
