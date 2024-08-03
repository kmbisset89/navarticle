import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
import com.example.navarticle.module
import org.koin.core.context.startKoin

fun main() = application {
    startKoin {
        modules(module)
    }
    Window(
        onCloseRequest = ::exitApplication,
        title = "Navigation",
    ) {
        App()
    }
}