package app.shmehdi.quote.utils.preference.core

import app.shmehdi.quote.utils.KContext

expect fun KContext.putInt(key: String, value: Int)

expect fun KContext.getInt(key: String, default: Int): Int

expect fun KContext.putString(key: String, value: String)

expect fun KContext.getString(key: String) : String?

expect fun KContext.putBool(key: String, value: Boolean)

expect fun KContext.getBool(key: String, default: Boolean): Boolean
