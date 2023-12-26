package com.arincdogansener.finalrecipeapp.interfaces

import com.arincdogansener.finalrecipeapp.entities.Category
import retrofit2.Call
import retrofit2.http.GET

interface GetDataService {
    @GET("categories.php")
    fun getCategoryList(): Call<Category>
}