package com.example.jerem.recipelist;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.LinkedList;

/**
 * Jeremy Johnson
 * Assignment 3 - Recipe List
 * March 22nd, 2019
 */

public class RecipeListAdapter extends RecyclerView.Adapter<RecipeListAdapter.RecipeViewHolder> {

    private final LinkedList<Recipe> mRecipeList;
    private LayoutInflater mInflater;
    Context context;

    public RecipeListAdapter(Context context, LinkedList<Recipe> recipeList){
        mInflater = LayoutInflater.from(context);
        this.mRecipeList = recipeList;
        this.context = context;
    }

    @Override
    public RecipeListAdapter.RecipeViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View mItemView = mInflater.inflate(R.layout.recipelist_item, parent, false);

        return new RecipeViewHolder(mItemView, this);
    }

    @Override
    public void onBindViewHolder(RecipeListAdapter.RecipeViewHolder holder, int position) {
        Recipe mCurrent = mRecipeList.get(position);
        holder.recipeNameItemView.setText(mCurrent.name);
        holder.recipeDescItemView.setText(mCurrent.description);
    }

    @Override
    public int getItemCount() {
        return mRecipeList.size();
    }

    class RecipeViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        public final TextView recipeNameItemView;
        public final TextView recipeDescItemView;
        final RecipeListAdapter mAdapter;

        public  RecipeViewHolder(View itemView, RecipeListAdapter adapter){
            super(itemView);
            recipeNameItemView = itemView.findViewById(R.id.recipe_name);
            recipeDescItemView = itemView.findViewById(R.id.recipe_description);
            this.mAdapter = adapter;
            itemView.setOnClickListener(this);
        }

        /**
         * OnClick that will happen when you click on a Cardview
         * @param view gets what view you clicked on.
         */
        @Override
        public void onClick(View view) {
            //Get the position of the item that was clicked
            int mPosition = getLayoutPosition();
            /*Notify the adapter that the data has changed so it can
            update the RecyclerView to display the data */
            mAdapter.notifyItemChanged(mPosition);

            //Create a new Intent that will open up the FullRecipeActivity
            Intent intent = new Intent(context, FullRecipeActivity.class);

            //Get the position of the clicked card name and get its value
            intent.putExtra("name", mRecipeList.get(mPosition).name);

            //Get the position of the clicked card directions and get its value
            intent.putExtra("directions", mRecipeList.get(mPosition).directions);

            //Get the position of the clicked card ingredients and get its value
            intent.putExtra("ingredients", mRecipeList.get(mPosition).ingredients);

            //Get the position of the clicked card image and get its value
            intent.putExtra("image", mRecipeList.get(mPosition).image);

            context.startActivity(intent);
        }
    }
}

