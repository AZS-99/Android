package com.example.adam_4;

import android.widget.*;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    ListView listView;
    GridView gridView;
    ArrayAdapter<String> arrayAdapter;
    List<String> list;
    String[] letters = {"A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R",
            "S", "T", "U", "V", "W", "X", "Y", "Z"};
    List<String> numbers;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        listView = (ListView)findViewById(R.id.simpleListView);
        arrayAdapter = new ArrayAdapter<String>(this, R.layout.activity_alpha_list_view, R.id.item, letters);
        listView.setAdapter(arrayAdapter);

        numbers = new ArrayList<>();
        for (int i = 5; i < 500; i+=5)
            numbers.add(Integer.toString(i));
        gridView = (GridView)findViewById(R.id.simpleGridView);
        arrayAdapter = new ArrayAdapter<String>(this, R.layout.activity_numeric_grid, R.id.numericItem, numbers);
        gridView.setAdapter(arrayAdapter);
    }
}
