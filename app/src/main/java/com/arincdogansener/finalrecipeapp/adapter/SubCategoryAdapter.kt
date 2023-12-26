package com.arincdogansener.finalrecipeapp.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.arincdogansener.finalrecipeapp.R
import com.arincdogansener.finalrecipeapp.R.layout.item_rv_main_category
import com.arincdogansener.finalrecipeapp.entities.Recipies
import com.bumptech.glide.Glide
import android.widget.TextView
import com.arincdogansener.finalrecipeapp.R.layout.item_rv_sub_category

class SubCategoryAdapter:RecyclerView.Adapter<SubCategoryAdapter.RecipeViewHolder>() {
    var arrSubCategory = ArrayList<Recipies>()
    class RecipeViewHolder(view: View): RecyclerView.ViewHolder(view){
    }

    fun setData(arrData : List<Recipies>){
        arrSubCategory = arrData as ArrayList<Recipies>
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecipeViewHolder {
        return RecipeViewHolder(LayoutInflater.from(parent.context).inflate(item_rv_sub_category,parent,false))
    }

    override fun getItemCount(): Int {
        return arrSubCategory.size
    }

    override fun onBindViewHolder(holder: RecipeViewHolder, position: Int) {
        val dishNameTextView = holder.itemView.findViewById<TextView>(R.id.tv_dish_name)
        dishNameTextView.text = arrSubCategory[position].dishName
    }
}