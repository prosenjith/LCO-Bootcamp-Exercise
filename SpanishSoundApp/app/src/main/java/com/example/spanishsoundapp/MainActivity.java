package com.example.spanishsoundapp;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Button btn1,btn2,btn3,btn4,btn5,btn6,btn7,btn8,btn9,btn10;
    private MediaPlayer mediaPlayer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //mediaPlayer=MediaPlayer.create(this,R.raw.one);
        btn1=findViewById(R.id.button1_id);
        btn2=findViewById(R.id.button2_id);
        btn3=findViewById(R.id.button3_id);
        btn4=findViewById(R.id.button4_id);
        btn5=findViewById(R.id.button5_id);
        btn6=findViewById(R.id.button6_id);
        btn7=findViewById(R.id.button7_id);
        btn8=findViewById(R.id.button8_id);
        btn9=findViewById(R.id.button9_id);
        btn10=findViewById(R.id.button10_id);

        btn1.setOnClickListener(new ButtonClick());
        btn2.setOnClickListener(new ButtonClick());
        btn3.setOnClickListener(new ButtonClick());
        btn4.setOnClickListener(new ButtonClick());
        btn5.setOnClickListener(new ButtonClick());
        btn6.setOnClickListener(new ButtonClick());
        btn7.setOnClickListener(new ButtonClick());
        btn8.setOnClickListener(new ButtonClick());
        btn9.setOnClickListener(new ButtonClick());
        btn10.setOnClickListener(new ButtonClick());
    }
    class ButtonClick implements View.OnClickListener
    {
        @Override
        public void onClick(View view) {
            switch(view.getId())
            {
                case R.id.button1_id:
                {
                    mediaPlayer=MediaPlayer.create(getApplicationContext(),R.raw.one);
                    mediaPlayer.start();
                    break;
                    //Toast.makeText(getApplicationContext(),"Button CLicked.",Toast.LENGTH_SHORT).show();
                }
                case R.id.button2_id:
                {
                    mediaPlayer=MediaPlayer.create(getApplicationContext(),R.raw.two);
                    mediaPlayer.start();
                    break;
                }
                case R.id.button3_id:
                {
                    mediaPlayer=MediaPlayer.create(getApplicationContext(),R.raw.three);
                    mediaPlayer.start();
                    break;
                    //Toast.makeText(getApplicationContext(),"Button CLicked.",Toast.LENGTH_SHORT).show();
                }
                case R.id.button4_id:
                {
                    mediaPlayer=MediaPlayer.create(getApplicationContext(),R.raw.four);
                    mediaPlayer.start();
                    break;
                }
                case R.id.button5_id:
                {
                    mediaPlayer=MediaPlayer.create(getApplicationContext(),R.raw.five);
                    mediaPlayer.start();
                    break;
                    //Toast.makeText(getApplicationContext(),"Button CLicked.",Toast.LENGTH_SHORT).show();
                }
                case R.id.button6_id:
                {
                    mediaPlayer=MediaPlayer.create(getApplicationContext(),R.raw.six);
                    mediaPlayer.start();
                    break;
                }
                case R.id.button7_id:
                {
                    mediaPlayer=MediaPlayer.create(getApplicationContext(),R.raw.seven);
                    mediaPlayer.start();
                    break;
                    //Toast.makeText(getApplicationContext(),"Button CLicked.",Toast.LENGTH_SHORT).show();
                }
                case R.id.button8_id:
                {
                    mediaPlayer=MediaPlayer.create(getApplicationContext(),R.raw.eight);
                    mediaPlayer.start();
                    break;
                }
                case R.id.button9_id:
                {
                    mediaPlayer=MediaPlayer.create(getApplicationContext(),R.raw.nine);
                    mediaPlayer.start();
                    break;
                    //Toast.makeText(getApplicationContext(),"Button CLicked.",Toast.LENGTH_SHORT).show();
                }
                case R.id.button10_id:
                {
                    mediaPlayer=MediaPlayer.create(getApplicationContext(),R.raw.ten);
                    mediaPlayer.start();
                    break;
                }
            }
        }
    }
}
