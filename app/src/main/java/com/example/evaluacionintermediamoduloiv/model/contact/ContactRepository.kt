package com.example.evaluacionintermediamoduloiv.model.contact

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class ContactRepository(private val myContactDao: ContactDao) {

    val allContactsLiveData=myContactDao.getAll()    //live data con toso lo de la tabla

    fun insertContact(myContact: ContactEntity)= CoroutineScope(Dispatchers.IO).launch {
        myContactDao.insertContact(myContact)
    }
    fun updateOneContact(myContact: ContactEntity)= CoroutineScope(Dispatchers.IO).launch {
        myContactDao.updateOneContact(myContact)
    }
    fun deleteOneContact(myContact: ContactEntity)= CoroutineScope(Dispatchers.IO).launch {
        myContactDao.deleteOneContact(myContact)
    }
    fun deleteAll()= CoroutineScope(Dispatchers.IO).launch{
        myContactDao.deleteAll()

    }



}