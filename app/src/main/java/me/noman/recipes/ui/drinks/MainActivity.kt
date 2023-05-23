package me.noman.recipes.ui.drinks

import android.graphics.drawable.Drawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import me.noman.recipes.R
import me.noman.recipes.data.remote.response.Drink
import me.noman.recipes.data.remote.response.DrinkResponse
import me.noman.recipes.databinding.ActivityMainBinding
import me.noman.recipes.domain.model.DrinkData
import me.noman.recipes.ui.drinks.adapter.DrinkAdapter

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val viewModel: MainViewModel by viewModels()
    var drinkData: ArrayList<DrinkData> = ArrayList()
    lateinit var drinkList: List<DrinkData>


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setToolbar()
        fetchDrinkAPI()

        val linearLayoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        val drinkAdapter = DrinkAdapter(this, drinkData)
        binding.recyclerView.layoutManager = linearLayoutManager
        binding.recyclerView.adapter = drinkAdapter
    }

    private fun fetchDrinkAPI() {
        lifecycleScope.launch {
            viewModel.fetchDrinkList()
            viewModel.fetchDrinkResponse.collectLatest {
                drinkList = it.map {
                    DrinkData(it.strDrink, it.strInstructions, it.strDrinkThumb, true, true)
                }
            }
        }
    }

    private fun setToolbar() {
        binding.toolbar.heading.text = "Drinks Recipes"
    }


}