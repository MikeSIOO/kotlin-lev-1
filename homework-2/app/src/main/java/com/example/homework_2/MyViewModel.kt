import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import com.example.homework_2.R
import com.example.homework_2.ServiceLocator
import java.security.AccessController.getContext

class MyViewModel(private val state: SavedStateHandle) : ViewModel() {
    private val KEY = "KEY"

//    private val mutableLiveData: MutableLiveData<ArrayList<Die>> =
//        state.getLiveData(KEY, arrayListOf())

    private val provider = ServiceLocator.provider()

    // TODO pagination
    // TODO numbers from res resources.getInteger(R.integer.column_count)
    suspend fun getItems() = provider.getItems(5, 0)
}