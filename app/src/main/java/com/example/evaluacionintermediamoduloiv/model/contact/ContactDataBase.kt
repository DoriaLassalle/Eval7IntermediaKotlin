package com.example.evaluacionintermediamoduloiv.model.contact

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.evaluacionintermediamoduloiv.model.user.UserDao
import com.example.evaluacionintermediamoduloiv.model.user.UserEntity


@Database(entities = [ContactEntity::class, UserEntity::class],  version = 2)
abstract class ContactDataBase : RoomDatabase() {
    //llamo DAO
    abstract fun contactDao(): ContactDao   //una fun por cada dao, que usare en el repository
    abstract  fun userDao(): UserDao


    companion object {
        @Volatile
        private var INSTANCE: ContactDataBase?=null


        fun getDataBase(context: Context): ContactDataBase {
            val tempInstance = INSTANCE
            if (tempInstance != null) {
                return tempInstance
            }

            synchronized(this) {
                val instance = Room.databaseBuilder(context, ContactDataBase::class.java,
                        "contact_db").build()
                INSTANCE = instance
                return instance
            }

        }

    }

}