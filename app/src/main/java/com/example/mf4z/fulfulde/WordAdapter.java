package com.example.mf4z.fulfulde;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by mf4z on 9/12/18.
 */


//Class Extends ArrayAdapter to give ability to use methods of ArrayAdapter class
public class WordAdapter extends ArrayAdapter<Word> {


    //Instance variable for color resource id
    private int mColorResourceId;


    public WordAdapter(@NonNull Context context, @NonNull List<Word> words,int colorResId) {
        super(context, 0, words);

        //Resource color for background of color of list of words
        mColorResourceId = colorResId;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        View listItemView = convertView;

        if(listItemView == null){
            listItemView = LayoutInflater.from(getContext()).inflate(R.layout.list_item,parent,false);
        }

        Word curWord = getItem(position);

        TextView fulCol = listItemView.findViewById(R.id.fulfulde_tv);
        fulCol.setText(curWord.getFulfuldeTranslation());

        TextView defCol = listItemView.findViewById(R.id.default_tv);
        defCol.setText(curWord.getDefLangTranslation());

        ImageView defImg = listItemView.findViewById(R.id.image_iv);


        if (curWord.hasImage()) {
            defImg.setImageResource(curWord.getMimgId());
        }
        
        else {
            defImg.setVisibility(View.GONE);
        }


        // Set the theme color for the list item
        View textContainer = listItemView.findViewById(R.id.text_container);

        // Find the color that the resource ID maps to
        int color = ContextCompat.getColor(getContext(), mColorResourceId);

        // Set the background color of the text container View
        textContainer.setBackgroundColor(color);

        return listItemView;
    }
}
