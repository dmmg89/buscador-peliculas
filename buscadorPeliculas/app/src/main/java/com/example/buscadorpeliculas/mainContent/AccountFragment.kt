package com.example.buscadorpeliculas.mainContent

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import com.example.buscadorpeliculas.R

//
class AccountFragment : Fragment() {




    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        val rootView = inflater.inflate(R.layout.fragment_account, container, false)
        val editButton = rootView.findViewById<Button>(R.id.editButtonAccount)
        val checkButton = rootView.findViewById<Button>(R.id.saveButtonAccount)
        val userId = rootView.findViewById<EditText>(R.id.userEditTextAccount)
        val userName = rootView.findViewById<EditText>(R.id.nameEditTextAccount)
        val userEmail = rootView.findViewById<EditText>(R.id.emailEditTextAccount)
        checkButton.visibility = View.INVISIBLE
        disableEditText(userId)
        disableEditText(userName)
        disableEditText(userEmail)

        editButton.setOnClickListener {
            checkButton.visibility = View.VISIBLE
            enableEditText(userId)
            enableEditText(userName)
            enableEditText(userEmail)
        }


        checkButton.setOnClickListener {
            disableEditText(userName)
            disableEditText(userId)
            disableEditText(userEmail)
            checkButton.visibility = View.INVISIBLE
        }
        return rootView



    }



    //funciones de activación de campos de texto

    private fun disableEditText(view: View){
        view.isEnabled= false
    }

    private fun enableEditText(view: View){
        view.isEnabled = true
    }


}
