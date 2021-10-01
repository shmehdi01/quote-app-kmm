package app.shmehdi.quote.android.base

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import app.shmehdi.quote.android.ui.states.UIState
import shmehdi.app.estore.vo.ErrorResource

abstract class BaseViewModel: ViewModel() {


    fun notifyLoading() {
        state.value = UIState.Loading
    }

    fun notifyError(errorResource: ErrorResource?) {
        state.value = UIState.Error(errorResource ?: ErrorResource("", -1))
    }

    fun notifySuccess(uiState: UIState) {
        state.value = uiState
    }

    val state = mutableStateOf<UIState>(UIState.Idle)

    //inline fun<reified T> getState() = state as State<T>
}