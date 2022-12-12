package com.course.cvbuilder.ui.splash

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import com.course.cvbuilder.R
import com.course.cvbuilder.ui.login.LoginActivity
import com.course.cvbuilder.ui.main.MainActivity

class SplashActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
        startMainActivity()

    }

    private fun startMainActivity() {
        Handler().postDelayed({
            val mIntent = Intent(this@SplashActivity, LoginActivity::class.java)
            startActivity(mIntent)
            finish()
        }, 2000)
    }
}