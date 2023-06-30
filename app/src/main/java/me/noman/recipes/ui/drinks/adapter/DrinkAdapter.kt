package me.noman.recipes.ui.drinks.adapter

import android.annotation.SuppressLint
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
import me.noman.recipes.ui.drinks.MainViewModel

class DrinkAdapter(
    drinksArrayList: List<Drink>,
    private val mainViewModel: MainViewModel,
    ) : RecyclerView.Adapter<DrinkAdapter.ViewHolder>() {

    private var drinksArrayList: List<Drink>

    // Constructor
    init {
        this.drinksArrayList = drinksArrayList
    }
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
        if(model.isFavourite == true)
            holder.isFavourite.setImageResource(R.drawable.ic_fav)
        else
            holder.isFavourite.setImageResource((R.drawable.ic_not_favorite))

        holder.isFavourite.setOnClickListener {
            if(model.isFavourite == true){
                holder.isFavourite.setImageResource((R.drawable.ic_not_favorite))
                mainViewModel.addDrinkToFavourite(model.idDrink , false)

            }else{
                mainViewModel.addDrinkToFavourite(model.idDrink , true)
                holder.isFavourite.setImageResource(R.drawable.ic_fav)
            }
        }

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

    @SuppressLint("NotifyDataSetChanged")
    fun setList(it: List<Drink>) {
        drinksArrayList = it.toList()
        notifyDataSetChanged()
    }
}



