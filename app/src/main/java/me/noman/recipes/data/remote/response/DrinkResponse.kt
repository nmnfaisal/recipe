package me.noman.recipes.data.remote.response

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName


data class DrinkResponse (
    @SerializedName("drinks" ) var getDrinkResponse : List<Drink> = emptyList()
)

@Entity(tableName = "Drink")
data class Drink (

    @PrimaryKey
    @SerializedName("idDrink"                     ) var idDrink                     : String,
    @SerializedName("strDrink"                    ) var strDrink                    : String,
    @SerializedName("strDrinkAlternate"           ) var strDrinkAlternate           : String,
    @SerializedName("strTags"                     ) var strTags                     : String,
    @SerializedName("strVideo"                    ) var strVideo                    : String,
    @SerializedName("strCategory"                 ) var strCategory                 : String,
    @SerializedName("strIBA"                      ) var strIBA                      : String,
    @SerializedName("strAlcoholic"                ) var strAlcoholic                : String,
    @SerializedName("strGlass"                    ) var strGlass                    : String,
    @SerializedName("strInstructions"             ) var strInstructions             : String,
    @SerializedName("strInstructionsES"           ) var strInstructionsES           : String,
    @SerializedName("strInstructionsDE"           ) var strInstructionsDE           : String,
    @SerializedName("strInstructionsFR"           ) var strInstructionsFR           : String,
    @SerializedName("strInstructionsIT"           ) var strInstructionsIT           : String,
    @SerializedName("strInstructionsZH-HANS"      ) var strInstructionsZHHANS       : String,
    @SerializedName("strInstructionsZH-HANT"      ) var strInstructionsZHHANT       : String,
    @SerializedName("strDrinkThumb"               ) var strDrinkThumb               : String,
    @SerializedName("strIngredient1"              ) var strIngredient1              : String,
    @SerializedName("strIngredient2"              ) var strIngredient2              : String,
    @SerializedName("strIngredient3"              ) var strIngredient3              : String,
    @SerializedName("strIngredient4"              ) var strIngredient4              : String,
    @SerializedName("strIngredient5"              ) var strIngredient5              : String,
    @SerializedName("strIngredient6"              ) var strIngredient6              : String,
    @SerializedName("strIngredient7"              ) var strIngredient7              : String,
    @SerializedName("strIngredient8"              ) var strIngredient8              : String,
    @SerializedName("strIngredient9"              ) var strIngredient9              : String,
    @SerializedName("strIngredient10"             ) var strIngredient10             : String,
    @SerializedName("strIngredient11"             ) var strIngredient11             : String,
    @SerializedName("strIngredient12"             ) var strIngredient12             : String,
    @SerializedName("strIngredient13"             ) var strIngredient13             : String,
    @SerializedName("strIngredient14"             ) var strIngredient14             : String,
    @SerializedName("strIngredient15"             ) var strIngredient15             : String,
    @SerializedName("strMeasure1"                 ) var strMeasure1                 : String,
    @SerializedName("strMeasure2"                 ) var strMeasure2                 : String,
    @SerializedName("strMeasure3"                 ) var strMeasure3                 : String,
    @SerializedName("strMeasure4"                 ) var strMeasure4                 : String,
    @SerializedName("strMeasure5"                 ) var strMeasure5                 : String,
    @SerializedName("strMeasure6"                 ) var strMeasure6                 : String,
    @SerializedName("strMeasure7"                 ) var strMeasure7                 : String,
    @SerializedName("strMeasure8"                 ) var strMeasure8                 : String,
    @SerializedName("strMeasure9"                 ) var strMeasure9                 : String,
    @SerializedName("strMeasure10"                ) var strMeasure10                : String,
    @SerializedName("strMeasure11"                ) var strMeasure11                : String,
    @SerializedName("strMeasure12"                ) var strMeasure12                : String,
    @SerializedName("strMeasure13"                ) var strMeasure13                : String,
    @SerializedName("strMeasure14"                ) var strMeasure14                : String,
    @SerializedName("strMeasure15"                ) var strMeasure15                : String,
    @SerializedName("strImageSource"              ) var strImageSource              : String,
    @SerializedName("strImageAttribution"         ) var strImageAttribution         : String,
    @SerializedName("strCreativeCommonsConfirmed" ) var strCreativeCommonsConfirmed : String,
    @SerializedName("dateModified"                ) var dateModified                : String

)