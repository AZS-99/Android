package com.example.adam_4;

import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {
    TableLayout table;
    TableRow tr;
    TextView text;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        table = (TableLayout)findViewById(R.id.alphaTable);


        for(char i = 'A'; i <= 'Z'; ++i) {
            tr = new TableRow(this);
            text = new TextView(this);
            text.setTextSize(20);
            text.setText(Character.toString(i)); //setText accepts only strings ... not char (gave me hell)
            tr.addView(text);
            table.addView(tr);
        }






    }
}
