package com.example.evaluacionintermediamoduloiv.viewModel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import com.example.evaluacionintermediamoduloiv.model.contact.ContactDataBase
import com.example.evaluacionintermediamoduloiv.model.contact.ContactEntity
import com.example.evaluacionintermediamoduloiv.model.contact.ContactRepository


class ContactViewModel(application: Application): AndroidViewModel(application) {

    private val myContactRepository: ContactRepository     //para conectar cn el repository
    val allContacts:LiveData<List<ContactEntity>>

    init {
        val dao= ContactDataBase.getDataBase(application).contactDao()
        myContactRepository= ContactRepository(dao)    //comunico dao con repository
        allContacts=myContactRepository.allContactsLiveData
    }

    fun insertContact(mContact: ContactEntity){
        myContactRepository.insertContact(mContact)
    }
    fun updateOneContact(mContact: ContactEntity){
        myContactRepository.updateOneContact(mContact)
    }
    fun deleteOneContact(mContact: ContactEntity){
        myContactRepository.deleteOneContact(mContact)
    }
    fun deleteAll(){
        myContactRepository.deleteAll()
    }



}