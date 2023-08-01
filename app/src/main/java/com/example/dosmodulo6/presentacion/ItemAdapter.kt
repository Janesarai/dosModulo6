package com.example.dosmodulo6.presentacion

import android.icu.text.LocaleDisplayNames.UiListItem
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.view.menu.MenuView.ItemView
import androidx.navigation.Navigation
import androidx.navigation.R
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.Adapter
import com.example.dosmodulo6.data.local.Item
import com.example.dosmodulo6.databinding.ItemBinding

/* Pasos para crear un recycler view
[x ] item layout
 [x] agregar constraints
 [x] cambiar altura de constraints layout de item layout a wrap content
 [X] definir ID
[x ] layout con recycler view
[X ] asignar layout manager
[x ] implementar clase Adapter
[x]  heredar RecyclerView.Adapter
[x] creaciones de los métodos: onCreateViewHolder, getItemCount y onBindViewHolder
[x ] crear clase anidada ViewHolder, que hereda de la clase ViewHolder
[x] Agregar constructor
[x] crear objeto, data class
[x] Crear lista
[x] asignar tamaño de la lista en getItemCount
[x] definir Binding Class del Item
[x] cambiar view por el binding
[x] declarar variable item en onBindViewHolder
[x] implementar binding en clase viewHolder
[x] Adapter+ view holder
[ x] obtener los datos*/

class ItemAdapter : RecyclerView.Adapter<ItemAdapter.ItemViewHolder>() {
    lateinit var binding: ItemBinding
    private val listItem = mutableListOf<Item>()


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        binding = ItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ItemViewHolder(binding)
    }


    override fun getItemCount(): Int {
        return listItem.size
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        val item = listItem[position]
        holder.render(item)

    }


    class ItemViewHolder(val v: ItemBinding) : RecyclerView.ViewHolder(v.root) {
        fun render(item: Item) {
            v.txNombrecv.text = item.nombre
            v.txCantidadCv.text = item.cantidad.toString()
            v.txPrecioCv.text = item.precio.toString()
            v.txTotalCv.text = (item.precio * item.cantidad).toString()
            val bundle = Bundle()
            bundle.putString("nombre",item.nombre)
            bundle.putString("precio", item.precio.toString())
            bundle.putString("cantidad", item.cantidad.toString())

        }

    }
    fun setData(listaItem: List<Item>){
        this.listItem.clear()
        this.listItem.addAll(listaItem)
        notifyDataSetChanged()
    }

}