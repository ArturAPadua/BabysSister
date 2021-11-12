package br.com.babyssister.Adapter
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import br.com.babyssister.R
import br.com.babyssister.Classes.HomeContratanteClasses

class HomeContratanteRecyclerViewAdapter (private val context: Context, private val lista: ArrayList<HomeContratanteClasses>,
                                          var itemClickLister: (pessoa: HomeContratanteClasses) -> Unit) :
    RecyclerView.Adapter<HomeContratanteRecyclerViewAdapter.ViewHolder>() {

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val txtNomeBaba = view.findViewById<TextView>(R.id.txtNomeBaba)
        val txtDescBaba = view.findViewById<TextView>(R.id.txtDescBaba)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.homecontratante, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return lista.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val pessoa = lista[position]
        holder.txtNomeBaba.text = pessoa.nomeBaba
        holder.txtDescBaba.text = pessoa.descBaba

        holder.itemView.setOnClickListener {
            itemClickLister(pessoa)
        }
    }
}