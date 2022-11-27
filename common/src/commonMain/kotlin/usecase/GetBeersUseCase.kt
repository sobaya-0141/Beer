package usecase

import kotlinx.coroutines.CoroutineScope
import repository.BeerRepository
import repository.network.service.entity.BeersItem

//class GetBeersUseCase(private val beerPager: BeerPager) {
//    operator fun invoke(coroutineScope: CoroutineScope): Pager<Int, BeersItem> = beerPager.getPager(coroutineScope)
//}

class GetBeersUseCase(private val beerRepository: BeerRepository) {
    suspend operator fun invoke(coroutineScope: CoroutineScope): List<BeersItem> = beerRepository.getBeers(1, 50)
}