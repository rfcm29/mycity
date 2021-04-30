package intro.android.mycity.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase
import intro.android.mycity.dao.NotaDao
import intro.android.mycity.entities.Nota
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

@Database(entities = arrayOf(Nota::class), version = 1, exportSchema = false)
public abstract class NotaRoomDatabase : RoomDatabase() {
    abstract fun notaDao(): NotaDao

    private class NotaDatabaseCallBack(private val scope: CoroutineScope) : RoomDatabase.Callback(){
        override fun onOpen(db: SupportSQLiteDatabase) {
            super.onOpen(db)
            INSTANCE?.let { database -> scope.launch { var notaDao = database.notaDao() } }
        }
    }

    companion object {
        @Volatile
        private var INSTANCE: NotaRoomDatabase? = null

        fun getDatabase(context: Context, scope: CoroutineScope): NotaRoomDatabase {
            return INSTANCE ?: synchronized(this){
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    NotaRoomDatabase::class.java,
                    "word_database"
                ).addCallback(NotaDatabaseCallBack(scope)).build()
                INSTANCE = instance
                instance
            }
        }
    }
}