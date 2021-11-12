package br.com.babyssister.Adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import br.com.babyssister.Classes.CadastroContratanteFinalClasses
import br.com.babyssister.Classes.PerfilBabaClasses
import br.com.babyssister.R
import java.util.ArrayList

class PerfilBabaRecyclerViewAdapter (private val context: Context, private val lista: ArrayList<PerfilBabaClasses>,
                                     var itemClickLister: (baba: PerfilBabaClasses) -> Unit) :
    RecyclerView.Adapter<PerfilBabaRecyclerViewAdapter.ViewHolder>() {

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val tvhabilidade = view.findViewById<TextView>(R.id.tvhabilidade)
        val tvconfortavel = view.findViewById<TextView>(R.id.tvconfortavel)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.perfilbaba, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return lista.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val baba = lista[position]
        holder.tvhabilidade.text = baba.habilidades
        holder.tvconfortavel.text = baba.confortavelEm

        holder.itemView.setOnClickListener {
            itemClickLister(baba)
        }

    }

}