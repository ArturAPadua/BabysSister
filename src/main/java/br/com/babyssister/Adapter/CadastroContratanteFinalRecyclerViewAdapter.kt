package br.com.babyssister.Adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import br.com.babyssister.R
import br.com.babyssister.Classes.CadastroContratanteFinalClasses
import java.util.*


class CadastroContratanteFinalRecyclerViewAdapter(val context: Context, private val lista: ArrayList<CadastroContratanteFinalClasses>,
                                                  var itemClickLister: (crianca: CadastroContratanteFinalClasses) -> Unit) :
    RecyclerView.Adapter<CadastroContratanteFinalRecyclerViewAdapter.ViewHolder>() {

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val teste = view.findViewById<TextView>(R.id.teste)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.cadastrocontratantefinal, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return lista.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val crianca = lista[position]
        holder.teste.text = crianca.quantFilhos

    }

}