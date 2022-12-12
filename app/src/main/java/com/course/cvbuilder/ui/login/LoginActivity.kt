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
    private lateinit var prefs: SharedPreferences
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)
        prefs = getSharedPreferences("cvbuilder", MODE_PRIVATE)
        getSaveUser()

    }

    private fun getSaveUser() {
        val prefUser = prefs.getString("username", "")
        val prefPass = prefs.getString("password", "")
        prefUser?.let { binding.etEmail.setText(it) }
        prefPass?.let { binding.etPassword.setText(it) }
    }

    fun onLogin(view: View) {
        val user = binding.etEmail.text.toString().trim()
        val pass = binding.etPassword.text.toString().trim()

        if (user.isEmpty()) {
            Toast.makeText(applicationContext, "Please enter your username", Toast.LENGTH_LONG)
                .show()
            return
        }
        if (pass.isEmpty()) {
            Toast.makeText(applicationContext, "Please enter your password", Toast.LENGTH_LONG)
                .show()
            return
        }
        openMainActivity(user, pass)
    }

    private fun openMainActivity(user: String, pass: String) {
        with(prefs.edit()) {
            putString("username", user)
            putString("password", pass)
            apply()
        }
        finish()
        startActivity(Intent(this, MainActivity::class.java))
    }

}