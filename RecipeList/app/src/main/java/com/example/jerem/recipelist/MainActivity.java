package com.example.jerem.recipelist;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.LinkedList;

/**
 * Jeremy Johnson
 * Assignment 3 - Recipe List
 * March 22nd, 2019
 */

public class MainActivity extends AppCompatActivity {

    private RecyclerView mRecyclerView;
    private RecipeListAdapter mAdapter;
    private LinkedList<Recipe> mRecipeList = new LinkedList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Get the recipes and store them into the mRecipeList LinkedList
        mRecipeList = DataProvider.getRecipes();

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