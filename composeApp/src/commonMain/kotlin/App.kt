import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationRail
import androidx.compose.material3.NavigationRailItem
import androidx.compose.material3.Surface
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import com.example.navarticle.ui.main.MainInteractions
import com.example.navarticle.ui.main.MainViewModel
import org.jetbrains.compose.ui.tooling.preview.Preview
import org.koin.compose.getKoin
import org.koin.compose.viewmodel.koinViewModel
import org.koin.core.parameter.parametersOf

@Composable
@Preview
fun App() {
    MaterialTheme {
        val navController = rememberNavController()
        val mainViewModel = koinViewModel<MainViewModel> { parametersOf(navController) }

        Surface(Modifier.fillMaxWidth()) {
            Row {
                NavigationRail {
                    mainViewModel.navigationAreas.forEach { item ->
                        NavigationRailItem(
                            selected = mainViewModel.selectedItem.collectAsState().value == item,
                            onClick = { mainViewModel.onInteraction(MainInteractions.NavigateTo(item)) },
                            icon = item.icon,
                        )
                    }
                }
                Box(Modifier.weight(1f).fillMaxHeight()) {
                    NavHost(
                        mainViewModel.navController,
                        startDestination =
                            mainViewModel.selectedItem.value.route,
                    ) {
                        mainViewModel.navigatables.forEach { it.display(this) }
                    }
                }
            }
        }
    }
}
