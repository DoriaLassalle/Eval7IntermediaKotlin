package com.example.evaluacionintermediamoduloiv

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_login.*


class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        btnRegistrar.setOnClickListener {
            startActivity(Intent(this, RegisterActivity::class.java))
        }

        recuperar.setOnClickListener {
                Toast.makeText(this, ":( Será para otro proyecto...", Toast.LENGTH_LONG).show()
        }
        btnIngresar.setOnClickListener {

            if(mailIngreso.text.toString().isBlank()||passwordIngreso.text.toString().isBlank()){

                    Toast.makeText(this, "COMPLETE AMBOS CAMPOS", Toast.LENGTH_LONG).show()
            }
           /* else if(!mailIngreso.text.toString().isCorrect()&& passwordIngreso.text.toString().isCorrect()){

                Toast.makeText(this, "MAIL INCORRECTO", Toast.LENGTH_LONG).show()
            }
            else if (mailIngreso.text.toString().isCorrect()&& !passwordIngreso.text.toString().isCorrect()){

                Toast.makeText(this, "CONTRASEÑA INCORRECTA", Toast.LENGTH_LONG).show()
            }
            else{
               //aqui poner el intent

            }*/

            startActivity(Intent(this, MainActivity::class.java))
        }










    }
}