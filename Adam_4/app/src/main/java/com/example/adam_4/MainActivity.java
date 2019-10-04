package com.example.adam_4;

import android.graphics.Color;
import android.text.Layout;
import android.view.Gravity;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import org.w3c.dom.Text;

import static android.widget.ListPopupWindow.MATCH_PARENT;

public class MainActivity extends AppCompatActivity {
    TableLayout alphaTable, numericTable;
    TableRow tr;
    LinearLayout layout;

    TextView text1, text2, text3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        alphaTable = (TableLayout)findViewById(R.id.alphaTable);
        numericTable = (TableLayout) findViewById(R.id.numericTable);


        for(char i = 'A'; i <= 'Z'; ++i) {
            tr = new TableRow(this);

            text1 = new TextView(this);
            text1.setTextSize(20);
            text1.setText(Character.toString(i)); //setText accepts only strings ... not char (gave me hell)
            text1.setTextColor(Color.BLUE);

            tr.addView(text1);
            alphaTable.addView(tr);
        }

        for (int i = 5; i < 500; i+=5) {
            tr = new TableRow(this);

            text1 = new TextView(this);
            text1.setText(Integer.toString(i));
            text1.setTextColor(Color.BLUE);

            tr.addView(text1);
            numericTable.addView(tr);
        }


    }
}
