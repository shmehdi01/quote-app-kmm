package app.shmehdi.quote.network.services

import app.shmehdi.quote.models.dto.AuthResponse
import app.shmehdi.quote.models.dto.BaseResponse
import app.shmehdi.quote.models.dto.LoginRequest
import app.shmehdi.quote.models.dto.RegisterRequest

interface AuthService {

    suspend fun login(request: LoginRequest) : BaseResponse<AuthResponse>

    suspend fun register(request: RegisterRequest) : BaseResponse<AuthResponse>
}