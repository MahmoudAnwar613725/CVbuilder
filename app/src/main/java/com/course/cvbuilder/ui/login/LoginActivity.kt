package com.course.cvbuilder.ui.login

 import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
 import com.course.cvbuilder.ui.main.MainActivity
 import com.course.cvbuilder.databinding.ActivityLoginBinding

class LoginActivity : AppCompatActivity() {

    private lateinit var binding: ActivityLoginBinding
    private lateinit var sharedPref : SharedPreferences
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)
       // sharedPref = AppUtils.setPref(this)

     }

    fun onLogin(view: View) {
        val user = binding.etEmail.text.toString().trim()
        val pass = binding.etPassword.text.toString().trim()

        if(user.isEmpty()){
            Toast.makeText(applicationContext,"Please enter your username", Toast.LENGTH_LONG).show()
            return
        }
        if(pass.isEmpty()){
            Toast.makeText(applicationContext,"Please enter your password", Toast.LENGTH_LONG).show()
            return
        }
        openMainActivity(user, pass)
    }

    private fun openMainActivity(user: String, pass: String){
        with(sharedPref.edit()) {

            apply()
        }

        startActivity(Intent(this, MainActivity::class.java))
    }

}