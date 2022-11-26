package repository.network.service.entity

import kotlinx.serialization.Serializable

@Serializable
data class BoilVolume(
    val unit: String,
    val value: Int
)