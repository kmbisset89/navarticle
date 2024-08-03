package com.example.navarticle.bl

import androidx.compose.runtime.Composable

interface INavigationItem<T : Any> {
    val icon: @Composable () -> Unit

    val label: String

    val route: T

    val order: Int
}
