package intro.android.mycity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import intro.android.mycity.dataclasses.Nota
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import intro.android.mycity.adapter.ListaAdapter
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*
import kotlin.collections.ArrayList

class MainActivity : AppCompatActivity() {

    private lateinit var listaNotas: ArrayList<Nota>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        listaNotas = ArrayList<Nota>();

        lista.adapter = ListaAdapter(listaNotas)
        lista.layoutManager = LinearLayoutManager(this)
    }

    fun insert(view: View) {

        listaNotas.add(0, Nota("asass", Date(1997,12,29)))
        lista.adapter?.notifyDataSetChanged()
    }
}