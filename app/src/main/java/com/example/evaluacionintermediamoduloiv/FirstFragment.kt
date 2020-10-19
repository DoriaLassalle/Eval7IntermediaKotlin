package com.example.evaluacionintermediamoduloiv

import android.content.Context
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.evaluacionintermediamoduloiv.model.contact.ContactEntity
import kotlinx.android.synthetic.main.fragment_first.*
import kotlinx.android.synthetic.main.fragment_first.view.*

class FirstFragment : Fragment(), ContactAdapter.PassData {

    lateinit var myAdapter: ContactAdapter


    override fun onCreate(savedInstanceState: Bundle?) {


        super.onCreate(savedInstanceState)
        myAdapter = ContactAdapter(this)


    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_first, container, false)
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val myRecycler = recycler
        myRecycler.layoutManager = LinearLayoutManager(context)
        myRecycler.adapter = myAdapter
        myAdapter.updateAdapter(getData())

        view.agregarContacto.setOnClickListener {
            findNavController().navigate(R.id.action_FirstFragment_to_SecondFragment)
        }

        //poner aqui un clik al item seleccionado? o en el adapter?
        //el nav controller lo uso aqui
    }

    fun getData(): List<ContactEntity> {
        val listado = listOf<ContactEntity>(
            //que le paso aqui
        )

        return listado

    }

    override fun passContact(cont: Array<ContactEntity>) {
        Log.d("contact", cont)

            val myBundle = Bundle()
            myBundle.putStringArray("contacto", cont)

        findNavController().navigate(R.id.action_FirstFragment_to_ThirdFragment, myBundle)
    }





}