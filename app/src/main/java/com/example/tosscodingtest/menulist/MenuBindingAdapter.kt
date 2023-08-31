package com.example.tosscodingtest.menulist

import android.view.View
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.TextView
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.tosscodingtest.R
import com.example.tosscodingtest.data.model.Caffeine
import com.example.tosscodingtest.data.model.IceSize
import com.example.tosscodingtest.data.model.MenuList
import com.example.tosscodingtest.data.model.Temp
import com.example.tosscodingtest.menulist.adapter.MenuListAdapter

@BindingAdapter("bind:menuList")
fun RecyclerView.setGalleryList(list: List<MenuList>?) {
    (adapter as? MenuListAdapter)?.fetchData(list ?: emptyList())
}

@BindingAdapter("bind:onItemClickListener")
fun RecyclerView.setGalleryListItemClickListener(menuNavigation: MenuNavigation) {
    (adapter as? MenuListAdapter)?.menuNavigation = menuNavigation
}

@BindingAdapter("bind:priceToString")
fun TextView.setTextFromPrice(number: Int?) {
    text = number.toString() + "원"
}

@BindingAdapter("bind:tempToString")
fun TextView.setTextFromTemp(temp: Temp) {
    text = temp.toString()
}

@BindingAdapter("bind:caffeineToString")
fun TextView.setTextFromCaffeine(caffeine: Caffeine) {
    text = "/" + caffeine.toString()
}

@BindingAdapter("bind:iceSizeToString")
fun TextView.setTextFromIceSize(iceSize: IceSize) {
    text = "/" + iceSize.toString()
}

@BindingAdapter("bind:visibility")
fun View.setVisibility(visible: Boolean) {
    visibility = if (visible) View.VISIBLE else View.GONE
}

@BindingAdapter("bind:icevisibility")
fun View.setIceVisibility(temp: Temp) {
    visibility = if (temp == Temp.ICE) View.VISIBLE else View.GONE
}

@BindingAdapter("bind:enabled")
fun RadioButton.setEnable(enable: Boolean) {
    isEnabled = !enable
}

@BindingAdapter("bind:checkedButton")
fun RadioGroup.setCheckedButtonTemp(checked: Boolean) {
    if (!checked) check(R.id.hot_button) else check(R.id.ice_button)
}
