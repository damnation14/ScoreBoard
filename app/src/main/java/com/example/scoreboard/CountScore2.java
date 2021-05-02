package com.example.scoreboard;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

public class CountScore2 extends AppCompatActivity {

    private TextView textr,textw,textt;private ImageButton button1,buttonw,button4,button6;Button scoredone;int runs=0,wickets=0,tt;
    String targets;
    public static final String finalscore = "0";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_count_score);

        textr=(TextView) findViewById(R.id.runs);
        textt=(TextView) findViewById(R.id.textView);
        textw=(TextView) findViewById(R.id.wickets);
        button1 = (ImageButton) findViewById(R.id.add1);
        buttonw = (ImageButton) findViewById(R.id.addw);
        button4 = (ImageButton) findViewById(R.id.add4);
        button6 = (ImageButton) findViewById(R.id.add6);
        scoredone=(Button)findViewById(R.id.Done);

        Bundle targ= getIntent().getExtras();
        targets=targ.getString("targetscore");
        textt.setText("Target:"+targets);
        tt=Integer.parseInt(targets);
        button1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Do something in response to button click
                runs++;
                System.out.println("hellow");
                String run = Integer.toString(runs);
                textr.setText(run);
            }
        });
        button4.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Do something in response to button click
                runs+=4;
                String run = Integer.toString(runs);
                textr.setText(run);
            }
        });
        button6.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Do something in response to button click
                runs+=6;
                String run = Integer.toString(runs);
                textr.setText(run);
            }
        });
        buttonw.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Do something in response to button click
                wickets++;
                String run = Integer.toString(wickets);
                textw.setText(run);
            }
        });
        scoredone.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Do something in response to button click
                Intent intent = new Intent(CountScore2.this, MainActivity.class);
                String tempscore=textr.getText().toString();
                intent.putExtra("finalscore2", tempscore);
                setResult(3,intent);
                finish();

            }
        });



    }
}