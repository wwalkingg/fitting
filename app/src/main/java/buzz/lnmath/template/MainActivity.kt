package buzz.lnmath.template

import HomeScreen
import HomeViewModel
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.ui.Modifier
import buzz.lnmath.template.ui.theme.TemplateTheme
import module
import org.koin.androidx.viewmodel.ext.android.viewModel
import org.koin.core.context.startKoin

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        startKoin {
            modules(module)
            super.onCreate(savedInstanceState)
            setContent {
                TemplateTheme {
                    // A surface container using the 'background' color from the theme
                    Surface(
                        modifier = Modifier.fillMaxSize(),
                        color = MaterialTheme.colorScheme.background
                    ) {
                        Text(text = "asd")
                        val homeViewModel: HomeViewModel by viewModel()
                        HomeScreen(homeViewModel)
                    }
                }
            }
        }
    }
}