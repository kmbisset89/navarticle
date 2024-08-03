package com.example.navarticle.ui.test.main

import androidx.navigation.NavHostController
import com.example.navarticle.ui.ComposeViewModel
import com.example.navarticle.ui.test.TestScreens

class TestViewModel(private val navController: NavHostController) : ComposeViewModel() {
    internal val titleText = "Test Screen"

    internal fun onInteraction(interactions: TestMainInteractions){
        when(interactions){
            TestMainInteractions.GoToSecondScreen -> {
                navController.navigate(TestScreens.TestSecondScreen("Send this to the second screen"))
            }
        }
    }

    override suspend fun onClear() {
        println("TestViewModel cleared")
    }
}
