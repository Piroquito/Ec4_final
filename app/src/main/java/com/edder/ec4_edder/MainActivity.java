package com.edder.ec4_edder;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.edder.ec4_edder.databinding.ActivityMainBinding;


    public class MainActivity extends AppCompatActivity {
        //private Button btnGetStarted;
        private ActivityMainBinding binding;
        private SharedPreferences sharedPreferences;


        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            binding= ActivityMainBinding.inflate(getLayoutInflater());
            setContentView(binding.getRoot());
            binding.btnGetStarted.setOnClickListener(v->{
                Intent intent = new Intent(this, LoginActivity.class);
                startActivity(intent);
                finish();
            });


        }
    }