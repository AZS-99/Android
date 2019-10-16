package com.example.adam_assignment_2;

import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

public class Hint extends AppCompatActivity {
    Button showHintBtn, exitBtn;
    TextView hintTxt;
    @Override
    protected void onCreate(Bundle savedInstanceState) {


        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hint);

        showHintBtn = (Button)findViewById(R.id.showHintBtn);
        exitBtn = (Button)findViewById(R.id.exitBtn);
        hintTxt = (TextView)findViewById(R.id.hintTxt);

        showHintBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent hintIntent = getIntent();
                int orderOfCurrentQuestion = hintIntent.getIntExtra("orderOfCurrentQuestion", 0);
                QuizBook.hintUsed[orderOfCurrentQuestion] = true;
                hintTxt.setText(QuizBook.hints[orderOfCurrentQuestion]);
            }
        });

        exitBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}
