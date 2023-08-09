package com.angelika.appnoteandroid14.data.dp.daos

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.angelika.appnoteandroid14.data.models.NoteModel

@Dao
interface NoteDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAll(noteModel: NoteModel)

     @Query("SELECT * FROM model")
     fun getAll(): LiveData<List<NoteModel>>
}