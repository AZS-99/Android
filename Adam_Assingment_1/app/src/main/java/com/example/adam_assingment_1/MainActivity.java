package com.example.adam_assingment_1;

import android.view.View;
import android.widget.*;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {
    Button bonjourBtn, hiBtn, colourBtn;
    TextView bonjourTxt, hiTxt;
    RadioButton selectedRadio;
    RadioGroup bonjourGrp, hiGrp;
    CheckBox red, green, blue;
    int selectedId;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bonjourBtn = (Button)findViewById(R.id.button6);
        hiBtn = (Button)findViewById(R.id.button5);
        colourBtn = (Button)findViewById(R.id.button7);
        bonjourTxt = (TextView) findViewById(R.id.textView4);
        hiTxt = (TextView)findViewById(R.id.textView5);
        bonjourGrp = (RadioGroup)findViewById(R.id.radioGrpBonjour);
        hiGrp = (RadioGroup)findViewById(R.id.radioGrpHi);
        colourBtn = (Button)findViewById(R.id.button7);
        red = (CheckBox)findViewById(R.id.checkBox);
        green = (CheckBox)findViewById(R.id.checkBox2);
        blue = (CheckBox)findViewById(R.id.checkBox3);


        bonjourBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                selectedId = bonjourGrp.getCheckedRadioButtonId();
                selectedRadio = (RadioButton)findViewById(selectedId);
                bonjourTxt.setText("Bonjour " + selectedRadio.getText());
                Toast.makeText(MainActivity.this, selectedRadio.getText(), Toast.LENGTH_LONG).show();
            }
        });


        hiBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                selectedId = hiGrp.getCheckedRadioButtonId();
                selectedRadio = (RadioButton)findViewById(selectedId);
                hiTxt.setText("Hi " + selectedRadio.getText());
                Toast.makeText(MainActivity.this, selectedRadio.getText(), Toast.LENGTH_LONG).show();
            }
        });

        hiGrp.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {

            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                selectedRadio = (RadioButton)findViewById(checkedId);
                Toast.makeText(MainActivity.this, selectedRadio.getText(), Toast.LENGTH_LONG).show();
            }
        });

        bonjourGrp.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                selectedRadio = (RadioButton)findViewById(checkedId);
                Toast.makeText(MainActivity.this, selectedRadio.getText(), Toast.LENGTH_LONG).show();
            }
        });

        colourBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String colours = "";
                if (red.isChecked())
                    colours += red.getText() + " ";
                if (green.isChecked())
                    colours += green.getText() + " ";
                if (blue.isChecked())
                    colours += blue.getText() + " ";
                Toast.makeText(MainActivity.this, colours, Toast.LENGTH_LONG).show();
            }
        });



    }
}
