import androidx.lifecycle.ViewModel
import com.example.homework_2.ServiceLocator

class MyViewModel : ViewModel() {
    private val provider = ServiceLocator.provider()
    // TODO pagination
    // TODO numbers from res
    suspend fun getItems() = provider.getItems(5, 0)
}