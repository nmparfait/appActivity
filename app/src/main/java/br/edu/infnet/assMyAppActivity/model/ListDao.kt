package br.edu.infnet.assMyAppActivity.model

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface ListDao {

    @Query("SELECT * FROM thoughts_table")
    fun getAllActivities(): Flow<List<ListEntity>>

    @Insert
     suspend fun insert(listEntity: ListEntity)

    @Query("DELETE FROM thoughts_table")
     suspend fun deleteAll()
}