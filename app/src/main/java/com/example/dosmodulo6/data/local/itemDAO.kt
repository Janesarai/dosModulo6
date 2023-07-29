package com.example.dosmodulo6.data.local

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface itemDAO {
    @Insert
    suspend fun insertItem(item: Item)

    @Query("select * from tabla_item order by id ASC" )
    fun getAllItems(): LiveData<List<Item>>
}