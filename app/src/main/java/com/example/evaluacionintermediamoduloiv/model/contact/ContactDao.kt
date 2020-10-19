package com.example.evaluacionintermediamoduloiv.model.contact

import androidx.lifecycle.LiveData
import androidx.room.*


@Dao
interface ContactDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
     fun insertContact(myContact: ContactEntity)  //inserta un objeto

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertListContact(myListContact: List<ContactEntity>)//inserta una lista

    @Update
    fun updateOneContact(myContact: ContactEntity)

    @Query ("DELETE FROM contact_table")
    fun deleteAll()

    @Delete
    fun deleteOneContact(myContact: ContactEntity)

    @Query("SELECT * FROM contact_table")
    fun getAll(): LiveData<List<ContactEntity>>

    // @Query("SELECT * FROM contact_table WHERE name=:nombre")
    //fun findByName(nombre:String)



}