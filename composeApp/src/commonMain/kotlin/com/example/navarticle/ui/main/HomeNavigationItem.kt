package com.example.navarticle.ui.main

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import com.example.navarticle.bl.INavigationItem
import com.example.navarticle.ui.home.Home

class HomeNavigationItem : INavigationItem<Home> {
    override val icon: @Composable () -> Unit = {
        Icon(Icons.Default.Home, contentDescription = "Home")
    }
    override val label: String = "Home"
    override val route: Home = Home
    override val order: Int = 0
}