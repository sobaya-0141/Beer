package repository.network.service.entity

import kotlinx.serialization.Serializable

@Serializable
data class Fermentation(
    val temp: Temp
)