package com.example.prova2pdm

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class AtletaAdapter : RecyclerView.Adapter<PraiaViewHolder>(){
    var praias: List<Praia> = ArrayList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PraiaViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.praia_inflater, parent, false)
        return PraiaViewHolder(v)
    }

    override fun onBindViewHolder(holder: PraiaViewHolder, position: Int) {
        val selectedPraia = praias[position]
        holder.praiaName.text = selectedPraia.name

    }

    override fun getItemCount(): Int {
        return praias.size
    }
}
class PraiaViewHolder(v: View) : RecyclerView.ViewHolder(v) {
    val praiaName = v.findViewById<TextView>(R.id.namePraia)

}