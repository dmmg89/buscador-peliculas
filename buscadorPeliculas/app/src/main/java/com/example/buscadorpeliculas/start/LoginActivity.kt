package com.example.buscadorpeliculas.start

import android.Manifest
import android.annotation.SuppressLint
import android.content.ContentValues.TAG
import android.content.Context
import android.content.Intent
import android.content.pm.PackageManager
import android.graphics.Color
import android.location.LocationManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.renderscript.ScriptGroup.Binding
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.LinearLayout
import android.widget.Switch
import android.widget.TextView
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import androidx.core.content.ContextCompat.getColor
import androidx.core.content.ContextCompat.getSystemService
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import com.example.buscadorpeliculas.mainContent.MainActivity
import com.example.buscadorpeliculas.R
import com.example.buscadorpeliculas.R.color.grey
import com.example.buscadorpeliculas.R.color.primaryColor
import com.example.buscadorpeliculas.R.color.secundaryColor
import com.example.buscadorpeliculas.databinding.ActivityLoginBinding
import com.example.buscadorpeliculas.databinding.ActivityMainBinding
import com.example.buscadorpeliculas.mainContent.AccountFragment
import com.google.android.gms.location.FusedLocationProviderClient
import com.google.android.gms.location.LocationServices
import com.google.firebase.FirebaseApp
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import java.lang.Exception
import java.time.LocalDate
import java.time.LocalTime
import java.time.format.DateTimeFormatter
import java.util.Calendar
import java.util.Date
import java.util.Locale

class loginActivity : AppCompatActivity() {

    /*lateinit var auth: FirebaseAuth*/
    private lateinit var fusedLocationClient : FusedLocationProviderClient
    private lateinit var binding:ActivityLoginBinding
    lateinit var bundle: Bundle



    @SuppressLint("ResourceAsColor")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)


        fusedLocationClient = LocationServices.getFusedLocationProviderClient(this)

       /* FirebaseApp.initializeApp(this)
        auth = Firebase.auth*/


        ColorBank.primaryColor = Color.valueOf(R.color.primaryColor)
        ColorBank.secundaryColor = Color.valueOf(secundaryColor)
        ColorBank.neutralColor = Color.valueOf(grey)

        SharedData.date = getDate()
        SharedData.time = getTime()
        SharedData.formattedDate = formatDate(SharedData.date)
        Log.i(TAG, "Datos Shared obtenidos")
        Log.i(TAG, SharedData.date.toString())
        Log.i(TAG, SharedData.time.toString())


        val linearLayout = findViewById<LinearLayout>(R.id.linearLayoutTop)

      /*  val emailLoginLabel = findViewById<TextView>(R.id.emailLoginLabel)
        val emailLogin = findViewById<EditText>(R.id.loginEmail)
        val userLoginLabel = findViewById<TextView>(R.id.userLabelLogin)
        val userLogin = findViewById<EditText>(R.id.userEditTextLogin)
*/
        val enterWithAccountBtn = findViewById<Button>(R.id.enterWithAccountButton)
        val enterWithoutAccountBtn = findViewById<Button>(R.id.enterWithoutAccountButton)

       /* val enterButton = findViewById<Button>(R.id.loginButton)
        val registerButton = findViewById<Button>(R.id.registerButton)


        val passwordLoginLabel = findViewById<TextView>(R.id.passwordLabelLogin)
        val passwordLogin = findViewById<EditText>(R.id.loginPassword)
        val switchAccount = findViewById<Switch>(R.id.accountSwitch)*/


        val params1 = enterWithAccountBtn.layoutParams as LinearLayout.LayoutParams
        val params2 = enterWithoutAccountBtn.layoutParams as LinearLayout.LayoutParams


       /* try {
            getLocation()
            Log.i(TAG, "Location found")
        }catch (e:Exception){
            Log.d(TAG,e.toString())
        }*/




        enterWithAccountBtn.setOnClickListener {

            enterWithoutAccountBtn.setBackgroundColor(secundaryColor)
            enterWithAccountBtn.setBackgroundColor(primaryColor)
            params1.weight = 2f

            params2.weight = 1f



            /*userLoginLabel.visibility = View.VISIBLE
            userLogin.visibility = View.VISIBLE
            emailLogin.visibility = View.VISIBLE
            emailLoginLabel.visibility = View.VISIBLE
            passwordLoginLabel.visibility = View.VISIBLE
            passwordLogin.visibility = View.VISIBLE
            switchAccount.visibility = View.VISIBLE*/
            loadFragment(AccountLoginFragment())
            linearLayout.requestLayout()
        }

        enterWithoutAccountBtn.setOnClickListener {
            enterWithAccountBtn.setBackgroundColor(primaryColor)
            enterWithoutAccountBtn.setBackgroundColor(secundaryColor)
            params1.weight = 1f
            params2.weight = 2f

            loadFragment(NoAccountLoginFragment())

            /*userLoginLabel.visibility = View.INVISIBLE
            userLogin.visibility = View.GONE

            emailLogin.visibility = View.INVISIBLE
            emailLoginLabel.visibility = View.INVISIBLE
            passwordLoginLabel.visibility = View.INVISIBLE

            passwordLogin.visibility = View.INVISIBLE

            enterButton.visibility = View.VISIBLE
            registerButton.visibility=View.GONE
            switchAccount.visibility = View.INVISIBLE*/

            linearLayout.requestLayout()

        }




/*

        switchAccount.setOnCheckedChangeListener { _, isChecked->
            if(isChecked){
                emailLoginLabel.visibility = View.INVISIBLE
                emailLogin.visibility = View.INVISIBLE
                enterButton.visibility= View.VISIBLE
                registerButton.visibility = View.GONE
                */
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
        }*//*


            }else{
                emailLoginLabel.visibility = View.VISIBLE
                emailLogin.visibility = View.VISIBLE
                enterButton.visibility = View.GONE
                registerButton.visibility = View.VISIBLE

            }
        }
*/

        
       

      /*  registerButton.setOnClickListener {

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
        }*/



    }


    private fun checkGranted(permission: String): Boolean{
        val granted = ActivityCompat.checkSelfPermission(this,permission)== PackageManager.PERMISSION_GRANTED
        return granted
    }

    private fun checkPermissions():Boolean{
        val granted = checkGranted(Manifest.permission.ACCESS_COARSE_LOCATION)&&checkGranted(Manifest.permission.ACCESS_FINE_LOCATION)
        return granted
    }

    private fun requestPermission(){
        ActivityCompat.requestPermissions(
            this,
            arrayOf(Manifest.permission.ACCESS_FINE_LOCATION, Manifest.permission.ACCESS_COARSE_LOCATION),
            REQUEST_LOCATION_PERMISSION
        )
    }

    private fun isLocationEnabled(): Boolean{
        var locationManager: LocationManager = getSystemService(Context.LOCATION_SERVICE) as LocationManager
        return locationManager.isProviderEnabled(LocationManager.GPS_PROVIDER) || locationManager.isProviderEnabled(
            LocationManager.NETWORK_PROVIDER)

    }

//    @SuppressLint("MissingPermission")
    private fun getLocation(){
        if (checkPermissions()&&isLocationEnabled()){
            try{
                if (ActivityCompat.checkSelfPermission(
                        this,
                        Manifest.permission.ACCESS_FINE_LOCATION
                    ) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(
                        this,
                        Manifest.permission.ACCESS_COARSE_LOCATION
                    ) != PackageManager.PERMISSION_GRANTED
                ) {
                    // TODO: Consider calling
                    //    ActivityCompat#requestPermissions
                    // here to request the missing permissions, and then overriding
                    //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
                    //                                          int[] grantResults)
                    // to handle the case where the user grants the permission. See the documentation
                    // for ActivityCompat#requestPermissions for more details.
                    return
                }
                fusedLocationClient.lastLocation.addOnSuccessListener(this){ location->
                    Log.i(TAG,location?.latitude.toString())
                    Log.i(TAG, location.longitude.toString())
                }}catch (e:Exception){
                Log.w(TAG, e.toString())
            }

        }else{
            requestPermission()
        }
    }

    companion object{
        private const val REQUEST_LOCATION_PERMISSION = 1001
    }

    //Cambios de Fragment
    //Pantalla login

    fun loadFragment(fragment:Fragment){
        val fragmentManager = supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.frameContentLogin, fragment)
        fragmentTransaction.commit()
    }



}









fun getDate(): LocalDate {
   val currentDay = LocalDate.now()
   return currentDay
}

fun formatDate(rawEntry: LocalDate):String{

    val formatter = DateTimeFormatter.ofPattern("EEEE, d MMMM", Locale("es"))
    val formatedDAte = rawEntry.format(formatter)


    return formatedDAte.toString()
}


fun getTime(): LocalTime {
    val currentTime = LocalTime.now()
    return currentTime
}

object SharedData{
    lateinit var userName: String
    lateinit var userTag: String
    lateinit var userEmail:String
    lateinit var latitude:String
    lateinit var longitude:String
    lateinit var date:LocalDate
    lateinit var formattedDate : String
    lateinit var time:LocalTime

}


object ColorBank {

   lateinit var primaryColor: Color
   lateinit var secundaryColor: Color
   lateinit var neutralColor: Color

}
