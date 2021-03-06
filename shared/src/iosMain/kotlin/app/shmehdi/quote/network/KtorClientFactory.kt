package app.shmehdi.quote.network

import io.ktor.client.*
import io.ktor.client.engine.ios.*
import io.ktor.client.features.json.*
import io.ktor.client.features.json.serializer.*

actual class KtorClientFactory {
    actual fun create(): HttpClient = HttpClient(Ios) {
        install(JsonFeature){
            serializer = KotlinxSerializer(
                json = kotlinx.serialization.json.Json {
                    ignoreUnknownKeys = true
                }
            )
        }
    }
}