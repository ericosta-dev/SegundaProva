package com.example.prova2pdm

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class DetalhesAdapter : RecyclerView.Adapter<DetalhesPraiaViewHolder>(){
    var praias: List<Praia> = ArrayList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int):DetalhesPraiaViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.fragment_detalhes, parent, false)
        return DetalhesPraiaViewHolder(v)
    }

    override fun onBindViewHolder(holder: DetalhesPraiaViewHolder, position: Int) {
        val selectedPraia = praias[position]
        holder.praiaName.text = selectedPraia.name
    }

    override fun getItemCount(): Int {
        return praias.size
    }
}


class DetalhesPraiaViewHolder(v: View) : RecyclerView.ViewHolder(v) {

    val praiaName = v.findViewById<TextView>(R.id.namePraia)
}
