package com.example.experimentation

import com.example.experimentation.HomeFragment.HomeFragment
import com.github.terrakok.cicerone.androidx.FragmentScreen

object Screens {
    fun routeToHome() = FragmentScreen { HomeFragment() }
}