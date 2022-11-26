package repository.network.service.entity

import kotlinx.serialization.Serializable

@Serializable
data class Malt(
    val amount: Amount,
    val name: String
)