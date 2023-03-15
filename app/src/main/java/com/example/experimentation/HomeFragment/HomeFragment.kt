package com.example.experimentation.HomeFragment

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.View
import by.kirich1409.viewbindingdelegate.viewBinding
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.bumptech.glide.Glide
import com.example.experimentation.HomeFragment.items.ItemWithHeader
import com.example.experimentation.HomeFragment.items.ItemWithHeaderSale
import com.example.experimentation.HomeFragment.items.SimpleItem
import com.example.experimentation.R
import com.example.experimentation.databinding.FragmentHomeBinding
import com.mikepenz.fastadapter.FastAdapter
import com.mikepenz.fastadapter.GenericItem
import com.mikepenz.fastadapter.adapters.ItemAdapter
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.filterNotNull
import kotlinx.coroutines.launch
import org.koin.androidx.viewmodel.ext.android.viewModel

class HomeFragment : Fragment(R.layout.fragment_home) {
    private val viewModel: HomeViewModel by viewModel()
    private val itemAdapter = ItemAdapter<GenericItem>()
    private val fastAdapter = FastAdapter.with(itemAdapter)
    private val viewBinding: FragmentHomeBinding by viewBinding()


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initView()
        initObservers()
    }

    private fun initView() {
        Glide.with(viewBinding.imageView.context)
            .load(R.drawable.max)
            .into(viewBinding.imageView)

        with(viewBinding.recycler) {
            layoutManager = LinearLayoutManager(
                context
            )
            adapter = fastAdapter
        }
    }
    private fun initObservers(){
        viewLifecycleOwner.lifecycleScope.launch {
            viewModel.items.filterNotNull().collect { item ->
                itemAdapter.add(
                    SimpleItem(
                        itemsForRecycler = item
                    )
                )
            }
        }
        viewLifecycleOwner.lifecycleScope.launch {
            viewModel.latestItems.filterNotNull().collect{
                itemAdapter.add(
                    ItemWithHeader(
                        itemsForRecycler = it
                    )
                )
            }
        }

        viewLifecycleOwner.lifecycleScope.launch {
            viewModel.saleItems.filterNotNull().collect{
                itemAdapter.add(
                    ItemWithHeaderSale(
                        itemsForRecycler = it
                    )
                )
            }
        }
    }
}