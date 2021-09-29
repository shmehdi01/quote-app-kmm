package app.shmehdi.quote.utils.preference.core

import app.shmehdi.quote.utils.KContext

const val SP_NAME = "quote"

actual fun KContext.putInt(key: String, value: Int) {
    getSpEditor().putInt(key, value).apply()
}

actual fun KContext.getInt(key: String, default: Int): Int {
    return  getSp().getInt(key, default )
}

actual fun KContext.putString(key: String, value: String) {
    getSpEditor().putString(key, value).apply()
}

actual fun KContext.getString(key: String): String? {
        return  getSp().getString(key, null)
}

actual fun KContext.putBool(key: String, value: Boolean) {
    getSpEditor().putBoolean(key, value).apply()
}

actual fun KContext.getBool(key: String, default: Boolean): Boolean {
  return getSp().getBoolean(key, default)
}

private fun KContext.getSp() = getSharedPreferences(SP_NAME, 0)

private fun KContext.getSpEditor() = getSp().edit()