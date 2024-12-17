package com.mastercoding.luckynumber;

import android.content.Intent;
import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.mastercoding.luckynumber.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding viewBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        viewBinding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(viewBinding.getRoot());

        viewBinding.luckBtn.setOnClickListener(v->{

            String userName = viewBinding.nameEditTxt.getText().toString();

            Intent intent = new Intent(this, SecondActivity.class);
            // passing the name to second activity
            intent.putExtra("name",userName);
            startActivity(intent);


        });

    }
}