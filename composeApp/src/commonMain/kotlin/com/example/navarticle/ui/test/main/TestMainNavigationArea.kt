package com.example.navarticle.ui.test.main

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Science
import androidx.compose.material3.Button
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
import com.example.navarticle.ui.ComposableViewModel
import com.example.navarticle.ui.test.TestScreens
import org.koin.compose.getKoin

class TestMainNavigationArea : INavigationArea {
    override fun display(navGraphBuilder: NavGraphBuilder) {
        navGraphBuilder.composable<TestScreens.TestMainScreen> {
            TestMain()
        }
    }

    @Composable
    private fun TestMain() {
        val koin = getKoin()
        Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
            ComposableViewModel({koin.get<TestViewModel>()}) { viewModel ->
                Column(horizontalAlignment = Alignment.CenterHorizontally) {
                    Icon(Icons.Default.Science, contentDescription = "Test", modifier = Modifier.size(96.dp))
                    Text(text = viewModel.titleText, style = MaterialTheme.typography.headlineLarge)
                    Button(onClick = { viewModel.onInteraction(TestMainInteractions.GoToSecondScreen) }) {
                        Text("Go to second screen")
                    }
                }
            }
        }
    }
}
