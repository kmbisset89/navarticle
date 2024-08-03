package com.example.navarticle.ui.test.second

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.BackHand
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
import androidx.navigation.toRoute
import com.example.navarticle.bl.INavigationArea
import com.example.navarticle.ui.ComposableViewModel
import com.example.navarticle.ui.test.TestScreens
import org.koin.compose.getKoin
import org.koin.core.parameter.parametersOf

class TestSecondArea : INavigationArea {
    override fun display(navGraphBuilder: NavGraphBuilder) {
        navGraphBuilder.composable<TestScreens.TestSecondScreen> {
            TestSecond(it.toRoute())
        }
    }

    @Composable
    private fun TestSecond(args: TestScreens.TestSecondScreen) {
        val koin = getKoin()
        Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
            ComposableViewModel({ koin.get<TestSecondScreenViewModel> { parametersOf(args.text) } }) { viewModel ->
                Column(horizontalAlignment = Alignment.CenterHorizontally) {
                    Icon(Icons.Default.BackHand, contentDescription = "Test", modifier = Modifier.size(96.dp))
                    Text(text = viewModel.title, style = MaterialTheme.typography.headlineLarge)
                    Button(
                        onClick = { viewModel.onInteraction(TestSecondScreenInteractions.GoToBack) },
                        enabled = viewModel.goBackAvailable,
                    ) {
                        Text("Go back")
                    }
                }
            }
        }
    }
}
