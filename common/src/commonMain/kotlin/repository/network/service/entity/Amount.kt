package repository.network.service.entity

import kotlinx.serialization.Serializable

@Serializable
data class Amount(
    val unit: String,
    val value: Double
)