package app.shmehdi.quote.network

import io.ktor.client.*

expect class KtorClientFactory() {
    fun create(): HttpClient
}