package com.example.adam_assignment_2;

import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends AppCompatActivity {
    Button trueBtn, falseBtn, nxtBtn, prevBtn, hintBtn, cheatBtn;
    TextView currentQuestionTxt, numOfCompletedQuestionsTxt, totalMarksTxt;
    int orderOfCurrentQuestion, marks, numOfCompletedQuestions;
    Intent mainActivityIntent;
    List<Boolean> answered;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        orderOfCurrentQuestion = marks = numOfCompletedQuestions = 0;
        trueBtn = (Button)findViewById(R.id.button2);
        falseBtn = (Button)findViewById(R.id.button);
        nxtBtn = (Button)findViewById(R.id.nxtBtn);
        prevBtn = (Button)findViewById(R.id.prevBtn);
        hintBtn = (Button)findViewById(R.id.hintBtn);
        cheatBtn = (Button)findViewById(R.id.cheatBtn);
        currentQuestionTxt = (TextView)findViewById(R.id.questionTxt);
        totalMarksTxt = (TextView)findViewById(R.id.totalMarks);
        numOfCompletedQuestionsTxt = (TextView)findViewById(R.id.numOfCompletedQuestions);


        answered = new ArrayList<>();
        for (int i = 0; i < 6; ++i)
            answered.add(false);

        currentQuestionTxt.setText(orderOfCurrentQuestion + 1 + ". " + QuizBook.questions[orderOfCurrentQuestion]);

        prevBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                --orderOfCurrentQuestion;
                if (orderOfCurrentQuestion < 0)
                    orderOfCurrentQuestion = 5;
                currentQuestionTxt.setText(orderOfCurrentQuestion + 1 + ". " + QuizBook.questions[orderOfCurrentQuestion]);
            }
        });

        nxtBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ++orderOfCurrentQuestion;
                orderOfCurrentQuestion = orderOfCurrentQuestion % 6;
                currentQuestionTxt.setText(orderOfCurrentQuestion + 1 + ". " + QuizBook.questions[orderOfCurrentQuestion]);
            }
        });

        trueBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!answered.get(orderOfCurrentQuestion)) {
                    if (QuizBook.answers[orderOfCurrentQuestion]) {
                        if(QuizBook.cheated[orderOfCurrentQuestion])
                            Toast.makeText(MainActivity.this, "Cheating is Wrong!", Toast.LENGTH_SHORT).show();
                        else if (QuizBook.hintUsed[orderOfCurrentQuestion]) {
                            marks += 1;
                            Toast.makeText(MainActivity.this, "+1 Marks", Toast.LENGTH_SHORT).show();
                        } else {
                            marks += 2;
                            Toast.makeText(MainActivity.this, "+2 Marks", Toast.LENGTH_SHORT).show();
                        }
                    }else {
                        if (QuizBook.hintUsed[orderOfCurrentQuestion]) {
                            marks -= 2;
                            Toast.makeText(MainActivity.this, "-2 Marks", Toast.LENGTH_SHORT).show();
                        } else {
                            marks -= 1;
                            Toast.makeText(MainActivity.this, "-1 Marks", Toast.LENGTH_SHORT).show();
                        }

                    }
                    numOfCompletedQuestions++;

                    numOfCompletedQuestionsTxt.setText("Questions Completed " + numOfCompletedQuestions);
                    totalMarksTxt.setText("Total Marks " + Integer.toString(marks));
                    answered.set(orderOfCurrentQuestion, true);
                } else {
                    Toast.makeText(MainActivity.this, "Question Completed!", Toast.LENGTH_SHORT).show();
                }


            }
        });

        falseBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!answered.get(orderOfCurrentQuestion)) {
                    if (!QuizBook.answers[orderOfCurrentQuestion]) {
                        if(QuizBook.cheated[orderOfCurrentQuestion])
                            Toast.makeText(MainActivity.this, "Cheating is Wrong!", Toast.LENGTH_SHORT).show();
                        else if (QuizBook.hintUsed[orderOfCurrentQuestion]) {
                            marks += 1;
                            Toast.makeText(MainActivity.this, "+1 Marks", Toast.LENGTH_SHORT).show();
                        } else {
                            marks += 2;
                            Toast.makeText(MainActivity.this, "+2 Marks", Toast.LENGTH_SHORT).show();
                        }
                    }
                    else {
                        if (QuizBook.hintUsed[orderOfCurrentQuestion]) {
                            marks -= 2;
                            Toast.makeText(MainActivity.this, "-2 Marks", Toast.LENGTH_SHORT).show();
                        } else {
                            marks -= 1;
                            Toast.makeText(MainActivity.this, "-1 Marks", Toast.LENGTH_SHORT).show();
                        }

                    }


                    numOfCompletedQuestions++;

                    numOfCompletedQuestionsTxt.setText("Questions Completed " + Integer.toString(numOfCompletedQuestions));
                    totalMarksTxt.setText("Total Marks " + Integer.toString(marks));
                    answered.set(orderOfCurrentQuestion, true);

                }
                else
                    Toast.makeText(MainActivity.this, "Question Completed!", Toast.LENGTH_SHORT).show();
            }
        });

        hintBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mainActivityIntent = new Intent(MainActivity.this, Hint.class);
                mainActivityIntent.putExtra("orderOfCurrentQuestion", orderOfCurrentQuestion);
                startActivity(mainActivityIntent);
            }
        });

        cheatBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mainActivityIntent = new Intent(MainActivity.this, Cheat.class);
                mainActivityIntent.putExtra("orderOfCurrentQuestion", orderOfCurrentQuestion);
                startActivity(mainActivityIntent);
            }
        });
    }
}
