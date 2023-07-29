package com.example.dosmodulo6.data

import androidx.lifecycle.LiveData
import com.example.dosmodulo6.data.local.Item
import com.example.dosmodulo6.data.local.ItemDAO

class Repositorio (private val itemDAO: ItemDAO){

    suspend fun insertItem ( item: Item){
        itemDAO.insertItem(item )
    }
    fun getItem ():
        LiveData<List<Item>> {
            return itemDAO.getAllItems()
    }
}