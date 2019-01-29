package com.example.mf4z.fulfulde;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class FamilyMembersActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.word_list);


        ArrayList<Word> familyMembers = new ArrayList<>();

        familyMembers.add(new Word("Daada","Mother",R.drawable.family_mother));
        familyMembers.add(new Word("Baaba","Father",R.drawable.family_father));
        familyMembers.add(new Word("Kaaka","Grand parent",R.drawable.family_grandmother));
        familyMembers.add(new Word("Bandiko","Sibling",R.drawable.family_son));
        familyMembers.add(new Word("Kaawu","Maternal Uncle",R.drawable.family_older_brother));
        familyMembers.add(new Word("Bappa","Paternal Uncle",R.drawable.family_older_brother));
        familyMembers.add(new Word("Yapendo","Maternal Aunt",R.drawable.family_older_sister));
        familyMembers.add(new Word("Goggo","Paternal Aunt",R.drawable.family_older_sister));
        familyMembers.add(new Word("Adda","Elder Sister",R.drawable.family_older_sister));
        familyMembers.add(new Word("Hamma","Elder Brother",R.drawable.family_older_brother));



        WordAdapter adapter = new WordAdapter(this,familyMembers,R.color.colorRed);

        ListView listView = findViewById(R.id.list);

        listView.setAdapter(adapter);

    }
}
