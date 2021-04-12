package com.example.prova2pdm

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.navArgs
import com.example.prova2pdm.databinding.FragmentAlteraBinding

class AlteraFragment : Fragment() {
    lateinit var binding: FragmentAlteraBinding
    lateinit var viewmodel: AlteraFragmentViewModel


    val args: AlteraFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View?{
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_altera, container, false)
        viewmodel = ViewModelProvider(this).get(AlteraFragmentViewModel::class.java)

        viewmodel.getPraia(args.gameid)

        binding.editTextCategoriaAltera.setText(viewmodel.name)


        return binding.root
    }
}


