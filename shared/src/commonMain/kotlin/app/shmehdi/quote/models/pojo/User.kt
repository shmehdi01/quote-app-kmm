package app.shmehdi.quote.models.pojo

data class User(
    val id: Int,
    val name: String,
    val password: String,
    val email: String,
    val isActive: Boolean
)