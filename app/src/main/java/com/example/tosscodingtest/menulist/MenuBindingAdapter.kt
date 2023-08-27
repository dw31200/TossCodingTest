package com.example.tosscodingtest.menulist

import android.widget.TextView
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.tosscodingtest.data.model.MenuList
import com.example.tosscodingtest.menulist.adapter.MenuListAdapter

@BindingAdapter("bind:menuList")
fun RecyclerView.setGalleryList(list: List<MenuList>?) {
    (adapter as? MenuListAdapter)?.fetchData(list ?: emptyList())
}

@BindingAdapter("bind:onItemClickListener")
fun RecyclerView.setGalleryListItemClickListener(menuNavigation: MenuNavigation) {
    (adapter as? MenuListAdapter)?.menuNavigation = menuNavigation
}

@BindingAdapter("bind:integerToString")
fun TextView.setTextFromInteger(number: Int?) {
    text = number.toString()
}