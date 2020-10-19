package com.example.evaluacionintermediamoduloiv.model.user

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class UserRepository(private val newUserDao: UserDao) {



    fun insertUser(newUser: UserEntity)= CoroutineScope(Dispatchers.IO).launch {
         newUserDao.insertUser(newUser)
    }

   // fun deleteUser()= CoroutineScope(Dispatchers.IO).launch {
    //    newUserDao.deleteUser()
   //}
}