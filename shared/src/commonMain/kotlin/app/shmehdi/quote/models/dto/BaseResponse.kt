package app.shmehdi.quote.models.dto

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class BaseResponse<T> (
    @SerialName("status")
    val status: Boolean = true,
    @SerialName("code")
    val code: Int = 200,
    @SerialName("message")
    val message: String = "",
    @SerialName("data")
    val data: T?
)
