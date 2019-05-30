package com.ynov.kotlin.rickmorty.data.entity

import com.ynov.kotlin.rickmorty.data.entity.Remote.Gender
import com.ynov.kotlin.rickmorty.data.entity.Remote.Location
import com.ynov.kotlin.rickmorty.data.entity.Remote.Species
import com.ynov.kotlin.rickmorty.data.entity.Remote.Status

data class RMCompletCharacterModel (
    val id: Long,
    val name: String,
    val status: Status,
    val species: Species,
    val type: String,
    val gender: Gender,
    val origin: Location,
    val location: Location,
    val image: String,
    val episode: List<String>,
    val url: String,
    val created: String
)