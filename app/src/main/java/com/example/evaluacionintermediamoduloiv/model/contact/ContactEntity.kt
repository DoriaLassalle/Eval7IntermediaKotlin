package com.example.evaluacionintermediamoduloiv.model.contact

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "Contact_table")
data class ContactEntity(
        @PrimaryKey(autoGenerate = true) val id:Int=0,
        @ColumnInfo(name = "name")val nombre:String,
        @ColumnInfo(name = "last")val apellido:String,
        @ColumnInfo(name = "phone") val telefono:Int,
        @ColumnInfo(name = "email")val correo:String,
        @ColumnInfo(name = "company")val empresa:String
)



