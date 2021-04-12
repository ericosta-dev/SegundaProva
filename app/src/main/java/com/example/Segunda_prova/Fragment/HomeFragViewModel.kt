package com.example.prova2pdm

import android.annotation.SuppressLint
import android.app.Application
import android.os.AsyncTask
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.room.Room

class HomeFragViewModel (application: Application) : AndroidViewModel(application) {

    var list: LiveData<List<Praia>>

    var dba: AppDatabase

    init {
        val db:AppDatabase by lazy {
            Room.databaseBuilder(application.applicationContext,
                AppDatabase::class.java, "praia.sqlite")
                .build()
        }
        dba = db
        list = FindAllAsync().execute().get()
    }

    @SuppressLint("StaticFieldLeak")
    private inner class FindAllAsync() : AsyncTask<Unit, Unit, LiveData<List<Praia>>>() {
        override fun doInBackground(vararg params: Unit?): LiveData<List<Praia>> {
            return dba.praiaDao().listAll()
        }
    }
}