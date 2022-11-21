import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import com.example.homework_2.Item
import com.example.homework_2.PassContextToProvider
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class MyViewModel(private val state: SavedStateHandle) : ViewModel() {
    private val KEY = "KEY"

    private val mutableLiveData: MutableLiveData<ArrayList<Item>> =
        state.getLiveData(KEY, arrayListOf())

    val items: LiveData<ArrayList<Item>> = mutableLiveData

    private val provider = PassContextToProvider.provider()

    // TODO pagination
    // TODO numbers from res resources.getInteger(R.integer.column_count)
    suspend fun getItems() {
        val list = withContext(Dispatchers.IO) {
            provider.getItems(10, 0)
        }
        mutableLiveData.value = list
    }
}