import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import com.example.homework_2.PassContextToProvider

class MyViewModel(private val state: SavedStateHandle) : ViewModel() {
    private val KEY = "KEY"

//    private val mutableLiveData: MutableLiveData<ArrayList<Die>> =
//        state.getLiveData(KEY, arrayListOf())

    private val provider = PassContextToProvider.provider()

    // TODO pagination
    // TODO numbers from res resources.getInteger(R.integer.column_count)
    suspend fun getItems() = provider.getItems(10, 0)
}