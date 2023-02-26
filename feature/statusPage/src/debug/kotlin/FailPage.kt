import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier

@Composable
fun FailPage(modifier: Modifier = Modifier, onReloadClick: () -> Unit) {
    Surface(modifier = modifier, color = MaterialTheme.colorScheme.errorContainer) {
        Box(modifier = Modifier.fillMaxSize()) {
            Column(modifier = Modifier.align(Alignment.Center), horizontalAlignment = Alignment.CenterHorizontally) {
                Text(text = "Page Load Error!!!")
                TextButton(onClick = onReloadClick) {
                    Text(text = "Reload")
                }
            }
        }
    }
}