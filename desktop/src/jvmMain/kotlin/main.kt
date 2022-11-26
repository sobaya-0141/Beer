import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
import org.koin.core.context.startKoin
import org.koin.java.KoinJavaComponent.get
import repository.di.repositoryModule
import usecase.GetBeersUseCase
import usecase.di.useCaseModule

fun main() = application {
    startKoin {
        modules(repositoryModule + useCaseModule)
    }
    Window(onCloseRequest = ::exitApplication) {
        App(get(GetBeersUseCase::class.java))
    }
}