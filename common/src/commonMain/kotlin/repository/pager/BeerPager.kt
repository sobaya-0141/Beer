package repository.pager

import com.kuuurt.paging.multiplatform.Pager
import com.kuuurt.paging.multiplatform.PagingConfig
import com.kuuurt.paging.multiplatform.PagingResult
import kotlinx.coroutines.CoroutineScope
import repository.BeerRepository
import repository.network.service.entity.BeersItem

class BeerPager(
    private val beerRepository: BeerRepository
) {
    companion object {
        const val PAGE_LIMIT = 50
    }

    fun getPager(coroutineScope: CoroutineScope): Pager<Int, BeersItem> = Pager(
        clientScope = coroutineScope,
        config = PagingConfig(
            pageSize = PAGE_LIMIT,
            enablePlaceholders = false
        ),
        initialKey = 0,
        getItems = { currentKey, size ->
            val items = beerRepository.getBeers(currentKey, PAGE_LIMIT)
            PagingResult(
                items = items,
                currentKey = currentKey,
                prevKey = {
                    if (currentKey > 0) {
                        currentKey - 1
                    } else {
                        null
                    }
                },
                nextKey = {
                    if (PAGE_LIMIT == items.size) {
                        currentKey + 1
                    } else {
                        null
                    }
                }
            )
        }
    )
}