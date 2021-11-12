package br.com.babyssister.Adapter
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import br.com.babyssister.R
import br.com.babyssister.Classes.PerfilContratanteClasses

class PerfilContratanteRecyclerViewAdapter (private val context: Context, private val lista: ArrayList<PerfilContratanteClasses>,
                                            var itemClickLister: (pessoa: PerfilContratanteClasses) -> Unit) :
    RecyclerView.Adapter<PerfilContratanteRecyclerViewAdapter.ViewHolder>() {

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val tvidadec = view.findViewById<TextView>(R.id.tvidadec)
        val tvgeneroc = view.findViewById<TextView>(R.id.tvgeneroc)
        val tvsobrec = view.findViewById<TextView>(R.id.tvsobrec)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.perfilcontratante, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return lista.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val pessoa = lista[position]
        holder.tvidadec.text = pessoa.idadecrianca
        holder.tvgeneroc.text = pessoa.generocrianca
        holder.tvsobrec.text = pessoa.sobrecrianca

        holder.itemView.setOnClickListener {
            itemClickLister(pessoa)
        }
    }
}