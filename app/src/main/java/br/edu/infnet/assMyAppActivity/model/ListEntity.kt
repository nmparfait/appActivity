package br.edu.infnet.assMyAppActivity.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "thoughts_table")
data class ListEntity(
    @PrimaryKey @ColumnInfo(name = "atividades")
    val atividades: String
)

