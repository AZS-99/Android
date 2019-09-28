package com.example.adam_3;

import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

public class Login_Activity extends AppCompatActivity {

    TextView text;
    Button homeButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        text = (TextView)findViewById(R.id.secondActivityText);
        homeButton = (Button)findViewById(R.id.homeButton);

        Intent userIntent = getIntent();

        text.setText(userIntent.getStringExtra("login")) ;


        homeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}
