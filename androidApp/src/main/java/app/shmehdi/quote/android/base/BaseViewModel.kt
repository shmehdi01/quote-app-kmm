package app.shmehdi.quote.android.base

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import shmehdi.app.estore.vo.ErrorResource

abstract class BaseViewModel: ViewModel() {

    private val loader = MutableLiveData<Boolean>()
    private val _error = MutableLiveData<ErrorResource>()

    val isLoading get() = loader as LiveData<Boolean>
    val error get() = _error as LiveData<ErrorResource>

    fun notifyLoading(isLoading: Boolean) {
        loader.value = isLoading
    }

    fun notifyError(errorResource: ErrorResource?) {
        _error.value = errorResource ?: ErrorResource("", -1)
    }
}