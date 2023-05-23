package me.noman.recipes.domain.model

import android.graphics.Bitmap
import android.media.Image
import android.widget.ImageButton

class DrinkData(
    private var drinkName: String,
    private var drinkDiscription: String,
    private var drinkImage: String,
    private var isFavourite: Boolean,
    private var isAlcoholic: Boolean
){
    // Getter and Setter
    fun getDrinkName(): String {
        return drinkName
    }

    fun setDrinkName(drinkName: String) {
        this.drinkName = drinkName
    }

    fun getDrinkDiscription(): String {
        return drinkDiscription
    }

    fun setDrinkDiscription(drinkDiscription: String) {
        this.drinkDiscription = drinkDiscription
    }

    fun getDrinkImage(): String {
        return drinkImage
    }

    fun setDrinkImage(drinkImage: String) {
        this.drinkImage = drinkImage
    }

    fun getIsFavourite(): Boolean {
        return isFavourite
    }

    fun setIsFavourite(isFavourite: Boolean) {
        this.isFavourite = isFavourite
    }

    fun getIsAlcoholic(): Boolean {
        return isAlcoholic
    }

    fun setIsAlcoholic(isAlcoholic: Boolean) {
        this.isAlcoholic = isAlcoholic
    }

}