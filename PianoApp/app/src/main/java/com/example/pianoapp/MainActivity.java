package com.example.pianoapp;

import android.app.ActionBar;
import android.media.AudioAttributes;
import android.media.AudioManager;
import android.media.SoundPool;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private Button a1,a2,a3,a4,a5,a6,a7,a8,a9,a10,b1,b2,b3,b4,b5,b6,b7,b8,b9,b10;
    private SoundPool soundPool;
    private int sa1,sa2,sa3,sa4,sa5,sa6,sa7,sa8,sa9,sa10,sb1,sb2,sb3,sb4,sb5,sb6,sb7,sb8,sb9,sb10;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        /*if (Build.VERSION.SDK_INT < 16) {
            getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        } else {
            View decorView = getWindow().getDecorView();
            int uiOptions = View.SYSTEM_UI_FLAG_FULLSCREEN;
            decorView.setSystemUiVisibility(uiOptions);
            ActionBar actionBar = getActionBar();
            actionBar.hide();
        }*/
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
                    .setMaxStreams(20)
                    .setAudioAttributes(audioAttributes)
                    .build();
        }else {
            soundPool=new SoundPool(20, AudioManager.STREAM_MUSIC,0);
        }

        sa1=soundPool.load(this,R.raw.a1,1);
        sa2=soundPool.load(this,R.raw.a4,1);
        sa3=soundPool.load(this,R.raw.a7,1);
        sa4=soundPool.load(this,R.raw.a10,1);
        sa5=soundPool.load(this,R.raw.a13,1);
        sa6=soundPool.load(this,R.raw.a16,1);
        sa7=soundPool.load(this,R.raw.a19,1);
        sa8=soundPool.load(this,R.raw.a22,1);
        sa9=soundPool.load(this,R.raw.a25,1);
        sa10=soundPool.load(this,R.raw.a28,1);

        sb1=soundPool.load(this,R.raw.b1,1);
        sb2=soundPool.load(this,R.raw.b4,1);
        sb3=soundPool.load(this,R.raw.b7,1);
        sb4=soundPool.load(this,R.raw.b10,1);
        sb5=soundPool.load(this,R.raw.b13,1);
        sb6=soundPool.load(this,R.raw.b16,1);
        sb7=soundPool.load(this,R.raw.b19,1);
        sb8=soundPool.load(this,R.raw.b22,1);
        sb9=soundPool.load(this,R.raw.b25,1);
        sb10=soundPool.load(this,R.raw.a34,1);

        a1=findViewById(R.id.button1);
        a2=findViewById(R.id.button2);
        a3=findViewById(R.id.button3);
        a4=findViewById(R.id.button4);
        a5=findViewById(R.id.button5);
        a6=findViewById(R.id.button6);
        a7=findViewById(R.id.button7);
        a8=findViewById(R.id.button8);
        a9=findViewById(R.id.button9);
        a10=findViewById(R.id.button10);
        b1=findViewById(R.id.button_b1);
        b2=findViewById(R.id.button_b2);
        b3=findViewById(R.id.button_b3);
        b4=findViewById(R.id.button_b4);
        b5=findViewById(R.id.button_b5);
        b6=findViewById(R.id.button_b6);
        b7=findViewById(R.id.button_b7);
        b8=findViewById(R.id.button_b8);
        b9=findViewById(R.id.button_b9);
        b10=findViewById(R.id.button_b10);

        a1.setOnClickListener(new ButtonClick());
        a2.setOnClickListener(new ButtonClick());
        a3.setOnClickListener(new ButtonClick());
        a4.setOnClickListener(new ButtonClick());
        a5.setOnClickListener(new ButtonClick());
        a6.setOnClickListener(new ButtonClick());
        a7.setOnClickListener(new ButtonClick());
        a8.setOnClickListener(new ButtonClick());
        a9.setOnClickListener(new ButtonClick());
        a10.setOnClickListener(new ButtonClick());
        b1.setOnClickListener(new ButtonClick());
        b2.setOnClickListener(new ButtonClick());
        b3.setOnClickListener(new ButtonClick());
        b4.setOnClickListener(new ButtonClick());
        b5.setOnClickListener(new ButtonClick());
        b6.setOnClickListener(new ButtonClick());
        b7.setOnClickListener(new ButtonClick());
        b8.setOnClickListener(new ButtonClick());
        b9.setOnClickListener(new ButtonClick());
        b10.setOnClickListener(new ButtonClick());


    }
    class ButtonClick implements View.OnClickListener{

        @Override
        public void onClick(View v) {
            switch(v.getId()){
                case R.id.button1:
                    soundPool.play(sa1,1,1,0,0,1);
                    break;
                case R.id.button2:
                    soundPool.play(sb1,1,1,0,0,1);
                    break;
                case R.id.button3:
                    soundPool.play(sa2,1,1,0,0,1);
                    break;
                case R.id.button4:
                    soundPool.play(sb2,1,1,0,0,1);
                    break;
                case R.id.button5:
                    soundPool.play(sa3,1,1,0,0,1);
                    break;
                case R.id.button6:
                    soundPool.play(sb3,1,1,0,0,1);
                    break;
                case R.id.button7:
                    soundPool.play(sa4,1,1,0,0,1);
                    break;
                case R.id.button8:
                    soundPool.play(sb4,1,1,0,0,1);
                    break;
                case R.id.button9:
                    soundPool.play(sa5,1,1,0,0,1);
                    break;
                case R.id.button10:
                    soundPool.play(sb5,1,1,0,0,1);
                    break;
                case R.id.button_b1:
                    soundPool.play(sa6,1,1,0,0,1);
                    break;
                case R.id.button_b2:
                    soundPool.play(sb6,1,1,0,0,1);
                    break;
                case R.id.button_b3:
                    soundPool.play(sa7,1,1,0,0,1);
                    break;
                case R.id.button_b4:
                    soundPool.play(sb7,1,1,0,0,1);
                    break;
                case R.id.button_b5:
                    soundPool.play(sa8,1,1,0,0,1);
                    break;
                case R.id.button_b6:
                    soundPool.play(sb8,1,1,0,0,1);
                    break;
                case R.id.button_b7:
                    soundPool.play(sa9,1,1,0,0,1);
                    break;
                case R.id.button_b8:
                    soundPool.play(sb9,1,1,0,0,1);
                    break;
                case R.id.button_b9:
                    soundPool.play(sa10,1,1,0,0,1);
                    break;
                case R.id.button_b10:
                    soundPool.play(sb10,1,1,0,0,1);
                    break;
            }
        }
    }
    protected void onDestroy() {
        super.onDestroy();
        soundPool.release();
        soundPool=null;
    }
}
