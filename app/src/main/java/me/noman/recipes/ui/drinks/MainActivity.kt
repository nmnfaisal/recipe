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
import org.json.JSONObject

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val viewModel: MainViewModel by viewModels()
    var drinkData: ArrayList<Drink> = ArrayList()
    lateinit var drinkList: List<DrinkData>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setToolbar()
        fetchDrinkAPI()

        val linearLayoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        val drinkAdapter = DrinkAdapter(this, drinkData)

        binding.drinkRecyclerView.layoutManager = linearLayoutManager
        binding.drinkRecyclerView.adapter = drinkAdapter

    }

    private fun fetchDrinkAPI() {

        viewModel.fetchDrinkList()

        lifecycleScope.launch {
            viewModel.drinkList.collectLatest { result ->
                (binding.drinkRecyclerView.adapter as DrinkAdapter).setList(result)
            }
        }

    }

    private fun setToolbar() {
        binding.toolbar.heading.text = "Drinks Recipes"
    }

}