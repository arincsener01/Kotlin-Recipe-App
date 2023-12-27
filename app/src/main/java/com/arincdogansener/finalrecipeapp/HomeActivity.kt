package com.arincdogansener.finalrecipeapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.arincdogansener.finalrecipeapp.adapter.MainCategoryAdapter
import com.arincdogansener.finalrecipeapp.adapter.SubCategoryAdapter
import com.arincdogansener.finalrecipeapp.database.RecipeDatabase
import com.arincdogansener.finalrecipeapp.databinding.ActivityHomeBinding
import com.arincdogansener.finalrecipeapp.entities.Category
import com.arincdogansener.finalrecipeapp.entities.CategoryItems
import com.arincdogansener.finalrecipeapp.entities.MealsItems
import com.arincdogansener.finalrecipeapp.entities.Recipies
import kotlinx.coroutines.launch

class HomeActivity : BaseActivity() {

    private lateinit var binding : ActivityHomeBinding
    var arrMainCategory = ArrayList<CategoryItems>()
    var arrSubCategory = ArrayList<MealsItems>()

    var mainCategoryAdapter = MainCategoryAdapter()
    var subCategoryAdapter = SubCategoryAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        getDataFromDb()

        mainCategoryAdapter.setClickListener(onCLicked)


    }

    private val onCLicked  = object : MainCategoryAdapter.OnItemClickListener{
        override fun onClicked(categoryName: String) {
            getMealDataFromDb(categoryName)
        }
    }

    private fun getDataFromDb(){
        launch {
            this.let {
                var cat = RecipeDatabase.getDatabase(this@HomeActivity).recipeDao().getAllCategory()
                arrMainCategory = cat as ArrayList<CategoryItems>
                arrMainCategory.reverse()
                getMealDataFromDb(arrMainCategory[0].strCategory)
                mainCategoryAdapter.setData(arrMainCategory)
                binding.rvMainCategory.layoutManager = LinearLayoutManager(this@HomeActivity,LinearLayoutManager.HORIZONTAL, false)
                binding.rvMainCategory.adapter = mainCategoryAdapter
            }


        }
    }

    private fun getMealDataFromDb(categoryName:String){
        binding.tvCategory.text = "$categoryName Category"

        launch {
            this.let {
                var cat = RecipeDatabase.getDatabase(this@HomeActivity).recipeDao().getSpecificMealList(categoryName)
                arrSubCategory = cat as ArrayList<MealsItems>
                subCategoryAdapter.setData(arrSubCategory)
                binding.rvSubCategory.layoutManager = LinearLayoutManager(this@HomeActivity,LinearLayoutManager.HORIZONTAL,false)
                binding.rvSubCategory.adapter = subCategoryAdapter
            }


        }
    }

}