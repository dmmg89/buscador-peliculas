package com.example.buscadorpeliculas.start

import android.content.ContentValues.TAG
import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.Switch
import android.widget.Toast
import com.example.buscadorpeliculas.R
import com.example.buscadorpeliculas.mainContent.MainActivity
import com.google.firebase.FirebaseApp
import com.google.firebase.auth.FirebaseAuth


class AccountLoginFragment : Fragment() {

    lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        auth = FirebaseAuth.getInstance()
        val viewFragment = inflater.inflate(R.layout.fragment_account_login, container, false)
        return viewFragment
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val switchAccount = view.findViewById<Switch>(R.id.accountSwitch)
        val registerButton = view.findViewById<Button>(R.id.registerButton)
        val singInButton = view.findViewById<Button>(R.id.loginButton)
        val emailLogin = view.findViewById<EditText>(R.id.loginEmail)
        val passwordLogin = view.findViewById<EditText>(R.id.loginPassword)
        val confirmPassword = view.findViewById<EditText>(R.id.loginPassword2)


        switchAccount.setOnCheckedChangeListener{_, isChecked->
        if(isChecked){

            registerButton.visibility = View.GONE
            confirmPassword.visibility = View.INVISIBLE
            singInButton.visibility = View.VISIBLE
        }else{
            registerButton.visibility = View.VISIBLE
            confirmPassword.visibility = View.VISIBLE
            singInButton.visibility= View.GONE
        }



            registerButton.setOnClickListener {
                Log.i("LOGIN", "Boton registro, presionado")

                if (passwordLogin.text != null && emailLogin.text != null) {

                    Log.i("LOGIN", "Campos diferentes de cero")

                    if (passwordLogin.text == confirmPassword.text) {
                        Log.i("LOGIN", "Campos password iguales")
                        auth
                            .createUserWithEmailAndPassword(
                                emailLogin.text.toString(),
                                passwordLogin.text.toString()
                            )
                            .addOnCompleteListener { task ->
                                if (task.isSuccessful) {
                                    Log.i(TAG, "Usuario Creado")

                                } else {
                                    Log.w(TAG, "Creación de usuario no exitosa", task.exception)
                                }
                            }
                    } else {
                        Toast.makeText(view.context, "Las contraseñas no coinciden", Toast.LENGTH_SHORT)
                    }
                }else{
                    Toast.makeText(view.context,"Debes ingresar los datos", Toast.LENGTH_LONG)
                }
            }

            singInButton.setOnClickListener {
                val emailTest = emailLogin.text.toString()
                val passwordTest = passwordLogin.text.toString()
                Log.d(TAG, "Datos leidos de campo de texto")
                auth.signInWithEmailAndPassword(emailTest,passwordTest).addOnCompleteListener { task->
                    if(task.isSuccessful){
                        Log.d(TAG,"Acceso via Firebase")
                        val intent = Intent(context,MainActivity::class.java)
                        intent.putExtra("email", emailTest)
                        startActivity(intent)
                        Log.d(TAG, "Pantalla inicial cargada con cuenta")
                    }else{
                        Log.w(TAG, "Acceso no válido", task.exception)
                    }
                }

            }

        }





    }

}