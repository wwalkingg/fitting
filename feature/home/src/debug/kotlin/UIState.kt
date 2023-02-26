import androidx.compose.runtime.Stable

@Stable
internal sealed interface UIState {
    object Loading:UIState
    object Fail:UIState
    data class Success(
        val swiper: List<String>
    ):UIState
}