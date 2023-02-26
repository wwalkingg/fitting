import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import androidx.compose.ui.util.lerp
import coil.compose.AsyncImage
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.calculateCurrentOffsetForPage
import kotlinx.collections.immutable.PersistentList
import kotlinx.collections.immutable.toPersistentList
import kotlin.math.absoluteValue

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(homeViewModel: HomeViewModel) {
    val uiState by homeViewModel.uiState.collectAsState()
    when (uiState) {
        UIState.Fail -> FailPage(onReloadClick = homeViewModel::loadData)
        UIState.Loading -> LoadingPage()
        is UIState.Success -> {
            Home(uiState as UIState.Success)
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
internal fun Home(uiState: UIState.Success) {
    Scaffold(topBar = { TopBar() }) {
        Column(modifier = Modifier.padding(it)) {
            Swiper(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(200.dp),
                swiper = uiState.swiper.toPersistentList()
            )
        }
    }
}

@Composable
internal fun TopBar() {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(5.dp)
    ) {
        Text(
            text = "Fitting",
            modifier = Modifier.align(Alignment.Center),
            style = MaterialTheme.typography.titleMedium
        )
        IconButton(
            onClick = { /*TODO*/ },
            modifier = Modifier.align(
                Alignment.TopEnd
            )
        ) {
            Icon(
                imageVector = Icons.Default.Search,
                contentDescription = "search",
            )
        }
    }
}

@OptIn(ExperimentalPagerApi::class)
@Composable
internal fun Swiper(modifier: Modifier = Modifier, swiper: PersistentList<String>) {
    HorizontalPager(modifier = modifier, count = swiper.size) { page ->
        Box(modifier = Modifier
            .graphicsLayer {
                val pageOffset = calculateCurrentOffsetForPage(page).absoluteValue
                lerp(
                    start = 0.85f,
                    stop = 1f,
                    fraction = 1f - pageOffset.coerceIn(0f, 1f)
                ).also { scale ->
                    scaleX = scale
                    scaleY = scale
                }
                alpha = lerp(
                    start = 0.5f,
                    stop = 1f,
                    fraction = 1f - pageOffset.coerceIn(0f, 1f)
                )
            }) {
            AsyncImage(
                modifier = Modifier.fillMaxSize(),
                model = swiper[page],
                contentDescription = null,
                contentScale = ContentScale.Fit,
                onError = {
                    it.result.throwable.printStackTrace()
                })
        }
    }
}