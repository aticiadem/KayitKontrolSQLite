package com.adematici.kayikontrolsqlite.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.adematici.kayikontrolsqlite.R
import com.adematici.kayikontrolsqlite.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    lateinit var binding:ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setSupportActionBar(binding.toolbar)

        binding.btKayitEkle.setOnClickListener {
            startActivity(Intent(this,KayitEkleActivity::class.java))
        }

        binding.btKayitGoster.setOnClickListener {
            startActivity(Intent(this,KayitlariGosterActivity::class.java))
        }
    }

    override fun onBackPressed() {
        super.onBackPressed()
        startActivity(Intent(this,GirisActivity::class.java))
        finish()
    }

}