package me.noman.recipes.ui.drinks

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import me.noman.recipes.data.local.AppDatabase
import me.noman.recipes.data.remote.response.Drink
import me.noman.recipes.data.repositories.DrinkRepository
import javax.inject.Inject


@HiltViewModel
class MainViewModel
@Inject constructor(
    private val appDatabase: AppDatabase,
    val drinkRepo: DrinkRepository
) : ViewModel() {

    lateinit var drinkList: Flow<List<Drink>>

    fun fetchDrinkList() {
        drinkRepo.fetchAllPosts("Margarita")
        drinkList = drinkRepo.fetchDrinkList()

    }

    fun addDrinkToFavourite(idDrink: String, isFavourite: Boolean){
        drinkRepo.addDrinkToFavourite(idDrink, isFavourite)
    }

}