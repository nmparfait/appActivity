package br.edu.infnet.assMyAppActivity

import android.app.Application
import br.edu.infnet.assMyAppActivity.model.AppDatabase
import br.edu.infnet.assMyAppActivity.model.ListRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.SupervisorJob

class ListApplication : Application() {

    val applicationScope = CoroutineScope(SupervisorJob())

    val database by lazy { AppDatabase.getDatabase(this, applicationScope) }
    val repository by lazy { ListRepository(database.listDao()) }
}