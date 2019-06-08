package com.studycseathome.facerecognitionapp;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Point;
import android.graphics.Rect;
import android.provider.MediaStore;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.ml.vision.FirebaseVision;
import com.google.firebase.ml.vision.barcode.FirebaseVisionBarcode;
import com.google.firebase.ml.vision.barcode.FirebaseVisionBarcodeDetector;
import com.google.firebase.ml.vision.barcode.FirebaseVisionBarcodeDetectorOptions;
import com.google.firebase.ml.vision.common.FirebaseVisionImage;

import java.util.List;

public class BarCodeActivity extends AppCompatActivity {

    private static final int REQUEST_IMAGE_CAPTURE = 1;
    private Button button,galleryButton,detectButton;
    private ImageView imageView;
    private Bitmap bitmap;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bar_code);

        button=findViewById(R.id.buttonId);
        galleryButton=findViewById(R.id.button2Id);
        detectButton=findViewById(R.id.recognizeTextButtonId);
        imageView=findViewById(R.id.ImageViewId);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent takePictureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                if (takePictureIntent.resolveActivity(getPackageManager()) != null) {
                    startActivityForResult(takePictureIntent, REQUEST_IMAGE_CAPTURE);
                }
            }
        });

        detectButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(bitmap==null){
                    Toast.makeText(getApplicationContext(),"No Image Selected yet.",Toast.LENGTH_SHORT).show();
                    return;
                }
                FirebaseVisionImage image=FirebaseVisionImage.fromBitmap(bitmap);
                scanBarcodes(image);
            }
        });
    }

    protected void onActivityResult(int requestCode, int resultCode, Intent data) {

        if(resultCode == RESULT_OK){
            switch (requestCode){
                case REQUEST_IMAGE_CAPTURE:
                    Bundle extras = data.getExtras();
                    bitmap = (Bitmap) extras.get("data");
                    imageView.setImageBitmap(bitmap);
            }
        }
    }

    private void scanBarcodes(FirebaseVisionImage image) {
        // [START set_detector_options]
        FirebaseVisionBarcodeDetectorOptions options =
                new FirebaseVisionBarcodeDetectorOptions.Builder()
                        .setBarcodeFormats(
                                FirebaseVisionBarcode.FORMAT_QR_CODE,
                                FirebaseVisionBarcode.FORMAT_AZTEC)
                        .build();
        // [END set_detector_options]

        // [START get_detector]
        FirebaseVisionBarcodeDetector detector = FirebaseVision.getInstance()
                .getVisionBarcodeDetector(options);
        // Or, to specify the formats to recognize:
        // FirebaseVisionBarcodeDetector detector = FirebaseVision.getInstance()
        //        .getVisionBarcodeDetector(options);
        // [END get_detector]

        // [START run_detector]
        Task<List<FirebaseVisionBarcode>> result = detector.detectInImage(image)
                .addOnSuccessListener(new OnSuccessListener<List<FirebaseVisionBarcode>>() {
                    @Override
                    public void onSuccess(List<FirebaseVisionBarcode> barcodes) {
                        // Task completed successfully
                        // [START_EXCLUDE]
                        // [START get_barcodes]
                        processBarcode(barcodes);
                        // [END get_barcodes]
                        // [END_EXCLUDE]
                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        // Task failed with an exception
                        // ...
                        Log.d("shuvo","Barcode Detection Failed.");
                    }
                });
        // [END run_detector]
    }
    private void processBarcode(List<FirebaseVisionBarcode> barcodes){
        for (FirebaseVisionBarcode barcode: barcodes) {
            Rect bounds = barcode.getBoundingBox();
            Point[] corners = barcode.getCornerPoints();

            String rawValue = barcode.getRawValue();
            Log.d("shuvo","rawValue is : "+rawValue);

            int valueType = barcode.getValueType();
            // See API reference for complete list of supported types
            switch (valueType) {
                case FirebaseVisionBarcode.TYPE_WIFI:
                    String ssid = barcode.getWifi().getSsid();
                    String password = barcode.getWifi().getPassword();
                    int type = barcode.getWifi().getEncryptionType();
                    Log.d("shuvo","ssid : "+ssid + "\npassword : "+password
                    +"\ntype : "+type);
                    break;
                case FirebaseVisionBarcode.TYPE_URL:
                    String title = barcode.getUrl().getTitle();
                    String url = barcode.getUrl().getUrl();
                    Log.d("shuvo","title : "+title + "\nurl : "+url);
                    break;
            }
        }
    }

}
