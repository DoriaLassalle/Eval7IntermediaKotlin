package com.example.evaluacionintermediamoduloiv

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.evaluacionintermediamoduloiv.model.contact.ContactEntity
import kotlinx.android.synthetic.main.contact_item_list.view.*

open class ContactAdapter(val callback: PassData): RecyclerView.Adapter<ContactAdapter.ContactViewHolder>(){

    private var contactList= emptyList<ContactEntity>()

    fun updateAdapter(myList: List<ContactEntity>){                 //actualizar el adapt
        contactList=myList
        notifyDataSetChanged()
    }
    inner class ContactViewHolder(itemView: View):RecyclerView.ViewHolder(itemView){
        val newName = itemView.nombreRec  //id del textview a mostrar en el recycler
        val newLast= itemView.apellidoRec


        val click=itemView.setOnClickListener {
            callback.passContact(contactList[adapterPosition])


                //como paso al third fragment con los datos del gil que seleccione?
            }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ContactAdapter.ContactViewHolder {
        val view= LayoutInflater.from(parent.context).inflate(R.layout.contact_item_list,parent,
            false)

        return ContactViewHolder(view)
    }

    override fun onBindViewHolder(holder: ContactAdapter.ContactViewHolder, position: Int) {
        val newContact=contactList[position]

        holder.newName.text = newContact.nombre
        holder.newLast.text= newContact.apellido


        Log.e("PROBANDO", "${contactList.size}" )


    }

    override fun getItemCount()= contactList.size


    interface PassData {
        fun passContact(cont: Array<ContactEntity>)

    }


}
