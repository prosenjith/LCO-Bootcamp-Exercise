package com.studycseathome.androiddatabinding;

import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.studycseathome.androiddatabinding.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        binding.tvHeading.setText("Welcome to Prosenjith Home.");
        binding.tvSubheading.setText("Welcome to this Android Tutorial on DataBinding");
    }
}
