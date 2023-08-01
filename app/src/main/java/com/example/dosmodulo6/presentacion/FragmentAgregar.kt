package com.example.dosmodulo6.presentacion

import android.app.Activity
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import com.example.dosmodulo6.R
import com.example.dosmodulo6.databinding.FragmentAgregarBinding


class FragmentAgregar : Fragment() {
lateinit var binding: FragmentAgregarBinding
private val itemVM : ItemVM by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentAgregarBinding.inflate(layoutInflater,container,false)

        initListener()


        return binding.root
    }

    private fun initListener() {
        binding.btnGuardar.setOnClickListener {

            var nombre= binding.edNombreItem.text.toString()
            var precio = binding.edPrecio.text.toString().toInt()
            var cantidad = binding.edCantidad.text.toString().toInt()

            itemVM.insertItem(nombre, precio, cantidad)
        }
    }


}