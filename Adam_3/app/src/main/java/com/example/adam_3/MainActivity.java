package com.example.adam_3;

import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {
    Button usernameButton, passwordButton, login;
    EditText usernameEditText, passwordEditText;
    Intent mainActivityIntent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        usernameEditText = (EditText)findViewById(R.id.usernameEditText);
        usernameButton = (Button)findViewById(R.id.usernameButton);

        passwordButton = (Button)findViewById(R.id.passwordButton);
        passwordEditText = (EditText)findViewById(R.id.passwordEditText);

        login = (Button)findViewById(R.id.login);



        usernameButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mainActivityIntent = new Intent(MainActivity.this, User_Activity.class);
                mainActivityIntent.putExtra("username", "Username is: " + usernameEditText.getText().toString());
                startActivity(mainActivityIntent);

            }
        });

        passwordButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mainActivityIntent = new Intent(MainActivity.this, Password_Activity.class);
                mainActivityIntent.putExtra("password", "Password is: " + passwordEditText.getText().toString());
                startActivity(mainActivityIntent);
            }
        });

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mainActivityIntent = new Intent(MainActivity.this, Login_Activity.class);
                mainActivityIntent.putExtra("login", "Username is: " + usernameEditText.getText().toString()
                        + " \nPassword is: " + passwordEditText.getText().toString());
                startActivity(mainActivityIntent);
            }
        });
    }
}
