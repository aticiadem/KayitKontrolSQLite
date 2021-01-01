package com.adematici.kayikontrolsqlite.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.adematici.kayikontrolsqlite.database.Kayitlardao
import com.adematici.kayikontrolsqlite.database.VeritabaniYardimcisi
import com.adematici.kayikontrolsqlite.databinding.ActivityKayitEkleBinding

class KayitEkleActivity : AppCompatActivity() {

    lateinit var binding: ActivityKayitEkleBinding
    val vt = VeritabaniYardimcisi(this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityKayitEkleBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setSupportActionBar(binding.toolbarKayitEkle)

        binding.buttonKayitEkle.setOnClickListener {

            val isim: String = binding.tilIsim.text.toString()
            val soyisim: String = binding.tilSoyisim.text.toString()
            val dogumtarihi: String = binding.tilDT.text.toString()
            val tel: String = binding.tilTelefon.text.toString()

            if(binding.tilIsim.text!!.isNotEmpty() && binding.tilSoyisim.text!!.isNotEmpty() && binding.tilDT.text!!.isNotEmpty() && binding.tilTelefon.text!!.isNotEmpty()){
                Kayitlardao().kisiEkle(vt,isim,soyisim,dogumtarihi,tel)
                Toast.makeText(this,"Kayıt Başarılı",Toast.LENGTH_SHORT).show()
                startActivity(Intent(this,MainActivity::class.java))
                finish()
            } else {
                Toast.makeText(this,"Bütün Alanlar Doğru Şekilde Doldurulmalıdır.", Toast.LENGTH_SHORT).show()
            }

        }

    }
}