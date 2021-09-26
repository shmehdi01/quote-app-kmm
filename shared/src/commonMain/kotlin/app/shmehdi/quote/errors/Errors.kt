package app.shmehdi.quote.errors

open class ValidationError(message: String) : Exception(message)

class UserAlreadyExist(message: String): ValidationError(message)

class NotFoundException(message: String, val code: Int = 404): Exception(message)

class InvalidCredentialException(message: String): Exception(message)