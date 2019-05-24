package com.example.drumpaddapp;

import android.media.AudioAttributes;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.media.SoundPool;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private Button btn1,btn2,btn3,btn4,btn5,btn6,btn7,btn8;
    //private MediaPlayer mediaPlayer;
    private SoundPool soundPool;
    private int sound1,sound2,sound3,sound4,sound5,sound6,sound7,sound8;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        View overlay=findViewById(R.id.myLayout);
        overlay.setSystemUiVisibility(View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
        | View.SYSTEM_UI_FLAG_FULLSCREEN
        | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY);

        if(Build.VERSION.SDK_INT>=Build.VERSION_CODES.LOLLIPOP) {
            AudioAttributes audioAttributes=new AudioAttributes.Builder()
                    .setUsage(AudioAttributes.USAGE_ASSISTANCE_SONIFICATION)
                    .setContentType(AudioAttributes.CONTENT_TYPE_SONIFICATION)
                    .build();
            soundPool=new SoundPool.Builder()
                    .setMaxStreams(6)
                    .setAudioAttributes(audioAttributes)
                    .build();
        }else {
            soundPool=new SoundPool(6, AudioManager.STREAM_MUSIC,0);
        }
        sound1=soundPool.load(this,R.raw.one,1);
        sound2=soundPool.load(this,R.raw.two,1);
        sound3=soundPool.load(this,R.raw.three,1);
        sound4=soundPool.load(this,R.raw.four,1);
        sound5=soundPool.load(this,R.raw.fv,1);
        sound6=soundPool.load(this,R.raw.sixth,1);
        sound7=soundPool.load(this,R.raw.seventh,1);
        sound8=soundPool.load(this,R.raw.eighth,1);

        btn1=findViewById(R.id.btn1_id);
        btn2=findViewById(R.id.btn2_id);
        btn3=findViewById(R.id.btn3_id);
        btn4=findViewById(R.id.btn4_id);
        btn5=findViewById(R.id.btn5_id);
        btn6=findViewById(R.id.btn6_id);
        btn7=findViewById(R.id.btn7_id);
        btn8=findViewById(R.id.btn8_id);

        btn1.setOnClickListener(new ButtonClick());
        btn2.setOnClickListener(new ButtonClick());
        btn3.setOnClickListener(new ButtonClick());
        btn4.setOnClickListener(new ButtonClick());
        btn5.setOnClickListener(new ButtonClick());
        btn6.setOnClickListener(new ButtonClick());
        btn7.setOnClickListener(new ButtonClick());
        btn8.setOnClickListener(new ButtonClick());

    }
    class ButtonClick implements View.OnClickListener
    {

        @Override
        public void onClick(View view) {
            switch (view.getId())
            {
                case R.id.btn1_id:
                    //soundPool.autoResume();
                    //mediaPlayer=MediaPlayer.create(getApplicationContext(),R.raw.one);
                    //mediaPlayer.start();
                    soundPool.play(sound1,1,1,0,0,1);
                    //soundPool.autoPause();
                    break;
                case R.id.btn2_id:
                    //soundPool.autoResume();
                    //mediaPlayer=MediaPlayer.create(getApplicationContext(),R.raw.two);
                    //mediaPlayer.start();
                    soundPool.play(sound2,1,1,0,0,1);
                    //soundPool.autoPause();
                    break;
                case R.id.btn3_id:
                    //soundPool.autoResume();
                    //mediaPlayer=MediaPlayer.create(getApplicationContext(),R.raw.three);
                    //mediaPlayer.start();
                    soundPool.play(sound3,1,1,0,0,1);
                    //soundPool.autoPause();
                    break;
                case R.id.btn4_id:
                    //soundPool.autoResume();
                    //mediaPlayer=MediaPlayer.create(getApplicationContext(),R.raw.four);
                    //mediaPlayer.start();
                    soundPool.play(sound4,1,1,0,0,1);
                    //soundPool.autoPause();
                    break;
                case R.id.btn5_id:
                    //soundPool.autoResume();
                    //mediaPlayer=MediaPlayer.create(getApplicationContext(),R.raw.fv);
                    //mediaPlayer.start();
                    soundPool.play(sound5,1,1,0,0,1);
                    //soundPool.autoPause();
                    break;
                case R.id.btn6_id:
                    //soundPool.autoResume();
                    //mediaPlayer=MediaPlayer.create(getApplicationContext(),R.raw.sixth);
                    //mediaPlayer.start();
                    soundPool.play(sound6,1,1,0,0,1);
                    //soundPool.autoPause();
                    break;
                case R.id.btn7_id:
                    //soundPool.autoResume();
                    //mediaPlayer=MediaPlayer.create(getApplicationContext(),R.raw.seventh);
                    //mediaPlayer.start();
                    soundPool.play(sound7,1,1,0,0,1);
                    //soundPool.autoPause();
                    break;
                case R.id.btn8_id:
                    //soundPool.autoResume();
                    //mediaPlayer=MediaPlayer.create(getApplicationContext(),R.raw.eighth);
                    //mediaPlayer.start();
                    soundPool.play(sound8,1,1,0,0,1);
                    //soundPool.autoPause();
                    break;

            }
        }
    }
    @Override
    protected void onDestroy() {
        super.onDestroy();
        soundPool.release();
        soundPool=null;
    }
}
