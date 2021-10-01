package app.shmehdi.quote.android.ui.auth

import androidx.lifecycle.viewModelScope
import app.shmehdi.quote.android.base.BaseViewModel
import app.shmehdi.quote.android.ui.states.AuthUIState
import app.shmehdi.quote.models.dto.LoginRequest
import app.shmehdi.quote.repository.AuthRepository
import app.shmehdi.quote.utils.preference.AppPreference
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import shmehdi.app.estore.vo.Status
import javax.inject.Inject

@HiltViewModel
class AuthViewModel @Inject constructor(private val repository: AuthRepository): BaseViewModel() {

    @Inject
    lateinit var appPreference: AppPreference

    fun login(request: LoginRequest) {
        viewModelScope.launch {
            repository.login(request).collectCommon { resource ->

                when(resource.status) {
                    Status.SUCCESS -> {
                        appPreference.saveToken("token", resource.data?.token!!)
                        notifySuccess(AuthUIState.AuthSuccess(resource.data!!))
                    }
                    Status.LOADING -> {
                       notifyLoading()
                    }
                    Status.ERROR -> {
                        notifyError(resource.error)
                    }
                }
            }
        }
    }
}