package com.projects.example.listviewsearch;

import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    List<Recipe> mRecipeList;
    RecipeAdapter mRecipeAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mRecipeList = new ArrayList<Recipe>();

        final LinearLayout mSearchView = (LinearLayout) findViewById(R.id.search_view_container);
        final EditText mSearchInput = (EditText) mSearchView.findViewById(R.id.search_input);
        mSearchInput.addTextChangedListener(new TextWatcher() {
            @Override
            public void afterTextChanged(Editable s) {
            }

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                String searchInput = mSearchInput.getText().toString().toLowerCase();
                mRecipeAdapter.filter(searchInput);
            }
        });

        ListView recipeListView = (ListView) findViewById(R.id.recipe_list_view);

        Recipe cherryCobbler = new Recipe(Uri.parse("http://allrecipes.com/recipe/72815/fresh-cherry-cobbler"), "Cherry Cobbler", 4.3);
        Recipe beefStroganoff = new Recipe(Uri.parse("http://www.food.com/recipe/best-beef-stroganoff-73922"), "Beef Stroganoff", 4.5);
        Recipe roseLatte = new Recipe(Uri.parse("http://localmilkblog.com/2016/07/cardamom-rose-iced-latte-japanese-ice-coffee.html"), "Cardamom + Rose Iced Latte ", 3.5);
        Recipe vealSaltimbocca = new Recipe(Uri.parse("http://www.foodnetwork.com/recipes/rachael-ray/veal-saltimbocca-recipe-1941547"), "Veal Saltimbocca", 4.0);

        mRecipeList.add(cherryCobbler);
        mRecipeList.add(beefStroganoff);
        mRecipeList.add(roseLatte);
        mRecipeList.add(vealSaltimbocca);

        mRecipeAdapter = new RecipeAdapter(this, R.layout.recipe_row_item, mRecipeList);
        recipeListView.setAdapter(mRecipeAdapter);
    }
}
