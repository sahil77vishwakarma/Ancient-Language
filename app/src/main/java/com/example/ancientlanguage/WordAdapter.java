package com.example.ancientlanguage;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.core.content.ContextCompat;

import java.util.ArrayList;

public class WordAdapter extends ArrayAdapter<Word> {

    private  int mcolorResourceId;
    public WordAdapter(Activity context, ArrayList<Word> words, int colorResourceId) {
        // Here, we initialize the ArrayAdapter's internal storage for the context and the list.
        // the second argument is used when the ArrayAdapter is populating a single TextView.
        // Because this is a custom adapter for two TextViews and an ImageView, the adapter is not
        // going to use this second argument, so it can be any value. Here, we used 0.
        super(context, 0, words);
        mcolorResourceId = colorResourceId;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Check if the existing view is being reused, otherwise inflate the view
        View listItemView = convertView;
        if(listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.list_item, parent, false);
        }
        // Set the theme color for the list item
        View textContainer = listItemView.findViewById(R.id.text_container);
        // Find the color that the resource ID maps to
        int color = ContextCompat.getColor(getContext(), mcolorResourceId);
        // Set the background color of the text container View
        textContainer.setBackgroundColor(color);

        // Get the {@link AndroidFlavor} object located at this position in the list
        Word currentWord = getItem(position);


        // Find the TextView in the list_item.xml layout with the ID version_name
        TextView miwok = (TextView) listItemView.findViewById(R.id.getMiwokTranslation);
        // Get the version name from the current AndroidFlavor object and
        // set this text on the name TextView
        miwok.setText(currentWord.getMiwokTranslation());


        // Find the TextView in the list_item.xml layout with the ID version_number
        TextView default_word = (TextView) listItemView.findViewById(R.id.getDefaultTranslation);
        // Get the version number from the current AndroidFlavor object and
        // set this text on the number TextView
        default_word.setText(currentWord.getDefaultTranslation());



        //find the image view in the layout file in id image
        ImageView imageView= (ImageView) listItemView.findViewById(R.id.image);

        //set the image view to the resource specified by the in the current word

        if(currentWord.hasImage()) {
            imageView.setImageResource(currentWord.getImageResourceId());
            //make sure that the view is visible
            imageView.setVisibility(View.VISIBLE);
        }
        else
        {
            //if we do invisible then still there we will space left on left side which we dont want so do Gone
            imageView.setVisibility(View.GONE);
        }


        // Return the whole list item layout (containing 2 TextViews and an ImageView)
        // so that it can be shown in the ListView
        return listItemView;
    }

   
}
