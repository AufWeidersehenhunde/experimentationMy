package com.example.experimentation.MainActivity

import androidx.lifecycle.ViewModel
import com.example.experimentation.Screens
import com.github.terrakok.cicerone.Router

class MainActivityViewModel(
    private val router: Router
): ViewModel() {

    fun create(){
        router.newRootScreen(Screens.routeToHome())
    }

}