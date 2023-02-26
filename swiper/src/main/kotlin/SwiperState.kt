import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.PagerState

class SwiperState<E>(currentItem: Int) {
    @OptIn(ExperimentalPagerApi::class)
    val pagerState = PagerState(currentItem)
    val list: List<E> = listOf()
}

@Composable
fun <T> rememberSwiperState(currentItem: Int): SwiperState<T> {
    return remember { SwiperState(currentItem) }
}