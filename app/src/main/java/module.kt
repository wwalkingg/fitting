import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val module = module {
    single<FittingRepository> { FittingRepositoryFake() }
    viewModel { HomeViewModel(get()) }
}