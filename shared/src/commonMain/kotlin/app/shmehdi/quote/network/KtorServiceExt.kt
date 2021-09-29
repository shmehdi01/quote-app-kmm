package app.shmehdi.quote.network

import io.ktor.client.features.*
import io.ktor.client.request.*
import app.shmehdi.quote.models.dto.BaseResponse

const val UNKNOWN_ERROR = -1
const val SOMETHING_WENT_WRONG = "Something went wrong"

suspend inline fun <reified D> KtorService.safeApiCall(endpoints: String, apiHasNoBaseResponse: Boolean = false): BaseResponse<D> {
    return try {
        if (apiHasNoBaseResponse) {
            val response = client.get<D>(baseUrl + endpoints)
            BaseResponse(
                status = true,
                data = response
            )
        }
        else client.post(baseUrl + endpoints)
    } catch (e: Exception) {
        e.handleErrors()
    }
}

fun <D> Exception.handleErrors(): BaseResponse<D> {
    return when (this) {
        is ClientRequestException -> {
            BaseResponse(
                status = false,
                code = response.status.value,
                message = message ?: SOMETHING_WENT_WRONG,
                data = null
            )
        }
        else -> {
            BaseResponse(
                status = false,
                code = UNKNOWN_ERROR,
                message = message ?: SOMETHING_WENT_WRONG,
                data = null
            )
        }
    }
}