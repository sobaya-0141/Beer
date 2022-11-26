package repository.network.service.entity

import kotlinx.serialization.Serializable

@Serializable
data class Temp(
    val unit: String,
    val value: Int
)