package com.example.evaluacionintermediamoduloiv.viewModel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import com.example.evaluacionintermediamoduloiv.model.contact.ContactDataBase
import com.example.evaluacionintermediamoduloiv.model.user.UserEntity
import com.example.evaluacionintermediamoduloiv.model.user.UserRepository

class UserViewModel(application: Application):AndroidViewModel(application) {


    private val myUserRepository: UserRepository


    init {
        val dao2= ContactDataBase.getDataBase(application).userDao()    // fun del repository
        myUserRepository= UserRepository(dao2)    //comunico dao con repository

    }

    fun insertUser(newUser: UserEntity){
        myUserRepository.insertUser(newUser)
    }
    fun deleteUser(){
       // myUserRepository.deleteUser()
    }
}