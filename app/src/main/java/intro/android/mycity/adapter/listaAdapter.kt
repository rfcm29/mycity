package intro.android.mycity.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import intro.android.mycity.R
import intro.android.mycity.dataclasses.Nota
import kotlinx.android.synthetic.main.item.view.*

class ListaAdapter(val list: ArrayList<Nota>):RecyclerView.Adapter<LineViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LineViewHolder {

        val itemView = LayoutInflater
                .from(parent.context)
                .inflate(R.layout.item, parent, false)
        return LineViewHolder(itemView)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: LineViewHolder, position: Int) {
        val currentItem = list[position]

        holder.titulo.text = currentItem.titulo
        holder.data.text = currentItem.data.toString()
    }

}

class LineViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){

    val titulo = itemView.titulo
    val data = itemView.data
}