package app.shmehdi.quote.utils.preference

import app.shmehdi.quote.utils.KContext
import app.shmehdi.quote.utils.preference.core.getString
import app.shmehdi.quote.utils.preference.core.putString

class AppPreferenceImpl(private val context: KContext): AppPreference {


    override fun saveToken(key: String, token: String) {
        context.putString(key, token)
    }

    override fun getToken(key: String):String? {
        return context.getString(key)
    }
}