package com.arincdogansener.finalrecipeapp.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.arincdogansener.finalrecipeapp.entities.Category
import com.arincdogansener.finalrecipeapp.entities.CategoryItems
import com.arincdogansener.finalrecipeapp.entities.Recipies


@Dao
interface RecipeDao {

    @Query("SELECT * FROM category ORDER BY id DESC")
    suspend fun getAllCategory(): List<CategoryItems>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertCategory(categoryItems: CategoryItems)

    @Query("DELETE FROM categoryitems")
    suspend fun clearDb()
}