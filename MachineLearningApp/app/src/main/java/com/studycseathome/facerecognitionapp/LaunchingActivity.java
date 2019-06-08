package com.studycseathome.facerecognitionapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class LaunchingActivity extends AppCompatActivity {

    private Button faceButton,barcodeButton,textRecognitionButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_launching);

        faceButton=findViewById(R.id.faceDetectButton);
        barcodeButton=findViewById(R.id.barCodeScanId);
        textRecognitionButton=findViewById(R.id.textRecognizeBtnId);

        faceButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(LaunchingActivity.this,MainActivity.class);
                startActivity(i);
            }
        });

        barcodeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(LaunchingActivity.this,BarCodeActivity.class);
                startActivity(i);
            }
        });
        textRecognitionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(LaunchingActivity.this,TextRecognitionActivity.class);
                startActivity(i);
            }
        });
    }
}
