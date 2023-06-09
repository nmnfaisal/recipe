package me.noman.recipes.ui.base

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.RecyclerView

class BaseAdapterRecyclerView <L : ViewDataBinding, T>(
    val layoutId: Int, val context: Context,
) : RecyclerView.Adapter<BaseAdapterRecyclerView.BaseViewHolder>() {

    private lateinit var _binding: L
    val binding: L get() = _binding
    protected var filteredList: List<T> = emptyList<T>().toMutableList()

    class BaseViewHolder(private val binding: ViewDataBinding) :
        RecyclerView.ViewHolder(binding.root) {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        _binding = DataBindingUtil.inflate(layoutInflater, layoutId, parent, false)
        return BaseViewHolder(binding = _binding)
    }

    override fun onBindViewHolder(holder: BaseViewHolder, position: Int) {

    }


    // Return the size of your dataset (invoked by the layout manager)
    override fun getItemCount() = filteredList.size


    @SuppressLint("NotifyDataSetChanged")
    open fun setList(it: List<T>) {
        filteredList = it.toMutableList()
        notifyDataSetChanged()
    }

}