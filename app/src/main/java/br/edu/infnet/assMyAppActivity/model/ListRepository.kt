package br.edu.infnet.assMyAppActivity.model

import androidx.annotation.WorkerThread
import kotlinx.coroutines.flow.Flow

class ListRepository (private val listDao: ListDao){

    val allActivities: Flow<List<ListEntity>> = listDao.getAllActivities()

    @Suppress("RedundantSuspendModifier")
    @WorkerThread
    suspend fun insert(listEntity: ListEntity) {
        listDao.insert(listEntity)
    }

    suspend fun deleteAll(){
        listDao.deleteAll()
    }

}