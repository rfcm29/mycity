package intro.android.mycity.viewModel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import intro.android.mycity.db.NotaRepository
import intro.android.mycity.entities.Nota
import intro.android.mycity.db.NotaRoomDatabase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class NotaViewModel (application: Application):AndroidViewModel(application){

    private val repository: NotaRepository

    val allNotas: LiveData<List<Nota>>

    init {
        val notaDao = NotaRoomDatabase.getDatabase(application, viewModelScope).notaDao()
        repository = NotaRepository(notaDao)
        allNotas = repository.allNotas
    }

    fun insert(nota: Nota) = viewModelScope.launch(Dispatchers.IO){
        repository.insert(nota)
    }
}