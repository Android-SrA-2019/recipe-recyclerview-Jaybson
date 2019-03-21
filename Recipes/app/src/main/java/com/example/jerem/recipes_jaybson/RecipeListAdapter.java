package com.example.jerem.recipes_jaybson;

import android.content.Context;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.LinkedList;

public class RecipeListAdapter extends RecyclerView.Adapter<RecipeListAdapter.RecipeViewHolder> {


    private final LinkedList<String> mRecipeList;
    private LayoutInflater mInflater;

    public RecipeListAdapter(Context context, LinkedList<String> recipeList){
        mInflater = LayoutInflater.from(context);
        this.mRecipeList = recipeList;
    }

    @Override
    public RecipeListAdapter.RecipeViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View mItemView = mInflater.inflate(R.layout.recipelist_item, parent, false);

        return new RecipeViewHolder(mItemView, this);
    }

    @Override
    public void onBindViewHolder(RecipeListAdapter.RecipeViewHolder holder, int position) {
        String mCurrent = mRecipeList.get(position);
        holder.recipeNameItemView.setText(mCurrent);
        holder.recipeDescItemView.setText(mCurrent);
    }

    @Override
    public int getItemCount() {
        return mRecipeList.size();
    }

    class RecipeViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        public final TextView recipeNameItemView;
        public final TextView recipeDescItemView;
        public final CardView cardItemView;
        final RecipeListAdapter mAdapter;

        public  RecipeViewHolder(View itemView, RecipeListAdapter adapter){
            super(itemView);
            recipeNameItemView = itemView.findViewById(R.id.recipe_name);
            recipeDescItemView = itemView.findViewById(R.id.recipe_description);
            cardItemView = itemView.findViewById(R.id.cardview);
            this.mAdapter = adapter;
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            //Get the position of the item that was clicked
            int mPosition = getLayoutPosition();
            //Use that to access the affected item in mWordList
            String element = mRecipeList.get(mPosition);
            //Change the word in the mWordList
            mRecipeList.set(mPosition, "Clicked! " + element);
            //Notify the adapter that the data has changed so it can
            //update the RecyclerView to display the data
            mAdapter.notifyDataSetChanged();
        }
    }
}
