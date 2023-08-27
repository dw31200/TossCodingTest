package com.example.tosscodingtest.menulist.adapter

import android.annotation.SuppressLint
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.tosscodingtest.data.model.MenuList
import com.example.tosscodingtest.menulist.MenuNavigation

class MenuListAdapter(
    private val menuItems: MutableList<MenuList> = mutableListOf()
) : RecyclerView.Adapter<MenuItemViewHolder>() {
    var menuNavigation: MenuNavigation? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = MenuItemViewHolder(parent)

    override fun getItemCount(): Int = menuItems.size

    override fun onBindViewHolder(holder: MenuItemViewHolder, position: Int) {
        holder.bind(menuItems[position], menuNavigation)
    }

    @SuppressLint("NotifyDataSetChanged")
    fun fetchData(menuItems: List<MenuList>) {
        this.menuItems.clear()
        this.menuItems.addAll(menuItems)
        notifyDataSetChanged()
    }
}