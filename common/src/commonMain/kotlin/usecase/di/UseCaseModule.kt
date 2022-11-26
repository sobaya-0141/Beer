package usecase.di

import org.koin.dsl.module
import usecase.GetBeersUseCase

val useCaseModule = module {
    single { GetBeersUseCase(get()) }
}