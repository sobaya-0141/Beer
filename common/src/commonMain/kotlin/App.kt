import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.Modifier
import io.kamel.image.KamelImage
import io.kamel.image.lazyPainterResource
import repository.network.service.entity.BeersItem
import usecase.GetBeersUseCase

@Composable
fun App(getBeersUseCase: GetBeersUseCase) {
    MaterialTheme {
        val state = mutableStateOf<List<BeersItem>?>(null)
        LaunchedEffect(getBeersUseCase) {
            val beers = getBeersUseCase(this)
            state.value = beers
        }

        LazyVerticalGrid(columns = GridCells.Fixed(3), modifier = Modifier) {
            state.value?.let {
                items(
                    items = it,
                    key = { it.id }
                ) {
                    Column {
                        Text(it.name)
                        KamelImage(
                            resource = lazyPainterResource(it.image_url),
                            contentDescription = null
                        )
                    }
                }
            }
        }
    }
}
