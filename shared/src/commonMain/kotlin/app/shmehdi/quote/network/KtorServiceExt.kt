package app.shmehdi.quote.network

import io.ktor.client.features.*
import io.ktor.client.request.*
import app.shmehdi.quote.models.dto.BaseResponse

const val UNKNOWN_ERROR = -1
const val SOMETHING_WENT_WRONG = "Something went wrong"


suspend inline fun <reified D> KtorService.postApiCall(endpoints: String, body: Any): BaseResponse<D> {
    return try {
         client.post(host = baseUrl, path = endpoints, body = body)
    } catch (e: Exception) {
        e.handleErrors()
    }
}

suspend inline fun <reified D> KtorService.getApiCall(endpoints: String): BaseResponse<D> {
    return try {
        client.get(host = baseUrl, path = endpoints)
    } catch (e: Exception) {
        e.handleErrors()
    }
}

suspend inline fun <reified D> KtorService.putApiCall(endpoints: String, body: Any): BaseResponse<D> {
    return try {
        client.put(host = baseUrl, path = endpoints, body = body)
    } catch (e: Exception) {
        e.handleErrors()
    }
}

suspend inline fun <reified D> KtorService.deleteApiCall(endpoints: String): BaseResponse<D> {
    return try {
        client.put(host = baseUrl, path = endpoints)
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