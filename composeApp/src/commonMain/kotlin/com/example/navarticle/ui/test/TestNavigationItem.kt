package com.example.navarticle.ui.test

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Science
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import com.example.navarticle.bl.INavigationItem

class TestNavigationItem : INavigationItem<TestScreens.TestMainScreen> {
    override val icon: @Composable () -> Unit = {
        Icon(Icons.Default.Science, contentDescription = "Test")
    }

    override val route = TestScreens.TestMainScreen

    override val label: String = "Test"
    override val order: Int = 1
}