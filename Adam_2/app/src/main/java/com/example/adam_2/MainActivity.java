package com.example.adam_2;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {
    Button usernameButton, passwordButton, userAndPassButton;
    EditText usernameEditText, passwordEditText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        usernameEditText = (EditText)findViewById(R.id.usernameEditText);
        usernameButton = (Button)findViewById(R.id.usernameButton);

        passwordButton = (Button)findViewById(R.id.passwordButton);
        passwordEditText = (EditText)findViewById(R.id.passwordEditText);

        userAndPassButton = (Button)findViewById(R.id.userAndPassButton);

        usernameButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                usernameButton.setText(usernameEditText.getText());
            }
        });

        passwordButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                passwordButton.setText(passwordEditText.getText());
            }
        });

        userAndPassButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                userAndPassButton.setText(usernameEditText.getText() + " AND " + passwordEditText.getText());
            }
        });
    }


}
