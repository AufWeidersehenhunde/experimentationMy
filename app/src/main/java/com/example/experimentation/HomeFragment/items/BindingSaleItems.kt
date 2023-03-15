package com.example.experimentation.HomeFragment.items

import android.view.LayoutInflater
import android.view.ViewGroup
import com.bumptech.glide.Glide
import com.example.experimentation.R
import com.example.experimentation.databinding.LatestItemBinding
import com.example.experimentation.databinding.SaleItemBinding
import com.mikepenz.fastadapter.binding.AbstractBindingItem

class BindingSaleItems(
    val name: String? = null, val icon: String? = null, val category: String?, val price: Double?, val discount: Int?
) : AbstractBindingItem<SaleItemBinding>() {

    override val type: Int
        get() = R.id.sale

    override fun bindView(binding: SaleItemBinding, payloads: List<Any>) {
        with(binding) {
            this.nameSaleTxt.text = name
            this.categorySaleTxt.text = category
            this.priceSaleTxt.text = price.toString()
            Glide.with(imageOfSale.context)
                .load(icon)
                .into(imageOfSale)
            this.saleTxt.text = "$discount% off"
        }
    }

    override fun createBinding(inflater: LayoutInflater, parent: ViewGroup?): SaleItemBinding {
        return SaleItemBinding.inflate(inflater, parent, false)
    }
}