package com.example.artomap.ui.database

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.ItemTouchHelper
import com.example.artomap.data.model.DataModel
import com.example.artomap.databinding.FragmentDataBinding
import com.example.artomap.ui.database.adapter.DataBaseAdapter
import com.example.artomap.ui.database.adapter.logic.ItemDataTouchHelper

class DataFragment : Fragment() {

    lateinit var binding: FragmentDataBinding
    lateinit var listItem: ArrayList<DataModel>
    lateinit var adapter: DataBaseAdapter

    lateinit var itemDataTouchHelper: ItemTouchHelper


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {


        binding = FragmentDataBinding.inflate(inflater, container, false)
        adapter = DataBaseAdapter()
        listItem = initData()
        ItemTouchHelper(
            ItemDataTouchHelper(
                layoutInflater.context,
                listItem,
                adapter,
                binding.coordinator
            )
        ).attachToRecyclerView(binding.recyclerView)


        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)



        adapter.addData(listItem)
        binding.recyclerView.adapter = adapter


    }

    private fun initData(): ArrayList<DataModel> {
        var list = ArrayList<DataModel>()
        for (i in 1..200) {
            list.add(DataModel("Temir", i.toString()))
        }
        return list
    }


}





