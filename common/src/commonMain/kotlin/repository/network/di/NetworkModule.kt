package repository.network.di

import de.jensklingenberg.ktorfit.Ktorfit
import de.jensklingenberg.ktorfit.create
import io.ktor.client.*
import io.ktor.client.plugins.contentnegotiation.*
import io.ktor.client.plugins.logging.*
import io.ktor.serialization.kotlinx.json.*
import kotlinx.serialization.json.Json
import repository.network.service.BeerService

val ktorfitBuilder = Ktorfit
    .Builder()
    .httpClient(
        HttpClient {
            install(ContentNegotiation) {
                json(Json { isLenient = true; ignoreUnknownKeys = true })
                install(Logging)
            }
        }
    )
    .responseConverter()

val beerKtorfit = ktorfitBuilder.baseUrl("https://api.punkapi.com/v2/").build()
val beerService = beerKtorfit.create<BeerService>()