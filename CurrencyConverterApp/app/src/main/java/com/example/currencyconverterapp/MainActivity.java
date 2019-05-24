package com.example.currencyconverterapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.InputType;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText et;
    private TextView tv1,tv2;
    private Button dollar,euro,pound,bdt;
    String s;
    float amount;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        et=findViewById(R.id.editText1);
        et.setInputType(InputType.TYPE_CLASS_NUMBER);
        tv1=findViewById(R.id.textView);
        tv2=findViewById(R.id.textView2);
        dollar=findViewById(R.id.button);
        euro=findViewById(R.id.button2);
        pound=findViewById(R.id.button3);
        bdt=findViewById(R.id.button4);

        dollar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                s=et.getText().toString();
                try {
                    amount = Float.parseFloat(s);
                } catch (NumberFormatException e) {
                    amount = 0;
                    Toast.makeText(getApplicationContext(), "Enter Amount", Toast.LENGTH_SHORT).show();
                }finally {
                    tv1.setText(Float.toString((float) (amount * .014)));
                }
                }
        });
        euro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                s = et.getText().toString();
                try {
                    amount = Float.parseFloat(s);
                } catch (NumberFormatException e) {
                    amount = 0;
                    Toast.makeText(getApplicationContext(), "Enter Amount", Toast.LENGTH_SHORT).show();
                }finally {
                    tv1.setText(Float.toString((float) (amount * .013)));
                }
                //Toast.makeText(getApplicationContext(), "Enter Amount", Toast.LENGTH_SHORT).show()
            }
        });
        pound.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                s=et.getText().toString();
                try {
                    amount = Float.parseFloat(s);
                } catch (NumberFormatException e) {
                    amount = 0;
                    Toast.makeText(getApplicationContext(), "Enter Amount", Toast.LENGTH_SHORT).show();
                }finally {
                    tv1.setText(Float.toString((float) (amount * .011)));
                }
            }
        });
        bdt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                s=et.getText().toString();
                try {
                    amount = Float.parseFloat(s);
                } catch (NumberFormatException e) {
                    amount = 0;
                    Toast.makeText(getApplicationContext(), "Enter Amount", Toast.LENGTH_SHORT).show();
                }finally {
                    tv1.setText(Float.toString((float) (amount * 1.21)));
                }
            }
        });

    }
}
