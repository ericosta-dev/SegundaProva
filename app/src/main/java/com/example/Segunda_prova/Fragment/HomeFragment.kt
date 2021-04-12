package com.example.prova2pdm

import android.os.Bundle
import android.view.*
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.NavigationUI
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.prova2pdm.databinding.FragmentHomeBinding

class HomeFragment : Fragment() {
    lateinit var binding: FragmentHomeBinding
    lateinit var viewmodel: HomeFragViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_home, container, false)
        viewmodel = ViewModelProvider(this).get(HomeFragViewModel::class.java)

        val adapter = AtletaAdapter()
        binding.recyclerPraiaList.adapter = adapter

        viewmodel.list.observe(viewLifecycleOwner, {
            adapter.praias = it
            adapter.notifyDataSetChanged()
        })

        setHasOptionsMenu(true)

        val layout = LinearLayoutManager(parentFragment?.requireContext(), LinearLayoutManager.VERTICAL, false)
        binding.recyclerPraiaList.layoutManager = layout

        binding.recyclerPraiaList.addOnItemTouchListener(
            RecyclerViewClickListener(this.requireContext(),
                binding.recyclerPraiaList,
                object : RecyclerViewClickListener.onItemClickListener {
                    override fun onItemCLick(v: View, position: Int) {

                        Navigation.findNavController(v).navigate(
                                HomeFragmentDirections.actionHomeFragmentToDetalhesFragment()
                        )
                    }

                    override fun onItemLongClick(v: View, position: Int) {
                        Navigation.findNavController(v).navigate(
                            HomeFragmentDirections.actionHomeFragmentToAlteraFragment().setGameid(viewmodel.list.value!![position].id)
                        )
                    }
                })
        )
        return binding.root
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.home_menu, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return NavigationUI.onNavDestinationSelected(item, this.findNavController()) || super.onOptionsItemSelected(item)
    }
}