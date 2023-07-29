package com.example.dosmodulo6.presentacion

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.example.dosmodulo6.data.Repositorio
import com.example.dosmodulo6.data.local.Item
import com.example.dosmodulo6.data.local.ItemDataBase
import kotlinx.coroutines.launch

class ItemVM(application: Application): AndroidViewModel(application) {

    private val repositorio: Repositorio

    init {
        val dao = ItemDataBase.getDatabase(application).getItemDao()
        repositorio = Repositorio(dao)
    }

    fun  getAllItems(): LiveData<List<Item>> = repositorio.getItem()

    fun insertItem(nombre:String, precio:Int, cantidad:Int) = viewModelScope.launch {
        val item = Item(nombre, precio, cantidad)
        repositorio.insertItem(item)
    }
}