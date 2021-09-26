package app.shmehdi.quote.android.ui.auth

import androidx.lifecycle.viewModelScope
import app.shmehdi.quote.android.base.BaseViewModel
import app.shmehdi.quote.models.dto.AuthResponse
import app.shmehdi.quote.models.dto.LoginRequest
import app.shmehdi.quote.repository.AuthRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import shmehdi.app.estore.vo.Status
import javax.inject.Inject

@HiltViewModel
class AuthViewModel @Inject constructor(private val repository: AuthRepository): BaseViewModel() {


    fun login(request: LoginRequest) {
        viewModelScope.launch {
            repository.login(request).collectCommon { resource ->

                notifyLoading(resource.status == Status.SUCCESS)

                when(resource.status) {
                    Status.SUCCESS -> {

                    }
                    Status.LOADING -> { }
                    Status.ERROR -> {
                        notifyError(resource.error)
                    }
                }
            }
        }
    }
}