package com.example.flashlightapp;

import android.Manifest;
import android.content.Context;
import android.content.DialogInterface;
import android.content.pm.PackageManager;
import android.hardware.Camera;
import android.hardware.camera2.CameraAccessException;
import android.hardware.camera2.CameraManager;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.security.Policy;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private Camera camera;
    private Camera.Parameters p;
    private Button btn;
    boolean isOn=false;
    private int buttonClick=0;
    boolean isFlushthere=false;
    private int CAMERA_PERMISSION_CODE=1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn=findViewById(R.id.button);
        isFlushthere=getApplicationContext().getPackageManager().hasSystemFeature(PackageManager.FEATURE_CAMERA_FLASH);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //buttonClick++;
                if (ContextCompat.checkSelfPermission(MainActivity.this,
                        Manifest.permission.CAMERA)
                        == PackageManager.PERMISSION_GRANTED) {
                    if(buttonClick>1)
                        useCamera();
                } else {
                    requestCameraPermission();
                }
            }
        });

    }
    private void useCamera(){
        if(isFlushthere){
            if(isOn){
                turnOffFlush();
            }else{
                turnOnFlush();
            }
        }
        else {
            Toast.makeText(getApplicationContext(), "Camera is not there.", Toast.LENGTH_SHORT).show();
        }
    }

    private void turnOnFlush() {
        CameraManager cameraManager = (CameraManager) getSystemService(Context.CAMERA_SERVICE);

        try {
            String cameraId = cameraManager.getCameraIdList()[0];
            cameraManager.setTorchMode(cameraId, false);
            isOn = false;
            //imageFlashlight.setImageResource(R.drawable.btn_switch_off);
        } catch (CameraAccessException e) {
        }
    }

    private void turnOffFlush(){
        if (camera!= null){
            camera.release();        // release the camera for other applications
            camera = null;
        }
    }
    private void requestCameraPermission() {
        if (ActivityCompat.shouldShowRequestPermissionRationale(MainActivity.this,
                Manifest.permission.CAMERA))
        {
            new AlertDialog.Builder(this)
                    .setTitle("Permissions needed")
                    .setMessage("This Permission is needed for this and that.")
                    .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            ActivityCompat.requestPermissions(MainActivity.this,
                                    new String[]{Manifest.permission.CAMERA},
                                    CAMERA_PERMISSION_CODE);
                        }
                    })
                    .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            dialog.dismiss();
                        }
                    }).create().show();
        }
        else {
            ActivityCompat.requestPermissions(this,
                    new String[]{Manifest.permission.CAMERA},
                    CAMERA_PERMISSION_CODE);
        }
    }

    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        if(requestCode==CAMERA_PERMISSION_CODE)
        {
            //Toast.makeText(this,"Permission Granted",Toast.LENGTH_SHORT).show();
            if(grantResults.length > 0 && grantResults[0]==PackageManager.PERMISSION_GRANTED)
                if(buttonClick>1)
                    useCamera();
            else
                Toast.makeText(this,"Permission Denied",Toast.LENGTH_SHORT).show();

        }
    }


}
