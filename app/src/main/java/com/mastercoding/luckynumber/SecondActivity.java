package com.mastercoding.luckynumber;

import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;

import com.mastercoding.luckynumber.databinding.ActivitySecondBinding;

import java.util.Random;


public class SecondActivity extends AppCompatActivity {

    private ActivitySecondBinding viewBinding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        viewBinding = ActivitySecondBinding.inflate(getLayoutInflater());
        setContentView(viewBinding.getRoot());

        //Receiving the data from Main Activity
        Intent intent = getIntent();
        String userName = intent.getStringExtra("name");

        //Generating random number
        int random_num =generateRandomNumbers();
        viewBinding.resultTxt.setText(String.valueOf(random_num));

        viewBinding.shareBtn.setOnClickListener(v->{
            shareData(userName, random_num);
        });


    }

    private void shareData(String userName, int randomNum) {

        //Implicit intent
        Intent intent = new Intent(Intent.ACTION_SEND);
        intent.setType("text/plain");

        //Additional info
        intent.putExtra(Intent.EXTRA_SUBJECT, userName + "got lucky today");
        intent.putExtra(Intent.EXTRA_TEXT, "His luck number is: " + randomNum);
        startActivity(Intent.createChooser(intent, "Choose a platform"));
    }

    public int generateRandomNumbers(){

        Random random = new Random();
        int upperLimit = 1000;
        int randomNumberGenerated = random.nextInt(upperLimit);
        return randomNumberGenerated;

    }
}