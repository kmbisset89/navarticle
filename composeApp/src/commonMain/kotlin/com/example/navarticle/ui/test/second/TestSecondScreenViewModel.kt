package com.example.navarticle.ui.test.second

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.navigation.NavHostController
import com.example.navarticle.ui.ComposeViewModel

class TestSecondScreenViewModel(
    private val navController: NavHostController,
    internal val title: String,
) : ComposeViewModel() {
    internal var goBackAvailable by mutableStateOf(true)
        private set

    internal fun onInteraction(interactions: TestSecondScreenInteractions) {
        when (interactions) {
            TestSecondScreenInteractions.GoToBack -> {
                goBackAvailable = false
                navController.popBackStack()
            }
        }
    }

    override suspend fun onClear() {
        println("TestSecondScreenViewModel cleared")
    }
}
