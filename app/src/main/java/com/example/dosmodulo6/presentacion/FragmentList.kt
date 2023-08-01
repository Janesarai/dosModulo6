package com.example.dosmodulo6.presentacion

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.LifecycleOwner
import com.example.dosmodulo6.R
import com.example.dosmodulo6.databinding.FragmentListBinding


/**
 * A simple [Fragment] subclass.
 * Use the [FragmentList.newInstance] factory method to
 * create an instance of this fragment.
 */
class FragmentList : Fragment() {
   lateinit var binding: FragmentListBinding
   val itemVM: ItemVM by activityViewModels()
   val adapter = ItemAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentListBinding.inflate(inflater,container,false)
        initLista()
        return binding.root
    }

    private fun initLista() {

        itemVM.getAllItems().observe(viewLifecycleOwner){
        adapter.setData(it)
        }
        binding.RV.adapter = adapter
    }


}