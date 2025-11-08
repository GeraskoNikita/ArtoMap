package com.example.artomap.ui.database.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.artomap.data.model.DataModel
import com.example.artomap.databinding.ItemDataBinding
import kotlin.collections.arrayListOf

class DataBaseAdapter() : RecyclerView.Adapter<DataBaseAdapter.DataBaseHolder>() {

    var dataBaseList = arrayListOf<DataModel>()

    fun addData(data: List<DataModel>) {
        dataBaseList.clear()
        dataBaseList.addAll(data)
        notifyDataSetChanged()

    }



    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): DataBaseHolder {
        return DataBaseHolder(
            ItemDataBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(
        holder: DataBaseHolder,
        position: Int
    ) {
        holder.onBind(dataBaseList[position])
    }

    override fun getItemCount(): Int {
        return dataBaseList.size
    }

    fun deleteItem(position: Int) {
        dataBaseList.removeAt(position)
        notifyItemRemoved(position)
    }

    fun removeAt(position: Int) {
        dataBaseList.removeAt(position)
        notifyItemRemoved(position)
    }

    inner class DataBaseHolder(private val binding: ItemDataBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun onBind(dataModel: DataModel) {
            binding.tvName.text = dataModel.title
            binding.tvAddress.text = dataModel.address


        }
    }
}


