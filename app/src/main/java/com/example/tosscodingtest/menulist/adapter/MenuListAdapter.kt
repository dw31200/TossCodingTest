package com.example.tosscodingtest.menulist.adapter

import android.annotation.SuppressLint
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.tosscodingtest.data.model.MenuList
import com.example.tosscodingtest.menulist.MenuNavigation

class MenuListAdapter(
    private val menuItems: MutableList<MenuList> = mutableListOf(),
) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    var menuNavigation: MenuNavigation? = null

    override fun getItemViewType(position: Int): Int {
        return menuItems[position].type
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return when (viewType) {
            MENU_HEADER -> MenuHeaderViewHolder(parent)
            MENU -> MenuItemViewHolder(parent)
            else -> MenuListBlankViewHolder(parent)
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when (menuItems[position].type) {
            MENU_HEADER -> (holder as MenuHeaderViewHolder).bind(menuItems[position])
            MENU -> (holder as MenuItemViewHolder).bind(menuItems[position], menuNavigation)
            else -> (holder as MenuListBlankViewHolder).bind()
        }
    }

    override fun getItemCount(): Int = menuItems.size

    @SuppressLint("NotifyDataSetChanged")
    fun fetchData(menuItems: List<MenuList>) {
        this.menuItems.clear()
        this.menuItems.addAll(menuItems)
        notifyDataSetChanged()
    }
}
