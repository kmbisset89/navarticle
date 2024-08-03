package com.example.navarticle.ui.test

import kotlinx.serialization.Serializable

@Serializable
sealed class TestScreens {

    @Serializable
    data object TestMainScreen : TestScreens()

    @Serializable
    internal data class TestSecondScreen(val text : String) : TestScreens()
}