package dev.agustacandi.mangmang

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen

class SplashActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        installSplashScreen()
        setContentView(R.layout.activity_splash)

        Handler(Looper.getMainLooper()).postDelayed({
            Intent(this, MainActivity::class.java).apply  {
                startActivity(this)
                finish()
            }
        }, 3000L)
    }
}