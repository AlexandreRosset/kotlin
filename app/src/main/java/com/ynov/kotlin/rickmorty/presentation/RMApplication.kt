package com.ynov.kotlin.rickmorty.presentation

import android.app.Application
import com.ynov.kotlin.rickmorty.data.ApiManager
import com.ynov.kotlin.rickmorty.data.DataRepository

class RMApplication: Application() {

    companion object {
        lateinit var app: RMApplication
            private set
    }

    lateinit var dataRepository: DataRepository
        private set

    override fun onCreate() {
        super.onCreate()
        app = this
        initInjection()

    }

    private fun initInjection(){
        var apiManager = ApiManager()
        dataRepository = DataRepository(apiManager)
    }
}