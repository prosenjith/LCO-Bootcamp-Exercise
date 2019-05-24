package com.example.spinearn;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.RotateAnimation;
import android.widget.Button;
import android.widget.ImageView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private Button spinButton;
    private ImageView spin;
    int first=0,last,count=0;
    Random r;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        spinButton=findViewById(R.id.button_id);
        spin=findViewById(R.id.spin_id);

        spinButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                spin();
                count++;
                if(count>0){
                    first=last;
                }
            }
        });
    }

    private void spin() {
        int pivotX=spin.getHeight()/2;
        int pivotY=spin.getWidth()/2;
        r=new Random();
        int a=r.nextInt(3600);
        last=a;
        Animation rotate=new RotateAnimation(first,last,pivotX,pivotY);
        rotate.setDuration(2000);
        rotate.setFillAfter(true);
        spin.startAnimation(rotate);
    }
}
