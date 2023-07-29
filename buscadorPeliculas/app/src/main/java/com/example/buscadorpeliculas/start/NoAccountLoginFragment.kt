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
import com.example.buscadorpeliculas.R
import com.example.buscadorpeliculas.mainContent.MainActivity


class NoAccountLoginFragment : Fragment() {




    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        val viewLogin = inflater.inflate(R.layout.fragment_no_account_login, container, false)


        return viewLogin
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val signInButton = view.findViewById<Button>(R.id.noAccountSingIn)
        signInButton.setOnClickListener {
            try {
                Log.d(TAG, "Tratando de ingresar a aplicación")
                val intent = Intent(context,MainActivity::class.java)
                startActivity(intent)
                Log.d(TAG,"Actividad principal cargada")
            }catch (e:Exception){
                Log.w(TAG,"ACTIVIDAD NO INICIALIZADA")
            }
        }


    }


}