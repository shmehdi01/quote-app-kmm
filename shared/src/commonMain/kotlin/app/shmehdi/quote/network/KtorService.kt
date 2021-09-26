package app.shmehdi.quote.network

import app.shmehdi.quote.models.dto.AuthResponse
import app.shmehdi.quote.models.dto.BaseResponse
import app.shmehdi.quote.models.dto.LoginRequest
import app.shmehdi.quote.models.dto.RegisterRequest
import io.ktor.client.*

class KtorService(val baseUrl: String, val client: HttpClient) : ApiService {

    override suspend fun login(request: LoginRequest): BaseResponse<AuthResponse> =
        safeApiCall(endpoints = "login")


    override suspend fun register(request: RegisterRequest): BaseResponse<AuthResponse> =
        safeApiCall(endpoints = "register")

}