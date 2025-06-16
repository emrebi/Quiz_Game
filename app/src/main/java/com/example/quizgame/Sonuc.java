package com.example.quizgame;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import android.content.Intent;


import androidx.appcompat.app.AppCompatActivity;


public class Sonuc extends AppCompatActivity {


    private TextView resultTextView;
    private Button restartButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sonuc);


        resultTextView = findViewById(R.id.resultTextView);
        restartButton = findViewById(R.id.restartButton);

        Intent intent = getIntent();
        int correctAnswers = intent.getIntExtra("correctAnswers", 0);
        int incorrectAnswers = intent.getIntExtra("incorrectAnswers", 0);

        String resultText = "Doğru cevaplar: " + correctAnswers + "\n" +
                "Yanlış cevaplar: " + incorrectAnswers;
        resultTextView.setText(resultText);

        restartButton.setOnClickListener(v -> {
            Intent restartIntent = new Intent(Sonuc.this, MainActivity.class);
            startActivity(restartIntent);
            finish();




        });
    }
}










