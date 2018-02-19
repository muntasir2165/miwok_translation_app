package com.example.android.miwok;

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

import java.util.ArrayList;

/**
 * Created by Houst on 2018-01-29.
 */

public class WordAdapter extends ArrayAdapter<Word> {

    private int mBackgroundColorResourceId;

    public WordAdapter(@NonNull Context context, ArrayList<Word> words, int backgroundColorResourceId) {
        super(context, 0, words);
        this.mBackgroundColorResourceId = backgroundColorResourceId;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        // Check if the existing view is being reused, otherwise inflate the view
        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.list_item, parent, false);
        }

        // Get the {@link Word} object located at this position in the list
        Word currentWord = getItem(position);

        // Find the TextView in the list_item.xml layout with the ID miwok_text_view
        TextView miwokWordTextView = (TextView) listItemView.findViewById(R.id.miwok_text_view);
        // Get the miwok translation from the current Word object and
        // set this text on the miwok TextView
        miwokWordTextView.setText(currentWord.getMiwokTranslation());

        // Find the TextView in the list_item.xml layout with the ID english_text_view
        TextView englishTextView = (TextView) listItemView.findViewById(R.id.english_text_view);
        // Get the english translation from the current Word object and
        // set this text on the english TextView
        englishTextView.setText(currentWord.getDefaultTranslation());

        // set an ImageView with an image for a word if it references an image resource id
        // Find the ImageView in the list_item.xml layout with the ID image
        ImageView wordImage = (ImageView) listItemView.findViewById(R.id.image);
        if (currentWord.hasImage()) {
            // Get the image resource ID from the current Word object and
            // set the image on wordImage
            wordImage.setImageResource(currentWord.getImageResourceId());

            //make sure that the ImageView is visible in case it was hidden earlier
            wordImage.setVisibility(View.VISIBLE);
        } else {
            //hide the ImageView and the space occupied by it
            wordImage.setVisibility(View.GONE);
        }

        //set the background color of the list_item layout
        View listItemContainer = (View) listItemView.findViewById(R.id.list_item);
        //find the color that the color resource ID maps to
        int color = ContextCompat.getColor(getContext(), this.mBackgroundColorResourceId);
        listItemContainer.setBackgroundColor(color);


        // Return the whole list item layout (containing 2 TextViews and 1 ImageView)
        // so that it can be shown in the ListView
        return listItemView;
    }
}
