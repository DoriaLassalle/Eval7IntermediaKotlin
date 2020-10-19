package com.example.evaluacionintermediamoduloiv.model.user

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import com.example.evaluacionintermediamoduloiv.model.contact.ContactEntity

@Dao
interface UserDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertUser(newUser: UserEntity)

    //@Delete
    //fun deleteUser()

}

