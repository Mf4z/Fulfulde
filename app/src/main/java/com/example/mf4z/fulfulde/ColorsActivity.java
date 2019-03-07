package com.example.mf4z.fulfulde;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class ColorsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.word_list);


        ArrayList<Word> colors = new ArrayList<>();


        colors.add(new Word("Balejum","Black",R.drawable.color_black));
        colors.add(new Word("Danejum","White",R.drawable.color_white));
        colors.add(new Word("Bodejum","Red",R.drawable.color_red));
        colors.add(new Word("Haako Haako","Green",R.drawable.color_green));
        colors.add(new Word("Ndiyam Goro","Yellow",R.drawable.color_mustard_yellow));
        colors.add(new Word("Purum  Purum","Gray",R.drawable.color_gray));


        WordAdapter adapter = new WordAdapter(this,colors,R.color.colorOrange);

        ListView listView = findViewById(R.id.list);

        listView.setAdapter(adapter);
    }
}
