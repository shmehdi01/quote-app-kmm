package app.shmehdi.quote.repository

import app.shmehdi.quote.models.dto.AuthResponse
import app.shmehdi.quote.models.dto.LoginRequest
import app.shmehdi.quote.models.dto.RegisterRequest
import app.shmehdi.quote.models.dto.validate
import app.shmehdi.quote.utils.CommonFlow
import app.shmehdi.quote.utils.asCommonFlow
import kotlinx.coroutines.flow.flow
import shmehdi.app.estore.vo.Resource

class AuthRepository : BaseRepository() {

    suspend fun login(request: LoginRequest): CommonFlow<Resource<AuthResponse>> =
        flow {
            emit(Resource.loading())
            emit(apiService.login(request.validate()).toResource())
        }.asCommonFlow()


    suspend fun register(request: RegisterRequest): CommonFlow<Resource<AuthResponse>> =
        flow {
            emit(Resource.loading())
            emit(apiService.register(request.validate()).toResource())
        }.asCommonFlow()

}