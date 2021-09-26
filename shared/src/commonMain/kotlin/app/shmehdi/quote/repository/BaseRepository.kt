package app.shmehdi.quote.repository

import app.shmehdi.quote.models.dto.BaseResponse
import app.shmehdi.quote.network.KtorClientFactory
import app.shmehdi.quote.network.KtorService
import shmehdi.app.estore.vo.ErrorResource
import shmehdi.app.estore.vo.Resource


abstract class BaseRepository {

    val apiService = KtorService(baseUrl = "http://0.0.0.0:8080/api/v1/", KtorClientFactory().create())

    fun <T> BaseResponse<T>.toResource(): Resource<T> {
        return if (status) {
            Resource.result(data = data!!)
        } else
            Resource.error(error = ErrorResource(
                errorCode = code,
                errorMessage = message
            )
            )
    }
}