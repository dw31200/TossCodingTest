package com.example.tosscodingtest.menulist.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.tosscodingtest.data.model.MenuList
import com.example.tosscodingtest.databinding.MenuItemBinding
import com.example.tosscodingtest.menulist.MenuNavigation

class MenuItemViewHolder(
    private val binding: MenuItemBinding,
) : RecyclerView.ViewHolder(binding.root) {

    fun bind(menuItem: MenuList?, menuNavigation: MenuNavigation?) {
        with(binding) {
            data = menuItem
            menuItemContainer.setOnClickListener {
                if (menuItem != null) {
                    menuNavigation?.navigateToDetail(menuItem.id)
                }
            }
            executePendingBindings()
        }
    }

    companion object {
        operator fun invoke(parent: ViewGroup): MenuItemViewHolder {
            val binding =
                MenuItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
            return MenuItemViewHolder(binding)
        }
    }
}