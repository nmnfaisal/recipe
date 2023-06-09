package me.noman.recipes.ui.drinks.adapter

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CheckBox
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import me.noman.recipes.R
import me.noman.recipes.data.remote.response.Drink
import me.noman.recipes.databinding.CardViewBinding
import me.noman.recipes.domain.model.DrinkData
import retrofit2.http.Url
import java.net.URL

class DrinkAdapter(
    private val context: Context,
    drinksArrayList: List<Drink>
) : RecyclerView.Adapter<DrinkAdapter.ViewHolder>() {

    private var drinksArrayList: List<Drink>
    private var dataSet: List<Drink> = emptyList<Drink>().toMutableList()


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DrinkAdapter.ViewHolder {
        // to inflate the layout for each item of recycler view.
        val view: View = LayoutInflater.from(parent.context).inflate(R.layout.card_view, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: DrinkAdapter.ViewHolder, position: Int) {
        // to set data to textview and imageview of each card layout
        val model: Drink = drinksArrayList[holder.layoutPosition]


        Picasso.get().load(model.strDrinkThumb).into(holder.drinkImage)
        holder.drinkTitle.text = model.strDrink
        holder.drinkDiscription.text = model.strInstructions
//        if(model.getIsFavourite())
//            holder.isFavourite.setImageResource(R.drawable.ic_fav)
//        else
//            holder.isFavourite.setImageResource((R.drawable.ic_not_favorite))

        holder.isAlcoholic.isChecked = model.strAlcoholic == "Alcoholic"
    }

    override fun getItemCount(): Int {
        // this method is used for showing number of card items in recycler view.

        return drinksArrayList.size
    }

    // View holder class for initializing of your views such as TextView and Imageview.
    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
         val drinkImage: ImageView
         val drinkTitle: TextView
         val drinkDiscription: TextView
         val isFavourite: ImageButton
         val isAlcoholic: CheckBox
        init {
            drinkImage = itemView.findViewById(R.id.drink_image)
            drinkTitle = itemView.findViewById(R.id.drink_title)
            drinkDiscription = itemView.findViewById(R.id.drink_discription)
            isFavourite = itemView.findViewById(R.id.fav_button)
            isAlcoholic = itemView.findViewById(R.id.isAlchoholic)
        }
    }

    // Constructor
    init {
        this.drinksArrayList = drinksArrayList
    }


    @SuppressLint("NotifyDataSetChanged")
    fun setList(it: List<Drink>) {
        drinksArrayList = it.toList()
        notifyDataSetChanged()
    }
}



