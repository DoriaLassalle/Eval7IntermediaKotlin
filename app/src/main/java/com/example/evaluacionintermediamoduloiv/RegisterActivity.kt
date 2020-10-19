package com.example.evaluacionintermediamoduloiv

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import com.example.evaluacionintermediamoduloiv.model.user.UserEntity
import com.example.evaluacionintermediamoduloiv.viewModel.UserViewModel
import kotlinx.android.synthetic.main.activity_registro.*

class RegisterActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_registro)

        regVolverLogin.setOnClickListener {
            startActivity(Intent(this, LoginActivity::class.java))
        }

        val myUserViewModel: UserViewModel by viewModels()    //instancio mi viewmodel

        regGuardar.setOnClickListener {

            myUserViewModel.insertUser(UserEntity(regNombre.text.toString(),
                regCorreo.text.toString(), regPassword.text.toString()))
            //guardo los valores
            Log.d("usuario", it.toString())


            Toast.makeText(this, "USUARIO REGISTRADO", Toast.LENGTH_LONG).show()
        }

    }


}