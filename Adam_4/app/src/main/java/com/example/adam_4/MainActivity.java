package com.example.adam_4;

import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {
    TableLayout alphaTable, numericTable;
    TableRow tr;
    TextView text;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        alphaTable = (TableLayout)findViewById(R.id.alphaTable);
        numericTable = (TableLayout) findViewById(R.id.numericTable);


        for(char i = 'A'; i <= 'Z'; ++i) {
            tr = new TableRow(this);
            text = new TextView(this);
            text.setTextSize(20);
            text.setText(Character.toString(i)); //setText accepts only strings ... not char (gave me hell)
            tr.addView(text);
            alphaTable.addView(tr);
        }

        for (int i = 1; i < 100; ++i) {
            tr = new TableRow(this);
            text = new TextView(this);
            text.setText(Integer.toString(i));
            tr.addView(text);
            numericTable.addView(tr);
        }


    }
}
