package com.example.jerem.recipes_jaybson;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import org.w3c.dom.Text;

import java.util.LinkedList;

public class MainActivity extends AppCompatActivity {

    private RecyclerView mRecyclerView;
    private RecipeListAdapter mAdapter;
    Recipe mRecipe;
    private final LinkedList<String> mRecipeList = new LinkedList<>();
    TextView recipeName;
    TextView recipeDesc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //int listSize = DataProvider.getRecipes().size();

        //int recipeListSize = mRecipeList.size();
        //mRecipeList.addLast("Recipe #" + recipeListSize);
        //mRecyclerView.getAdapter().notifyItemInserted(recipeListSize);
        //mRecyclerView.smoothScrollToPosition(recipeListSize);

        //String recipeDesc = mRecipe.description;
       for (int i = 0; i < 5; i++){

           //mRecipeList.addLast("Recipe #" + i);
       }

        //Get a handle to the RecyclerView
        mRecyclerView = findViewById(R.id.recyclerview);
        //Create an adapter and supply the data to be displayed
        mAdapter = new RecipeListAdapter(this, mRecipeList);
        //Connect the adapter with the RecyclerView
        mRecyclerView.setAdapter(mAdapter);
        //Give the RecyclerView a default layout manager
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
    }
}
