package com.example.prova2pdm

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.prova2pdm.databinding.FragmentCadastraBinding

class CadastraFragment : Fragment() {
    lateinit var viewmodel: CadastraFragViewModel
    lateinit var binding: FragmentCadastraBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?

    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_cadastra, container, false)
        viewmodel = ViewModelProvider(this).get(CadastraFragViewModel::class.java)


        binding.button.setOnClickListener {
            viewmodel.name = binding.editTextName.text.toString()
            viewmodel.cidade = binding.editTextCidade.text.toString()
            viewmodel.estado = binding.editTextEstado.text.toString()
            viewmodel.descricao = binding.editTextDescricao.text.toString()
            viewmodel.ano = binding.editTextAno.text.toString().toInt()
            viewmodel.nota = binding.editTextNota.text.toString().toInt()

            viewmodel.createPraia()
        }

        return binding.root
    }
}