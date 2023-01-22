package com.e444er.note.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "notes_table")
data class Note(
    @PrimaryKey(autoGenerate = true)
    val id: Int?=null,
    @ColumnInfo
    val title: String,
    @ColumnInfo
    val subtitle: String
)
