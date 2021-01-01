package com.adematici.kayikontrolsqlite.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.adematici.kayikontrolsqlite.R
import com.adematici.kayikontrolsqlite.database.Kayitlardao
import com.adematici.kayikontrolsqlite.database.VeritabaniYardimcisi
import com.adematici.kayikontrolsqlite.databinding.ActivityGirisBinding

class GirisActivity : AppCompatActivity() {

    lateinit var binding: ActivityGirisBinding
    private val kullaniciAdi: String = "admin"
    private val sifre: String = "admin"

    val vt = VeritabaniYardimcisi(this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityGirisBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btGirisYap.setOnClickListener {
            if (binding.etKullaniciAdi.text.toString() == kullaniciAdi && binding.etSifre.text.toString() == sifre){
                startActivity(Intent(this,MainActivity::class.java))
            } else{
                Toast.makeText(this,"Kullanici Adi veya Sifre Yanlis",Toast.LENGTH_SHORT).show()
            }
        }

    }
}