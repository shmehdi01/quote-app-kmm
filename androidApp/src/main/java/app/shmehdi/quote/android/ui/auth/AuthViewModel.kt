package app.shmehdi.quote.android.ui.auth

import android.util.Log
import androidx.lifecycle.viewModelScope
import app.shmehdi.quote.android.base.BaseViewModel
import app.shmehdi.quote.android.ui.auth.screens.logD
import app.shmehdi.quote.models.dto.AuthResponse
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
        logD("Login Method")
        viewModelScope.launch {
            repository.login(request).collectCommon { resource ->

                notifyLoading(resource.status == Status.SUCCESS)

                when(resource.status) {
                    Status.SUCCESS -> {
                        Log.d("VIEWMODEL", "SUCCESS ${resource.data?.user?.name}")
                        logD("SUCCESS ${resource.data}")
                        appPreference.saveToken("token", resource.data?.token!!)
                    }
                    Status.LOADING -> {
                        logD("Login")
                    }
                    Status.ERROR -> {
                        notifyError(resource.error)
                        logD("Error ${resource.error}")
                    }
                }
            }
        }
    }
}