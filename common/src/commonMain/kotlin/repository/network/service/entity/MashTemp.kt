package repository.network.service.entity

import kotlinx.serialization.Serializable

@Serializable
data class MashTemp(
    val duration: String?,
    val temp: Temp
)