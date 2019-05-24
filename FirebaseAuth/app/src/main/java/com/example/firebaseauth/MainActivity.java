package com.example.firebaseauth;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;

public class MainActivity extends AppCompatActivity {

    private Button logoutBtn;
    private TextView tv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        logoutBtn=findViewById(R.id.logout_btn);
        tv=findViewById(R.id.textView);
        logoutBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                logout();
            }
        });
        Intent i=getIntent();
        String mail=i.getExtras().getString("email");
        tv.setText(mail);
    }
    private void logout() {
        FirebaseAuth.getInstance().signOut();
        Intent i=new Intent(MainActivity.this,LoginActivity.class);
        startActivity(i);
        finish();
    }
}
