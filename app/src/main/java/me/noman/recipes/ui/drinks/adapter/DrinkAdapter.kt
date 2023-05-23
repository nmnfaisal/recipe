package me.noman.recipes.ui.drinks.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import me.noman.recipes.R
import me.noman.recipes.databinding.CardViewBinding
import me.noman.recipes.domain.model.DrinkData
import retrofit2.http.Url
import java.net.URL

class DrinkAdapter(
    private val context: Context,
    drinksArrayList: ArrayList<DrinkData>
) :
    RecyclerView.Adapter<DrinkAdapter.ViewHolder>() {

    private val drinksArrayList: ArrayList<DrinkData>



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DrinkAdapter.ViewHolder {
        // to inflate the layout for each item of recycler view.
        val view: View = LayoutInflater.from(parent.context).inflate(R.layout.card_view, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: DrinkAdapter.ViewHolder, position: Int) {
        // to set data to textview and imageview of each card layout
        val model: DrinkData = drinksArrayList[holder.layoutPosition]


        Picasso.get().load(model.getDrinkImage()).into(holder.drinkImage)
        holder.drinkTitle.text = model.getDrinkName()
        holder.drinkDiscription.text = model.getDrinkDiscription()
        if(model.getIsFavourite())
            holder.isFavourite.setImageResource(R.drawable.ic_add_to_favourite)
        else
            holder.isFavourite.setImageResource((R.drawable.ic_not_fav))

        if(model.getIsAlcoholic())
            holder.isAlcoholic.setImageResource(R.drawable.ic_add_to_favourite)
        else
            holder.isAlcoholic.setImageResource((R.drawable.ic_not_fav))
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
         val isAlcoholic: ImageButton
        init {
            drinkImage = itemView.findViewById(R.id.drink_image)
            drinkTitle = itemView.findViewById(R.id.drink_title)
            drinkDiscription = itemView.findViewById(R.id.drink_discription)
            isFavourite = itemView.findViewById(R.id.fav_button)
            isAlcoholic = itemView.findViewById(R.id.alcohol_button)
        }
    }

    // Constructor
    init {
        this.drinksArrayList = drinksArrayList
    }
}



