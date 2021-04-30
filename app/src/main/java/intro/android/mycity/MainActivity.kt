package intro.android.mycity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import intro.android.mycity.dataclasses.Nota
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import intro.android.mycity.adapter.ListaAdapter
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*
import kotlin.collections.ArrayList

class MainActivity : AppCompatActivity() {

    private lateinit var listaNotas: ArrayList<Nota>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val recyclerView = findViewById<RecyclerView>(R.id.lista)
        val adapter = ListaAdapter(this)
        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(this)
    }

    fun insert(view: View) {

        listaNotas.add(0, Nota("asass", Date(1997,12,29)))
        lista.adapter?.notifyDataSetChanged()
    }
}