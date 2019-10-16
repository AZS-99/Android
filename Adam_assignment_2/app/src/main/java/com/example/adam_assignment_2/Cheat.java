package com.example.adam_assignment_2;

import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

public class Cheat extends AppCompatActivity {
    Button showAnswerBtn, exitBtn;
    TextView answerTxt;
    Intent cheatIntent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cheat);
        showAnswerBtn = (Button)findViewById(R.id.showAnswerBtn);
        exitBtn = (Button)findViewById(R.id.cheatExitBtn);
        answerTxt = (TextView)findViewById(R.id.answerTxt);

        exitBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        showAnswerBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cheatIntent = getIntent();
                int orderOfCurrentQuestion = cheatIntent.getIntExtra("orderOfCurrentQuestion", 0);
                answerTxt.setText(QuizBook.answers[orderOfCurrentQuestion]? "True" : "False");
                QuizBook.cheated[orderOfCurrentQuestion] = true;

            }
        });
    }
}
