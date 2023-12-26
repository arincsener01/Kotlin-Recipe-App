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
import com.arincdogansener.finalrecipeapp.entities.Recipies
import kotlinx.coroutines.launch

class HomeActivity : BaseActivity() {

    private lateinit var binding : ActivityHomeBinding
    var arrMainCategory = ArrayList<CategoryItems>()
    var arrSubCategory = ArrayList<Recipies>()

    var mainCategoryAdapter = MainCategoryAdapter()
    var subCategoryAdapter = SubCategoryAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        getDataFromDb()

        arrSubCategory.add(Recipies(1, "Beefasdfffasdf"))
        arrSubCategory.add(Recipies(2, "Chicken asdfdsffsa"))
        arrSubCategory.add(Recipies(3, "Dessert asdggadsg"))
        arrSubCategory.add(Recipies(4, "Lamb asdgsdggdsa"))

        subCategoryAdapter.setData(arrSubCategory)



        binding.rvSubCategory.layoutManager = LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL, false)
        binding.rvSubCategory.adapter = subCategoryAdapter
    }

    private fun getDataFromDb(){
        launch {
            this.let {
                var cat = RecipeDatabase.getDatabase(this@HomeActivity).recipeDao().getAllCategory()
                arrMainCategory = cat as ArrayList<CategoryItems>
                arrMainCategory.reverse()
                mainCategoryAdapter.setData(arrMainCategory)
                binding.rvMainCategory.layoutManager = LinearLayoutManager(this@HomeActivity,LinearLayoutManager.HORIZONTAL, false)
                binding.rvMainCategory.adapter = mainCategoryAdapter
            }


        }
    }

}