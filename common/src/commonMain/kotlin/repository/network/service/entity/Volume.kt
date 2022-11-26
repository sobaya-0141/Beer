package repository.network.service.entity

import kotlinx.serialization.Serializable

@Serializable
data class Volume(
    val unit: String,
    val value: Int
)