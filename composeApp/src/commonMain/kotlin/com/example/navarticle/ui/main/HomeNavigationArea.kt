package com.example.navarticle.ui.main

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.example.navarticle.bl.INavigationArea
import com.example.navarticle.ui.home.Home

class HomeNavigationArea : INavigationArea {
    override fun display(navGraphBuilder: NavGraphBuilder) {
        navGraphBuilder.composable<Home> {
            Home()
        }
    }

    @Composable
    private fun Home() {
        Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                Icon(Icons.Default.Home, contentDescription = "Home", modifier = Modifier.size(96.dp))
                Text(text = "Home", style = MaterialTheme.typography.headlineLarge)
            }
        }
    }
}
