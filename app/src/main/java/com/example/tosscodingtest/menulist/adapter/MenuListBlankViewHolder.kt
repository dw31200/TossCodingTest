package com.example.tosscodingtest.menulist.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.tosscodingtest.databinding.MenuListBlankBinding

class MenuListBlankViewHolder(
    binding: MenuListBlankBinding,
) : RecyclerView.ViewHolder(binding.root) {
    fun bind() {
    }

    companion object {
        operator fun invoke(parent: ViewGroup): MenuListBlankViewHolder {
            val binding =
                MenuListBlankBinding.inflate(LayoutInflater.from(parent.context), parent, false)
            return MenuListBlankViewHolder(binding)
        }
    }
}
