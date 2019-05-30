package com.ynov.kotlin.rickmorty.data.entity.Remote

data class CharactersResult (
    val info: Info,
    val results: List<RMCharacter>
)