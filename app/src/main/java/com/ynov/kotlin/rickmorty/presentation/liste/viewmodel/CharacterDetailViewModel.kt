package com.ynov.kotlin.rickmorty.presentation.liste.viewmodel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel;
import com.ynov.kotlin.rickmorty.data.entity.RMCompletCharacterModel
import com.ynov.kotlin.rickmorty.presentation.RMApplication
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.rxkotlin.subscribeBy
import io.reactivex.schedulers.Schedulers

class CharacterDetailViewModel(id: String) : ViewModel() {
    var characterLiveData: MutableLiveData<RMCompletCharacterModel> = MutableLiveData()

    init{
        RMApplication.app.dataRepository.retrieveDetailCharacter(id)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeBy(
                onSuccess = {
                    characterLiveData.postValue(it)
                },
                onError = {
                    Log.e("erreur", "", it)
                }
            )
    }
}
