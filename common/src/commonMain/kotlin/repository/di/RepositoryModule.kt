package repository.di

import org.koin.dsl.module
import repository.BeerRepository
import repository.network.di.beerService
import repository.pager.BeerPager

val repositoryModule = module {
    single { beerService }
    single { BeerRepository(get()) }
    single { BeerPager(get()) }
}