package com.ynov.kotlin.rickmorty.presentation

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.ynov.kotlin.rickmorty.R
import com.ynov.kotlin.rickmorty.presentation.liste.viewmodel.ListFragment
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import io.reactivex.rxkotlin.subscribeBy
import java.util.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)



        supportFragmentManager.beginTransaction()
            .replace(R.id.main_activity_fragment_container, ListFragment())
            .commit()

    }

    companion object {

        fun newIntent(context: Context, persoId: Long): Intent {
            val intent = Intent(context, DetailActivity::class.java)
            intent.putExtra("persoId", persoId.toString())
            return intent
        }
    }
}
