package com.example.experimentation.HomeFragment.items

import android.view.LayoutInflater
import android.view.ViewGroup
import com.bumptech.glide.Glide
import com.example.experimentation.R
import com.example.experimentation.databinding.ItemForListBinding
import com.example.experimentation.databinding.LatestItemBinding
import com.mikepenz.fastadapter.binding.AbstractBindingItem

class BindingLatestItems(
    val name: String? = null, val icon: String? = null, val category: String?, val price: Int?
) : AbstractBindingItem<LatestItemBinding>() {

    override val type: Int
        get() = R.id.latest

    override fun bindView(binding: LatestItemBinding, payloads: List<Any>) {
        with(binding) {
            this.nameSaleTxt.text = name
            this.categorySaleTxt.text = category
            this.priceSaleTxt.text = price.toString()
            Glide.with(imageOfSale.context)
                .load(icon)
                .into(imageOfSale)
        }
    }

    override fun createBinding(inflater: LayoutInflater, parent: ViewGroup?): LatestItemBinding {
        return LatestItemBinding.inflate(inflater, parent, false)
    }
}