package shmehdi.app.estore.vo

//sealed class Resource<out T> {
//
//    object Loading: Resource<Nothing>()
//    class Result<T>(val data: T): Resource<T>()
//    class Error(val errorResource: ErrorResource): Resource<Nothing>()
//}

data class Resource<T> (val status: Status, val error: ErrorResource?, val data: T?) {

    companion object {

        fun <T> error(error: ErrorResource): Resource<T> {
            return Resource(
                Status.ERROR,
                error = error,
                data = null
            )
        }

        fun <T> loading(): Resource<T> {
            return Resource(
                Status.LOADING,
                error = null,
                data = null
            )
        }

        fun <T> result(data: T): Resource<T> {
            return Resource(
                Status.SUCCESS,
                error = null,
                data = data
            )
        }

    }
}

data class ErrorResource(val errorMessage: String, val errorCode: Int)

enum class Status {
    SUCCESS,
    LOADING,
    ERROR
}