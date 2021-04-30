package intro.android.mycity.db

import androidx.lifecycle.LiveData
import intro.android.mycity.dao.NotaDao
import intro.android.mycity.entities.Nota

class NotaRepository (private val notaDao: NotaDao) {
    val allNotas: LiveData<List<Nota>> = notaDao.getAlphabetizedNotas()

    suspend fun insert(nota: Nota){
        notaDao.insert(nota)
    }
}