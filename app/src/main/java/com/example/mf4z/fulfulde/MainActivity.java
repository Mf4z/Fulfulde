package com.example.mf4z.fulfulde;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView number,color,family,phrase;

        number = findViewById(R.id.numbersTv);
        color = findViewById(R.id.colorsTv);
        family = findViewById(R.id.familyTv);
        phrase = findViewById(R.id.phrasesTv);


        number.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this,NumbersActivity.class);
                startActivity(i);
            }
        });



        color.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this,ColorsActivity.class);
                startActivity(i);
            }
        });



        family.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this,FamilyMembersActivity.class);
                startActivity(i);
            }
        });



        phrase.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this,PhrasesActivity.class);
                startActivity(i);
            }
        });



    }

}
