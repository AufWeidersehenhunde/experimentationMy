package com.example.experimentation.API

import com.example.experimentation.API.RetrofitInst.api

class RepositoryAPI {
    suspend fun getLatest(): ApiResponse {
        val itemsList: ApiResponse?
        itemsList = api.getLatest().body() ?: ApiResponse (listOf())
        return itemsList
    }

    suspend fun getSale(): ApiResponseSale {
        val itemsList: ApiResponseSale?
        itemsList = api.getSale().body() ?: ApiResponseSale (listOf())
        return itemsList
    }
}
