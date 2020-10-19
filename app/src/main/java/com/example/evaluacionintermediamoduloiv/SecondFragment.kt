package com.example.evaluacionintermediamoduloiv

import android.content.Context
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.evaluacionintermediamoduloiv.model.contact.ContactEntity
import com.example.evaluacionintermediamoduloiv.viewModel.ContactViewModel
import kotlinx.android.synthetic.main.fragment_second.*
import kotlinx.android.synthetic.main.fragment_second.view.*


class SecondFragment : Fragment() {

    private var globalContext: Context?=null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        globalContext=this.getActivity()
    }

    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_second, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val myContactViewModel: ContactViewModel by viewModels()    //instancio mi viewmodel

        view.guardarCont.setOnClickListener {

        myContactViewModel.insertContact(
            ContactEntity(id = 0, nomCont.text.toString(),
            apellCont.text.toString(), telCont.text.toString().toInt(), mailCont.toString(),
            empresaCont.text.toString()) )   //inserto en la base

           // myContactViewModel.deleteAll()

        myContactViewModel.allContacts.observe(viewLifecycleOwner, androidx.lifecycle.Observer {
            Log.d("cont", it.toString())
        })


            Toast.makeText(globalContext, "CONTACTO GUARDADO", Toast.LENGTH_LONG).show()
        }

        view.findViewById<Button>(R.id.volverAgenda1).setOnClickListener {
            findNavController().navigate(R.id.action_SecondFragment_to_FirstFragment)
        }
    }
}