package app.shmehdi.quote.models.dto

import app.shmehdi.quote.errors.ValidationError
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class LoginRequest(
    @SerialName("email")
    val email: String,
    @SerialName("password")
    val password: String
)


@Throws(ValidationError::class)
fun LoginRequest.validate(): LoginRequest {
    var message = ""
    when {
        email.isBlank() -> message = "Email is empty"
        password.isEmpty() -> message = "Password is empty"
    }

    if (message.isNotEmpty()) throw ValidationError(message)
    return this
}