package com.example.mf4z.fulfulde;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class PhrasesActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.word_list);


        ArrayList<Word> phrases = new ArrayList<>();


        phrases.add(new Word("Jam bandu na?","Good morning"));
        phrases.add(new Word("Noi chomri?","How are you?"));
        phrases.add(new Word("Noi sare?","How is home?"));
        phrases.add(new Word("Noi iyalu ma?","How is your family?"));
        phrases.add(new Word("Jam Alhamdulillah","Good Alhamdulillah"));
        phrases.add(new Word("Mi hofni ma","I greet you"));
        phrases.add(new Word("Sai yeso","See you later"));
        phrases.add(new Word("Sai jango","Till tomorrow"));
        phrases.add(new Word("Sai fajiri","Good night"));
        phrases.add(new Word("Jam Wala","Good night"));
        phrases.add(new Word("Noi inde ma?","What is your name?"));
        phrases.add(new Word("Inde am [inde]","My name is [name]"));
        phrases.add(new Word("Hatoi a yahata?","Where are you going?"));
        phrases.add(new Word("Mi do yaha [babal]","I am going to [place]"));



         WordAdapter adapter = new WordAdapter(this,phrases,R.color.colorIndigo);

        ListView listView = findViewById(R.id.list);

        listView.setAdapter(adapter);
    }
}
