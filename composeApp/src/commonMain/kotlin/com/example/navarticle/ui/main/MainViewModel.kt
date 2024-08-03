package com.example.navarticle.ui.main

import androidx.lifecycle.ViewModel
import androidx.navigation.NavHostController
import com.example.navarticle.bl.INavigationArea
import com.example.navarticle.bl.INavigationItem
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import org.koin.core.component.KoinComponent
import org.koin.dsl.module

class MainViewModel(
    internal val navController: NavHostController,
    internal val navigationAreas: List<INavigationItem<Any>>,
    internal val navigatables: List<INavigationArea>,
) : ViewModel(),
    KoinComponent {
    private val module =
        module {
            single { navController }
        }

    private val _selectedItem = MutableStateFlow(navigationAreas.first())
    val selectedItem = _selectedItem.asStateFlow()

    init {
        getKoin().loadModules(listOf(module))
    }

    internal fun onInteraction(interactions: MainInteractions) {
        when (interactions) {
            is MainInteractions.NavigateTo -> {
                _selectedItem.value = interactions.route

                navController.navigate(interactions.route.route)
            }
        }
    }

    override fun onCleared() {
        super.onCleared()
        getKoin().unloadModules(listOf(module))
    }
}
