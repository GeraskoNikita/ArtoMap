package com.example.artomap.ui.database.adapter.logic

import android.content.Context
import android.graphics.Canvas
import androidx.coordinatorlayout.widget.CoordinatorLayout
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.RecyclerView
import com.example.artomap.R
import com.example.artomap.data.model.DataModel
import com.example.artomap.ui.database.adapter.DataBaseAdapter
import com.google.android.material.snackbar.Snackbar

class ItemDataTouchHelper(
    private val context: Context,
    private val data: ArrayList<DataModel>,
    private val adapter: DataBaseAdapter,
    private val coordinator : CoordinatorLayout
) : ItemTouchHelper.SimpleCallback(0, ItemTouchHelper.LEFT) {
    override fun onMove(
        recyclerView: RecyclerView,
        viewHolder: RecyclerView.ViewHolder,
        target: RecyclerView.ViewHolder
    ): Boolean {
        return false
    }

    override fun onSwiped(
        viewHolder: RecyclerView.ViewHolder,
        direction: Int
    ) {
        val pos = viewHolder.adapterPosition
        val shop = data[pos]
        adapter.removeAt(pos)

        Snackbar.make(coordinator, "Удалён: ${shop.title}", Snackbar.LENGTH_LONG)
            .setAction("Отменить") {
                data.add(pos, shop)
                adapter.notifyItemInserted(pos)
            }.show()
    }

    override fun onChildDraw(
        c: Canvas,
        recyclerView: RecyclerView,
        viewHolder: RecyclerView.ViewHolder,
        dX: Float,
        dY: Float,
        actionState: Int,
        isCurrentlyActive: Boolean
    ) {
        super.onChildDraw(c, recyclerView, viewHolder, dX, dY, actionState, isCurrentlyActive)

        val itemView = viewHolder.itemView
        val background =
            ContextCompat.getDrawable(context, R.drawable.bg_swipe_delete)

        if (dX < 0) { // свайп влево
            background?.setBounds(
                itemView.right + dX.toInt(),
                itemView.top,
                itemView.right,
                itemView.bottom
            )
            background?.draw(c)
        }
    }




}