package me.noman.recipes.ui.drinks

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import me.noman.recipes.data.remote.response.Drink
import me.noman.recipes.databinding.ActivityMainBinding
import me.noman.recipes.ui.drinks.adapter.DrinkAdapter

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val viewModel: MainViewModel by viewModels()
    var drinkData: ArrayList<Drink> = ArrayList()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setToolbar()
        fetchDrinkAPI()

        val linearLayoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        val drinkAdapter = DrinkAdapter(drinkData, viewModel)

        binding.drinkRecyclerView.layoutManager = linearLayoutManager
        binding.drinkRecyclerView.adapter = drinkAdapter


        binding.SwipeRefresh.setOnRefreshListener {
            binding.SwipeRefresh.isRefreshing = false
            (binding.drinkRecyclerView.adapter as DrinkAdapter).notifyDataSetChanged()
        }

        binding.refreshList.setOnClickListener {
            (binding.drinkRecyclerView.adapter as DrinkAdapter).notifyDataSetChanged()
        }

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