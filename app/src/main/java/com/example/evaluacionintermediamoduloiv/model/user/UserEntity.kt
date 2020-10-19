package com.example.evaluacionintermediamoduloiv.model.user

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "user_table")
data class UserEntity(
        @PrimaryKey val nombreUsuario:String,
        @ColumnInfo(name = "emailUser")val emailUsuario:String,
        @ColumnInfo(name = "passwordUser")val passwordUsuario:String
)