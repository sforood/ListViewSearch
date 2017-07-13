package com.projects.example.listviewsearch;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

/**
 * Created by savannahforood on 4/23/17.
 */

public class RecipeAdapter extends ArrayAdapter<Recipe> {

    List<Recipe> originalData;
    List<Recipe> filteredData;
    Context context;
    int layoutResourceId;

    public RecipeAdapter(Context context, int layoutResourceId, List<Recipe> recipes) {
        super(context, layoutResourceId, recipes);
        this.context = context;
        this.layoutResourceId = layoutResourceId;
        this.originalData = recipes;
        this.filteredData = new ArrayList<Recipe>();
        this.filteredData.addAll(recipes);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View row = convertView;
        RecipeHolder holder;

        if(row == null) {
            LayoutInflater inflater = ((Activity)context).getLayoutInflater();
            row = inflater.inflate(layoutResourceId, parent, false);

            holder = new RecipeHolder();
            holder.name = (TextView) row.findViewById(R.id.name);
            holder.stars = (TextView)row.findViewById(R.id.star_rating);

            row.setTag(holder);
        } else {
            holder = (RecipeHolder)row.getTag();
        }

        Recipe recipe = originalData.get(position);

        if (recipe != null) {
            holder.name.setText(recipe.getName());
            holder.stars.setText(String.valueOf(recipe.getStars()));
        }

        return row;
    }

    static class RecipeHolder {
        TextView name;
        TextView stars;
    }

    public void filter(String charText) {
        charText = charText.toLowerCase();
        originalData.clear();
        if (charText.length() == 0) {
            originalData.addAll(filteredData);
        } else {
            for (Recipe recipe: filteredData) {
                if (recipe.getName().toLowerCase(Locale.getDefault()).contains(charText)) {
                    originalData.add(recipe);
                }
            }
        }
        notifyDataSetChanged();
    }
}
