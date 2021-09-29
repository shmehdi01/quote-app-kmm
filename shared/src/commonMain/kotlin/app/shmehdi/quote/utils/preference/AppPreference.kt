package app.shmehdi.quote.utils.preference

interface AppPreference {

    fun saveToken(key: String, token: String)

    fun getToken(key: String): String?
}
