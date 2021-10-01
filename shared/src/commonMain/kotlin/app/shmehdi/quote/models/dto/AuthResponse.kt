package app.shmehdi.quote.models.dto

import app.shmehdi.quote.models.pojo.User
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class AuthResponse(
    @SerialName("token")
    val token: String,
    @SerialName("user")
    val user: User
)
