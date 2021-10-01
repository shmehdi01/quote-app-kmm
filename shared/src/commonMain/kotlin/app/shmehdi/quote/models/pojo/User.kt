package app.shmehdi.quote.models.pojo

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class User(
    @SerialName("id")
    val id: Int,
    @SerialName("name")
    val name: String,
    @SerialName("password")
    val password: String,
    @SerialName("email")
    val email: String,
    @SerialName("isActive")
    val isActive: Boolean
)