package com.example.prova2pdm

import android.annotation.SuppressLint
import android.app.Application
import android.os.AsyncTask
import androidx.lifecycle.AndroidViewModel
import androidx.room.Room

class AlteraFragmentViewModel (application: Application) : AndroidViewModel(application) {
    private var dba: AppDatabase
    private lateinit var Praia: Praia

    init {
        val db:AppDatabase by lazy {
            Room.databaseBuilder(application.applicationContext,
                AppDatabase::class.java, "praias.sqlite")
                .build()
        }
        dba = db
    }

    var id: Int = 0
    var name: String = ""
    var cidade: String = ""
    var estado: String = ""
    var descricao: String = ""
    var ano: Int = 0
    var nota: Int = 0

    fun getPraia(id: Int) {
        var praia = GetPraiaAsync(id).execute().get()

        this.id = praia.id
        this.name = praia.name
        this.cidade = praia.cidade
        this.estado = praia.estado
        this.descricao = praia.descricao
        this.ano = praia.ano
        this.nota = praia.nota
    }

    @SuppressLint("StaticFieldLeak")
    private inner class UpdateGameAsync() : AsyncTask<Unit, Unit, Unit>() {
        override fun doInBackground(vararg params: Unit?) {
            val a = Praia(
                name,
                cidade,
                estado,
                descricao,
                ano,
                nota
            )

            a.id = id
            dba.praiaDao().update(a)
        }
    }

    @SuppressLint("StaticFieldLeak")
    private inner class GetPraiaAsync(var id: Int) : AsyncTask<Unit, Unit, Praia>() {
        override fun doInBackground(vararg params: Unit?): Praia {
            return dba.praiaDao().findById(id)
        }
    }
}