package repository.network.service.entity

import kotlinx.serialization.Serializable

@Serializable
data class Hop(
    val add: String,
    val amount: Amount,
    val attribute: String,
    val name: String
)