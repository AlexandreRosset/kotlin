package com.ynov.kotlin.rickmorty.data

import com.ynov.kotlin.rickmorty.data.entity.RMCharacterModel
import com.ynov.kotlin.rickmorty.data.entity.Remote.RMCharacter
import io.reactivex.Single

class DataRepository(private val service: ApiManager){


    fun RetrieveCharacterList(): Single<List<RMCharacterModel>> {
        return service.retrieveCharacter().map {
            it.map {
                character -> RMCharacterModel(character.name, character.id)
            }
        }
    }

    fun retrieveDetailCharacter(id: String): Single<RMCharacter> {
        return service.retrieveDetailCharacter(id)
    }
}