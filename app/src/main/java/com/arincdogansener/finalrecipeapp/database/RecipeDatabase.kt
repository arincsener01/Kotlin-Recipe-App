package com.arincdogansener.finalrecipeapp.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.arincdogansener.finalrecipeapp.dao.RecipeDao
import com.arincdogansener.finalrecipeapp.entities.Category
import com.arincdogansener.finalrecipeapp.entities.CategoryItems
import com.arincdogansener.finalrecipeapp.entities.Recipies
import com.arincdogansener.finalrecipeapp.entities.converter.CategoryListConverter

@Database(entities = [Recipies::class, CategoryItems::class, Category::class, CategoryListConverter::class], version = 1, exportSchema = false)
abstract class RecipeDatabase: RoomDatabase() {

    companion object{

        var recipeDatabase: RecipeDatabase? = null

        @Synchronized
        fun getDatabase(context: Context): RecipeDatabase{
            if(recipeDatabase == null){
                recipeDatabase = Room.databaseBuilder(
                    context,
                    RecipeDatabase::class.java,
                    "recipe.db"
                ).build()
            }
            return recipeDatabase!!
        }
    }

    abstract fun recipeDao():RecipeDao
}