package app.shmehdi.quote.models.dto

import app.shmehdi.quote.errors.ValidationError

data class LoginRequest(
    val email: String,
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