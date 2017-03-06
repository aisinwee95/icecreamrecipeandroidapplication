package com.weeaisin.android.icecreamrecipe;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
import android.webkit.URLUtil;

import com.weeaisin.android.icecreamrecipe.Recipe;
import java.sql.Blob;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by AiLeng on 03-Mar-17.
 */

public class DatabaseHelper extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "Recipe.db";
    private static final String TABLE_RECIPES = "recipes";
    private static final String RECIPE_ID = "id";
    private static final String RECIPE_IMAGE = "image";
    private static final String RECIPE_TITLE = "title";
    private static final String RECIPE_DESCRIPTION = "description";


    private static final String[] COLUMNS  = {RECIPE_ID,RECIPE_IMAGE,RECIPE_TITLE,RECIPE_DESCRIPTION};



    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_TABLE_RECIPE = "CREATE TABLE "+ TABLE_RECIPES + "(" +
                      RECIPE_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                      RECIPE_IMAGE + " INTEGER, " +
                      RECIPE_TITLE + " TEXT, " +
                      RECIPE_DESCRIPTION + " TEXT " + ")";


        db.execSQL(CREATE_TABLE_RECIPE);
    }


    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // TODO Auto-generated method stub
        db.execSQL("DROP TABLE IF EXISTS" + TABLE_RECIPES);
        this.onCreate(db);
    }


    public void addRecipe(Recipe recipe) {

        //for logging
        Log.d("addRecipe", recipe.toString());

        // 1. get reference to writable DB
        SQLiteDatabase db = this.getWritableDatabase();


        ContentValues values = new ContentValues();
        values.put(RECIPE_IMAGE, recipe.getImage());
        values.put(RECIPE_TITLE, recipe.getTitle());
        values.put(RECIPE_DESCRIPTION, recipe.getDescription());


        // 3. insert
        db.insert(TABLE_RECIPES,
                null,
                values);

        // 4. close
        db.close();
    }

    public Recipe getRecipe(int id){

        SQLiteDatabase db = this.getReadableDatabase();

        // 2. build query
        Cursor cursor =
                db.query(TABLE_RECIPES, // a. table
                        COLUMNS, // b. column names
                        " id = ?", // c. selections
                        new String[] { String.valueOf(id) }, // d. selections args
                        null, // e. group by
                        null, // f. having
                        null, // g. order by
                        null); // h. limit

        // 3. if we got results get the first one
        if (cursor != null)
            cursor.moveToFirst();

        Recipe recipe = new Recipe();
        recipe.setId(Integer.parseInt(cursor.getString(0)));
        recipe.setImage(Integer.parseInt(cursor.getString(1)));
        recipe.setTitle(cursor.getString(2));
        recipe.setDescription(cursor.getString(3));


        //log
        Log.d("getRecipe("+id+")", recipe.toString());


        return recipe;
    }


    public List<Recipe> getAllRecipes() {
        List<Recipe> recipes = new LinkedList<Recipe>();

        // 1. build the query
        String query = "SELECT  * FROM " + TABLE_RECIPES;

        // 2. get reference to writable DB
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(query, null);


        Recipe recipe = null;
        if (cursor.moveToFirst()) {
            do {
                recipe = new Recipe();
                recipe.setId(Integer.parseInt(cursor.getString(0)));
                recipe.setImage(Integer.parseInt(cursor.getString(1)));
                recipe.setTitle(cursor.getString(2));
                recipe.setDescription(cursor.getString(3));



                recipes.add(recipe);
            } while (cursor.moveToNext());
        }

        Log.d("getAllRecipes()", recipes.toString());


        return recipes;
    }


    public int updateRecipe(Recipe recipe) {

        // 1. get reference to writable DB
        SQLiteDatabase db = this.getWritableDatabase();

        // 2. create ContentValues to add key "column"/value
        ContentValues values = new ContentValues();
        values.put("Title", recipe.getTitle());
        values.put("Ingredient", recipe.getDescription());
        values.put("Image", recipe.getImage());

        // 3. updating row
        int i = db.update(TABLE_RECIPES, //table
                values, // column/value
                RECIPE_ID+" = ?", // selections
                new String[] { String.valueOf(recipe.getId()) }); //selection args

        // 4. close
        db.close();

        return i;

    }

    public void deleteRecipe(Recipe recipe) {

        // 1. get reference to writable DB
        SQLiteDatabase db = this.getWritableDatabase();

        // 2. delete
        db.delete(TABLE_RECIPES, //table name
                RECIPE_ID+" = ?",  // selections
                new String[] { String.valueOf(recipe.getId()) }); //selections args

        // 3. close
        db.close();

        //log
        Log.d("deleteRecipe", recipe.toString());

    }

}

