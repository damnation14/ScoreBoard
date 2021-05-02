package com.example.scoreboard;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    public static String target;int score1;
    private Button button1,button2; private TextView text;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button1 = (Button) findViewById(R.id.Team1button);
        button2 = (Button) findViewById(R.id.Team2button);
        button1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Do something in response to button click
                Intent intent = new Intent(MainActivity.this, CountScore.class);
                startActivityForResult(intent, 2);
            }
        });

        button2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Do something in response to button click
                Intent intent = new Intent(MainActivity.this, CountScore2.class);
                intent.putExtra("targetscore", target);
                startActivityForResult(intent, 3);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data)
    {
        super.onActivityResult(requestCode, resultCode, data);
        int duration = Toast.LENGTH_SHORT;
        // check if the request code is same as what is passed  here it is 2
        if(requestCode==2)
        {
            target=data.getStringExtra("finalscore");
            score1=Integer.parseInt(target);
            System.out.println("target:"+target);
            Toast toast = Toast.makeText(MainActivity.this, "Target:"+target, duration);
            toast.show();
        }
        if(requestCode==3)
        {
            String temps=data.getStringExtra("finalscore2");
            int score2=Integer.parseInt(temps);
            System.out.println(score1+":"+score2);
            if(score2>=score1)
            {

                Toast toast = Toast.makeText(MainActivity.this, "Team 2 wins!", duration);
                toast.show();
            }
            else if(score2==score1-1)
            {

                Toast toast = Toast.makeText(MainActivity.this, "Match Draw", duration);
                toast.show();
            }
            else
            {
                Toast toast = Toast.makeText(MainActivity.this, "Team 1 wins!", duration);
                toast.show();
            }

        }
    }
}