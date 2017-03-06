package com.weeaisin.android.icecreamrecipe;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewStub;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.ListView;


import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ViewStub stubGrid;
    private ViewStub stubList;
    private ListView listView;
    private GridView gridView;
    private ListViewAdapter listViewAdapter;
    private GridViewAdapter gridViewAdapter;
    private List<Recipe> recipeList;
    private int currentViewMode = 0;

    static final int VIEW_MODE_LISTVIEW = 0;
    static final int VIEW_MODE_GRIDVIEW = 1;

    // ArrayAdapter<String> adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        stubList = (ViewStub) findViewById(R.id.stub_list);
        stubGrid = (ViewStub) findViewById(R.id.stub_grid);

        stubList.inflate();
        stubGrid.inflate();

        listView = (ListView) findViewById(R.id.mylistview);
        gridView = (GridView) findViewById(R.id.mygridview);

        SharedPreferences sharedPreferences = getSharedPreferences("ViewMode", MODE_PRIVATE);
        currentViewMode = sharedPreferences.getInt("CurrentViewMode", VIEW_MODE_LISTVIEW);

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, android.R.id.text1);

        listView.setAdapter(adapter);
        gridView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {
                if (position == 0) {
                    Intent myIntent = new Intent(view.getContext(), Activity1.class);
                    startActivityForResult(myIntent, 0);
                }

                if (position == 1) {
                    Intent myIntent = new Intent(view.getContext(), Activity1.class);
                    startActivityForResult(myIntent, 0);
                }

                if (position == 2) {
                    Intent myIntent = new Intent(view.getContext(), Activity1.class);
                    startActivityForResult(myIntent, 0);
                }

                if (position == 3) {
                    Intent myIntent = new Intent(view.getContext(), Activity1.class);
                    startActivityForResult(myIntent, 0);
                }

                if (position == 4) {
                    Intent myIntent = new Intent(view.getContext(), Activity1.class);
                    startActivityForResult(myIntent, 0);
                }

                if (position == 5) {
                    Intent myIntent = new Intent(view.getContext(), Activity1.class);
                    startActivityForResult(myIntent, 0);
                }

                if (position == 6) {
                    Intent myIntent = new Intent(view.getContext(), Activity1.class);
                    startActivityForResult(myIntent, 0);
                }

                if (position == 7) {
                    Intent myIntent = new Intent(view.getContext(), Activity1.class);
                    startActivityForResult(myIntent, 0);
                }

                if (position == 8) {
                    Intent myIntent = new Intent(view.getContext(), Activity1.class);
                    startActivityForResult(myIntent, 0);
                }

                if (position == 9) {
                    Intent myIntent = new Intent(view.getContext(), Activity1.class);
                    startActivityForResult(myIntent, 0);
                }
            }
        });

        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {
                if (position == 0) {
                    Intent myIntent = new Intent(view.getContext(), Activity1.class);
                    startActivityForResult(myIntent, 0);
                }

                if (position == 1) {
                    Intent myIntent = new Intent(view.getContext(), Activity1.class);
                    startActivityForResult(myIntent, 0);
                }

                if (position == 2) {
                    Intent myIntent = new Intent(view.getContext(), Activity1.class);
                    startActivityForResult(myIntent, 0);
                }

                if (position == 3) {
                    Intent myIntent = new Intent(view.getContext(), Activity1.class);
                    startActivityForResult(myIntent, 0);
                }

                if (position == 4) {
                    Intent myIntent = new Intent(view.getContext(), Activity1.class);
                    startActivityForResult(myIntent, 0);
                }

                if (position == 5) {
                    Intent myIntent = new Intent(view.getContext(), Activity1.class);
                    startActivityForResult(myIntent, 0);
                }

                if (position == 6) {
                    Intent myIntent = new Intent(view.getContext(), Activity1.class);
                    startActivityForResult(myIntent, 0);
                }

                if (position == 7) {
                    Intent myIntent = new Intent(view.getContext(), Activity1.class);
                    startActivityForResult(myIntent, 0);
                }

                if (position == 8) {
                    Intent myIntent = new Intent(view.getContext(), Activity1.class);
                    startActivityForResult(myIntent, 0);
                }

                if (position == 9) {
                    Intent myIntent = new Intent(view.getContext(), Activity1.class);
                    startActivityForResult(myIntent, 0);
                }
            }
        });

        getRecipeList();
        switchView();
    }

    private void switchView() {

        if (VIEW_MODE_LISTVIEW == currentViewMode) {
            stubList.setVisibility(View.VISIBLE);
            stubGrid.setVisibility(View.GONE);
        }
        else {
            stubList.setVisibility(View.GONE);
            stubGrid.setVisibility(View.VISIBLE);
        }
        setAdapters();
    }

    private void setAdapters() {
        if (VIEW_MODE_LISTVIEW == currentViewMode) {
            listViewAdapter = new ListViewAdapter(this, R.layout.list_item, recipeList);
            listView.setAdapter(listViewAdapter);
        }
        else {
            gridViewAdapter = new GridViewAdapter(this, R.layout.grid_item, recipeList);
            gridView.setAdapter(gridViewAdapter);
        }
    }

    public List<Recipe> getRecipeList() {
        DatabaseHelper db = new DatabaseHelper(this);

        recipeList = db.getAllRecipes();

        db.addRecipe(new Recipe(R.drawable.bananapudding, "Banana Pudding Ice Cream", "Chunks of vanilla wafers and fresh bananas make this chilly treat taste like the real thing."));
        db.addRecipe(new Recipe(R.drawable.brownsugarcinnamon, "Brown Sugar Cinnamon Ice Cream", "A scoop of this richly-flavored ice cream is the perfect way to enhance a slice of pie this summer, so go ahead and indulge!"));
        db.addRecipe(new Recipe(R.drawable.butterpecan, "Butter Pecan Ice Cream", "Brown sugar and candied nuts give this butter pecan ice cream its mellow caramel goodness."));
        db.addRecipe(new Recipe(R.drawable.chocolatecherry, "Chocolate Cherry Ice Cream", "If the cherry on top is your favorite part of a sundae, then you've got to try this cherry and chocolate-centric flavor."));
        db.addRecipe(new Recipe(R.drawable.espressochocolatechip, "Espresso Chocolate Chip Ice Cream", "Coffee connoisseurs, skip the hot cup of joe this summer and cool off with this refreshing java dessert instead."));
        db.addRecipe(new Recipe(R.drawable.lavenderhoney, "Lavender Honey Ice Cream", "All gardeners should give this flavor a try. This yummy recipe will remind you of the many incredible scents found in your backyard."));
        db.addRecipe(new Recipe(R.drawable.lemonade, "Lemonade Ice Cream", "You'll feel utterly refreshed and ready for summer after indulging in this sweet and citrus-y treat!"));
        db.addRecipe(new Recipe(R.drawable.nochurnoreo, "No Churn Oreo Ice Cream", "Here's a delicious thought: by making this popular flavor at home, you're avoiding a ton of the extra sugar and preservatives that go into store bought kind."));
        db.addRecipe(new Recipe(R.drawable.peanutbuttercup, "Peanut Butter Cup Ice Cream", "Peanut butter and chocolate is one combination that always tastes great—especially in ice cream form."));
        db.addRecipe(new Recipe(R.drawable.redvelvetcereamwithmarshmallowswirl, "Red Velvet Ice Cream with Marshmallow Swirl", "If you're apart of the red velvet fan club, take a break from the cake and cupcakes, and give this dessert a try!"));


        return recipeList;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main,menu);

        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.item_menu_1:
                if (VIEW_MODE_LISTVIEW == currentViewMode) {
                    currentViewMode = VIEW_MODE_GRIDVIEW;
                }
                else {
                    currentViewMode = VIEW_MODE_LISTVIEW;
                }

                switchView();

                SharedPreferences sharedPreferences = getSharedPreferences("ViewMode", MODE_PRIVATE);
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putInt("currentMode", currentViewMode);
                editor.commit();

                break;
        }
        return true;
    }

}