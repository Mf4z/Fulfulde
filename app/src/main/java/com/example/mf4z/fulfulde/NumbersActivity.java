package com.example.mf4z.fulfulde;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class NumbersActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //Set layout to layout with a listview
        setContentView(R.layout.word_list);

        //Creating a list of words with an ArrayList of object Word
        ArrayList<Word> words = new ArrayList<>();

        //using nameOfList.add() to add objects to the list
        words.add(new Word("Go'o","One",R.drawable.number_one));
        words.add(new Word("Didi","Two",R.drawable.number_two));
        words.add(new Word("Tati","Three",R.drawable.number_three));
        words.add(new Word("Nai","Four",R.drawable.number_four));
        words.add(new Word("Jui","Five",R.drawable.number_five));
        words.add(new Word("Jego","Six",R.drawable.number_six));
        words.add(new Word("Jedidi","Seven",R.drawable.number_seven));
        words.add(new Word("Jetati","Eight",R.drawable.number_eight));
        words.add(new Word("Jenai","Nine",R.drawable.number_nine));
        words.add(new Word("Sappo","Ten",R.drawable.number_ten));


        //Instantiating a new object of WordAdapter adepter,takes in thr context,object list,theme color
        WordAdapter adapter = new WordAdapter(this,words,R.color.colorGreen);

        //Declaring and initialising the list view
        ListView listView = findViewById(R.id.list);

        //Setting the adapter to the listview
        listView.setAdapter(adapter);
    }
}
