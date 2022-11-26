package repository.network.service

import de.jensklingenberg.ktorfit.http.GET
import de.jensklingenberg.ktorfit.http.Query
import kotlinx.coroutines.flow.Flow
import repository.network.service.entity.BeersItem

interface BeerService {
    @GET("beers")
    suspend fun getBeers(@Query("page") page: Int = 1, @Query("per_page") perPage: Int = 50): List<BeersItem>
}