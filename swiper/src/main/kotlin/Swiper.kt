import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager

@OptIn(ExperimentalPagerApi::class)
@Composable
fun Swiper(
    modifier: Modifier = Modifier,
    state: SwiperState<Any>
) {
    HorizontalPager(count = state.list.size) {

    }
    HorizontalPagerIndicator(
        pagerState = pagerState,
        modifier = Modifier
            .align(Alignment.CenterHorizontally)
            .padding(16.dp),
    )
}