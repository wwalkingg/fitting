import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class HomeViewModel(
    private val fittingRepository: FittingRepository
) : ViewModel() {
    private val _uiState = MutableStateFlow<UIState>(UIState.Loading)
    internal val uiState = _uiState.asStateFlow()

    init {
        loadData()
    }

    fun loadData() {
        viewModelScope.launch {
            _uiState.emit(UIState.Success(fittingRepository.swiper()))
        }
    }
}