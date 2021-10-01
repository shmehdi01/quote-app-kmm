package app.shmehdi.quote.models.dto


import app.shmehdi.quote.errors.ValidationError
import app.shmehdi.quote.models.pojo.User
import kotlinx.serialization.SerialName

data class RegisterRequest(
    @SerialName("name")
    val name: String,
    @SerialName("email")
    val email: String,
    @SerialName("password")
    val password: String
)

@Throws(ValidationError::class)
fun RegisterRequest.validate(): RegisterRequest {
    var message = ""
    when {
        name.isEmpty() -> message += "Name is empty"
        email.isBlank() -> message += "Email is empty"
        password.isEmpty() -> message += "Password is empty"
    }

    if (message.isNotEmpty()) throw ValidationError(message)
    return this
}

fun RegisterRequest.toUser() = User(
    id = -1,
    name = name,
    email = email,
    password = password,
    isActive = true
)