package repository

import repository.network.service.BeerService
import repository.network.service.entity.BeersItem

class BeerRepository(private val beerService: BeerService) {
    suspend fun getBeers(page: Int, perPage: Int): List<BeersItem> = beerService.getBeers(page, perPage)
}