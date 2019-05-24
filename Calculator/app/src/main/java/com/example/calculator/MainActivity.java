package com.example.calculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText editText1, editText2;
    TextView tv;
    private Button b1, b2, b3, b4, b5, b6, b7, b8, b9, b10, b11, b12, b13,b14,b15,b16;
    private float num1,num2,addresult,subresult,multiresult;
    private boolean add=false,sub=false,multi=false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText1 = findViewById(R.id.inputId);
        tv = findViewById(R.id.outputId);
        b1 = findViewById(R.id.button1_id);
        b2 = findViewById(R.id.button2_id);
        b3 = findViewById(R.id.button3_id);
        b4 = findViewById(R.id.button4_id);
        b5 = findViewById(R.id.button5_id);
        b6 = findViewById(R.id.button6_id);
        b7 = findViewById(R.id.button7_id);
        b8 = findViewById(R.id.button8_id);
        b9 = findViewById(R.id.button9_id);
        b10 = findViewById(R.id.button10_id);
        b11 = findViewById(R.id.button11_id);
        b12 = findViewById(R.id.button12_id);
        b13 = findViewById(R.id.button13_id);
        b14 = findViewById(R.id.button14_id);
        b15 = findViewById(R.id.button15_id);
        b16 = findViewById(R.id.button16_id);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Toast.makeText(getApplicationContext(),"Hi this is 1",Toast.LENGTH_SHORT).show();
                editText1.setText(editText1.getText()+"1");
            }
        });
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                editText1.setText(editText1.getText()+"2");
            }
        });
        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                editText1.setText(editText1.getText()+"3");
            }
        });
        b4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                num1=Float.parseFloat(editText1.getText()+"");
                //Toast.makeText(getApplicationContext(),"Hi this is"+String.valueOf(num1),Toast.LENGTH_SHORT).show();
                editText1.getText().clear();
                add=true;
                multi=false;
                sub=false;
                buttonDisable();
            }
        });
        b5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Toast.makeText(getApplicationContext(),"Hi this is 1",Toast.LENGTH_SHORT).show();
                editText1.setText(editText1.getText()+"4");
            }
        });
        b6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                editText1.setText(editText1.getText()+"5");
            }
        });
        b7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                editText1.setText(editText1.getText()+"6");
            }
        });
        b8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                num1=Float.parseFloat(editText1.getText()+"");
                Toast.makeText(getApplicationContext(),"Hi this is"+String.valueOf(num1),Toast.LENGTH_SHORT).show();
                editText1.getText().clear();
                sub=true;
                add=false;
                multi=false;
                buttonDisable();
            }
        });
        b9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Toast.makeText(getApplicationContext(),"Hi this is 1",Toast.LENGTH_SHORT).show();
                editText1.setText(editText1.getText()+"7");
            }
        });
        b10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                editText1.setText(editText1.getText()+"8");
            }
        });
        b11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                editText1.setText(editText1.getText()+"9");
            }
        });

        b12.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                num1=Float.parseFloat(editText1.getText()+"");
                Toast.makeText(getApplicationContext(),"Hi this is"+String.valueOf(num1),Toast.LENGTH_SHORT).show();
                editText1.getText().clear();
                multi=true;
                add=false;
                sub=false;
                buttonDisable();
            }
        });
        b13.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                num2=Float.parseFloat(editText1.getText()+"");
                if(add) {
                    addresult = num1 + num2;
                    tv.setText(String.valueOf(addresult));
                }
                else if(sub)
                {
                    subresult = num1 - num2;
                    tv.setText(String.valueOf(subresult));
                }
                else if(multi)
                {
                    multiresult = num1 * num2;
                    tv.setText(String.valueOf(multiresult));
                }
                buttonDisable();

            }
        });
        b14.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                editText1.setText("");
                tv.setText("");
            }
        });
        b15.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String input=editText1.getText().toString();
                if(input.length()>0){
                    editText1.setText(input.substring(0,input.length()-1));
                }
                else
                {
                    Toast.makeText(getApplicationContext(),"No digit left.",Toast.LENGTH_SHORT).show();

                }
            }
        });
        b16.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                editText1.setText(editText1.getText()+".");
                buttonDisable();
            }
        });

    }

    private void buttonDisable()
    {
        b4.setEnabled(false);
        b8.setEnabled(false);
        b12.setEnabled(false);
        b13.setEnabled(false);
        b16.setEnabled(false);
    }
}
