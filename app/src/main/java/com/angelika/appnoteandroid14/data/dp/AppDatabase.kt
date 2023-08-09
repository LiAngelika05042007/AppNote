package com.angelika.appnoteandroid14.data.dp

import androidx.room.Database
import androidx.room.RoomDatabase
import com.angelika.appnoteandroid14.data.dp.daos.NoteDao
import com.angelika.appnoteandroid14.data.models.NoteModel

@Database(entities = [NoteModel::class], version = 2)
abstract class AppDatabase : RoomDatabase() {
    abstract fun noteDao(): NoteDao
}