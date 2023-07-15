package com.example.buscadorpeliculas

import android.content.ContentValues.TAG
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.renderscript.ScriptGroup.Binding
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.google.firebase.FirebaseApp
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import java.lang.Exception

class loginActivity : AppCompatActivity() {
    lateinit var auth: FirebaseAuth
    private lateinit var binding:Binding
    lateinit var bundle: Bundle


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        FirebaseApp.initializeApp(this)
        auth = Firebase.auth


        val enterButton = findViewById<Button>(R.id.loginButton)
        val registerButton = findViewById<Button>(R.id.registerButton)
        val emailLogin = findViewById<EditText>(R.id.loginEmail)
        val passwordLogin = findViewById<EditText>(R.id.loginPassword)


        registerButton.setOnClickListener {

            auth.createUserWithEmailAndPassword(emailLogin.text.toString(), passwordLogin.text.toString())
                .addOnCompleteListener(this) { task ->
                    if (task.isSuccessful) {
                        Log.d(TAG, "Usuario creado")
                        val user = auth.currentUser

                    } else {
                        Log.w(TAG, "Creación de usuario no concluido", task.exception)
                    }
                }


        }
        enterButton.setOnClickListener {
            try {
                Log.d(TAG,"ACCESO A LA APLICACION")
                val intent = Intent(this, MainActivity::class.java)
                startActivity(intent)
            }catch (e: Exception){
                Log.w(TAG,"APLICACION NO INICIALIZADA")

        }
        }
        /*enterButton.setOnClickListener {
            val emailTest = emailLogin.text.toString()
            val passwordTest = passwordLogin.text.toString()
            Log.d(TAG, "Datos ingresados" + emailTest + "  " + passwordTest)
            auth.signInWithEmailAndPassword(emailTest,passwordTest)
                .addOnCompleteListener {task ->
                    if (task.isSuccessful){
                        Log.i(TAG,"ACCESO A LA APLICACION")

                        val intent = Intent(this, MainActivity::class.java)
                        intent.putExtra("email",emailTest)
                        intent.putExtra("User", "Usuario de intent")
                        startActivity(intent)
                        Log.i(TAG, "PANTALLA INICIAL")

                    }else{
                        Log.w(TAG,"ACCESO NO PERMITIDO", task.exception)
                    }

            }
        }*/


    }



}