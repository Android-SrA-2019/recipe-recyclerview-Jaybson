package com.example.jerem.recipelist;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

/**
 * Jeremy Johnson
 * Assignment 3 - Recipe List
 * March 22nd, 2019
 */

public class FullRecipeActivity extends AppCompatActivity {

    TextView name;
    TextView directions;
    TextView ingredients;
    ImageView img;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_full_recipe);

        //Set the name TextView to the nameTextView Id.
        name = findViewById(R.id.nameTextView);

        //Set the text of the name TextView to the "name" we stored on the OnClick
        name.setText(getIntent().getStringExtra("name"));

        //Set title equal to the Recipe Name
        setTitle(getIntent().getStringExtra("name"));

        //Set the ingredients TextView to the ingredients Id.
        ingredients = findViewById(R.id.ingredients);

        //Set the text of the ingredients TextView to the "ingredients" we stored on the OnClick
        ingredients.setText(getIntent().getStringExtra("ingredients") + "\n");

        //Set the directions TextView to the directions Id.
        directions = findViewById(R.id.directions);

        //Set the text of the directions TextView to the "directions" we stored on the OnClick
        directions.setText(getIntent().getStringExtra("directions"));

        //Set the img ImageView to the recipeImage Id.
        img = findViewById(R.id.recipeImage);

        //Get the image and place it in the img ImageView
        Picasso.get()
                .load(getIntent().getStringExtra("image"))
                .fit()
                .placeholder(R.drawable.ic_launcher_background)
                .error(R.drawable.ic_launcher_background)
                .into(img);
    }
}
