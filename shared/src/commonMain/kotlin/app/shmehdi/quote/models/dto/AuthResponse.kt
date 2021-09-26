package app.shmehdi.quote.models.dto

import app.shmehdi.quote.models.pojo.User

data class AuthResponse(
    val token: String,
    val user: User
)
