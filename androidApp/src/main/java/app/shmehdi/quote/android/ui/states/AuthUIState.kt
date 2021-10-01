package app.shmehdi.quote.android.ui.states

import app.shmehdi.quote.models.dto.AuthResponse
import shmehdi.app.estore.vo.ErrorResource

sealed class AuthUIState : UIState {
    data class AuthSuccess(val authResponse: AuthResponse) : AuthUIState()
}


sealed interface UIState {
    object Idle : UIState
    data class Error(val resource: ErrorResource) : UIState
    object Loading : UIState
}