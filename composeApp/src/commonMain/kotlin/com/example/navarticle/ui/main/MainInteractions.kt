package com.example.navarticle.ui.main

import com.example.navarticle.bl.INavigationItem

sealed class MainInteractions {
    data class NavigateTo(
        val route: INavigationItem<Any>,
    ) : MainInteractions()
}
