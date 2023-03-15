package com.example.experimentation.HomeFragment

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.experimentation.API.RepositoryAPI
import com.example.experimentation.API.RepositoryRemoteItemLatest
import com.example.experimentation.API.RepositoryRemoteItemSale
import com.example.experimentation.Items
import com.example.experimentation.RepositoryItems
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch

class HomeViewModel(
    private val repositoryItems: RepositoryItems,
    private val repositoryAPI: RepositoryAPI
): ViewModel() {
    private val _items = MutableStateFlow<List<Items>?>(null)
    val items: MutableStateFlow<List<Items>?> = _items
    private val _latestItems = MutableStateFlow<List<RepositoryRemoteItemLatest>?>(null)
    val latestItems : MutableStateFlow<List<RepositoryRemoteItemLatest>?> = _latestItems
    private val _saleItems = MutableStateFlow<List<RepositoryRemoteItemSale>?>(null)
    val saleItems : MutableStateFlow<List<RepositoryRemoteItemSale>?> = _saleItems

    init {
        observeItems()
        observeLatestData()
    }

    private fun observeLatestData() {
        viewModelScope.launch {
            val last = repositoryAPI.getLatest()
            _latestItems.value = last.latest
            val sale = repositoryAPI.getSale()
            _saleItems.value = sale.flash_sale
            println("333$saleItems")
        }
    }

    private fun observeItems(){
        _items.value = repositoryItems.items
    }
}