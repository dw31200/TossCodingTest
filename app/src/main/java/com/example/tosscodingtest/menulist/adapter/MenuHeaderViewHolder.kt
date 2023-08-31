package com.example.tosscodingtest.menulist.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.tosscodingtest.data.model.MenuList
import com.example.tosscodingtest.databinding.MenuHeaderBinding

class MenuHeaderViewHolder(
    private val binding: MenuHeaderBinding,
) : RecyclerView.ViewHolder(binding.root) {
    fun bind(menuItem: MenuList) {
        binding.data = menuItem
    }

    companion object {
        operator fun invoke(parent: ViewGroup): MenuHeaderViewHolder {
            val binding =
                MenuHeaderBinding.inflate(LayoutInflater.from(parent.context), parent, false)
            return MenuHeaderViewHolder(binding)
        }
    }
}
