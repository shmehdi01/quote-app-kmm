package app.shmehdi.quote.models.pojo

data class Quote(
    val id: Int,
    val quote: String,
    val author: String,
    val authorId: String?,
    val userId: Int,
    val isActive: Boolean
)