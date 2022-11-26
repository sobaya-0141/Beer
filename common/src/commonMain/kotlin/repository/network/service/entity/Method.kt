package repository.network.service.entity

import kotlinx.serialization.Serializable

@Serializable
data class Method(
    val fermentation: Fermentation,
    val mash_temp: List<MashTemp>,
    val twist: String?
)