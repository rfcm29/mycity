package intro.android.mycity.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.appcompat.view.menu.ActionMenuItemView
import androidx.recyclerview.widget.RecyclerView
import intro.android.mycity.R
import intro.android.mycity.dataclasses.Nota
import kotlinx.android.synthetic.main.item.view.*

class ListaAdapter internal constructor(
        context: Context
): RecyclerView.Adapter<ListaAdapter.ListaViewHolder>() {

    private val inflater: LayoutInflater = LayoutInflater.from(context)
    private var notas = emptyList<Nota>()

    class ListaViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val listaItemView: TextView = itemView.findViewById(R.id.titulo)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListaViewHolder {
        val itemView = inflater.inflate(R.layout.item, parent, false)
        return ListaViewHolder(itemView)
    }

    override fun getItemCount() = notas.size

    override fun onBindViewHolder(holder: ListaViewHolder, position: Int) {
        val current = notas[position]
        holder.listaItemView.text = current.titulo
    }

    internal fun setNotas(notas: List<Nota>) {
        this.notas = notas
        notifyDataSetChanged()
    }
}