package com.example.quizgame;

import android.os.Bundle;


import androidx.appcompat.app.AppCompatActivity;
import android.widget.Button;
import android.widget.TextView;
import android.content.Intent;
import androidx.annotation.Nullable;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;


public class Oyun extends AppCompatActivity {

    private TextView questionTextView;
    private Button answerButton ,option2Button, option3Button, option4Button;
    private int currentQuestionIndex = 0;
    private static final int CONTINUE_ACTIVITY_REQUEST_CODE = 1;


    DatabaseReference database = FirebaseDatabase.getInstance().getReference("Users");
    database.child(userId).setValue(stepData);



    private int correctAnswers = 0;
    private int incorrectAnswers = 0;
    private static final int TOTAL_QUESTIONS = 4;


    private String[] questions = {
            "1. Kozmik Dansçı\n"+
                    "\n"+
                    "Ben ses çıkarmadan dönerim ve dönerim,\n" +
                    "Kozmik bir balede, her zaman bulunurum.\n" +
                    "Ortaklarım parlak, ama ben görünmezim,\n" +
                    "Bu göksel sahnede, ben neyim?",
            "2. Zamansız Yolcu\n" +
                    "\n"+
                    "Ben çağlar boyunca yolculuk ederim, asla yaşlanmam,\n" +
                    "Hikayem ışıkta, anlatılmamış bir masal.\n" +
                    "Uzak geçmişten, gözlerine parıldarım,\n" +
                    "Ben neyim, bir yolcunun hayali?",
            "3. Sessiz Senfoni\n" +
                    "\n"+
                    "Boşlukta, bir senfoni çalar,\n" +
                    "Hiç ses yok, ama dalgalanır.\n" +
                    "Devlerin dansı, zarif ve yavaş,\n" +
                    "Ben neyim, rüzgarların esmediği yerde?",
            "4. Fısıldayan Rüzgarlar\n" +
                    "\n"+
                    "Ben kadim ışığın hikayelerini fısıldarım,\n" +
                    "Kozmik denizler boyunca uçarım.\n" +
                    "Bir kuş değilim, ama yüksekte süzülürüm,\n" +
                    "Ben neyim, gece gökyüzünde?"
    };

    private String[] answers = {
            "Kara Delik",
            "Yıldız",
            "Galaksi",
            "Kuyruklu Yıldız"
    };

    //SORULARRRIN YANLIŞ ŞIKLARI
    private List<String[]> optionNames = new ArrayList<>();
    {
        optionNames.add(new String[]{"Gezegen", "Yıldız", "Asteroit"});
        optionNames.add(new String[]{"Kuyruklu Yıldız", "Galaksi", "Nebula"});
        optionNames.add(new String[]{"Süpernova", "Kara Delik", "Asteroit Kuşağı"});
        optionNames.add(new String[]{"Gezegen", "Nebula", "Meteor"});
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_oyun);

        questionTextView = findViewById(R.id.questionTextView);


        answerButton = findViewById(R.id.answerButton);
        option2Button = findViewById(R.id.option2Button);
        option3Button = findViewById(R.id.option3Button);
        option4Button = findViewById(R.id.option4Button);

        setQuestion(currentQuestionIndex);

        answerButton.setOnClickListener(v -> handleOptionClick(answerButton));
        option2Button.setOnClickListener(v -> handleOptionClick(option2Button));
        option3Button.setOnClickListener(v -> handleOptionClick(option3Button));
        option4Button.setOnClickListener(v -> handleOptionClick(option4Button));


    }


    private String correctAnswer;
    private void setQuestion(int index) {

        // Soru metnini güncelle
        questionTextView.setText(questions[index]);


        //BU BÖLÜME KESİN ÇALIŞ/////////////////////////////////////////////////////////////////////////
        // Doğru cevabı ve diğer seçenekleri ekleyelim
        List<String> options = new ArrayList<>();
        options.add(answers[index]);


        //BU BÖLÜME KESİN ÇALIŞ/////////////////////////////////////////////////////////////////////////
        // Farklı seçenek isimlerini rastgele olarak ekleyelim
        String[] optionNamesForQuestion = optionNames.get(index);
        Collections.addAll(options, optionNamesForQuestion);

        // Seçenekleri rastgele karıştır
        Collections.shuffle(options);

        // Butonlara rastgele sıradaki seçenekleri ata
        answerButton.setText(options.get(0));
        option2Button.setText(options.get(1));
        option3Button.setText(options.get(2));
        option4Button.setText(options.get(3));

        // Doğru cevabı sakla
        correctAnswer = answers[index];
    }

    private void handleOptionClick(Button selectedOption) {
        String selectedAnswer = selectedOption.getText().toString();
        if (selectedAnswer.equalsIgnoreCase(correctAnswer)) {
            correctAnswers++;
        } else {
            incorrectAnswers++;
        }
        Intent intent = new Intent(Oyun.this, ContinueActivity.class);
        startActivityForResult(intent, CONTINUE_ACTIVITY_REQUEST_CODE);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == CONTINUE_ACTIVITY_REQUEST_CODE) {
            if (resultCode == RESULT_OK) {
                if (currentQuestionIndex + 1 < TOTAL_QUESTIONS) {
                    currentQuestionIndex++;
                    setQuestion(currentQuestionIndex);
                } else {
                    Intent intent = new Intent(Oyun.this, Sonuc.class);
                    intent.putExtra("correctAnswers", correctAnswers);
                    intent.putExtra("incorrectAnswers", incorrectAnswers);
                    startActivity(intent);
                    finish();
                }
            }
        }
    }
}

implementation 'org.tensorflow:tensorflow-lite:2.12.0'
implementation 'org.tensorflow:tensorflow-lite-support:0.3.1'
