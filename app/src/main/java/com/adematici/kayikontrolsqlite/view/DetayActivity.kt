package com.adematici.kayikontrolsqlite.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.adematici.kayikontrolsqlite.database.Kayitlardao
import com.adematici.kayikontrolsqlite.database.VeritabaniYardimcisi
import com.adematici.kayikontrolsqlite.databinding.ActivityDetayBinding

class DetayActivity : AppCompatActivity() {

    lateinit var binding: ActivityDetayBinding
    val vt = VeritabaniYardimcisi(this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetayBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val gelenSira: Int = intent.getIntExtra("pozisyon",1)

        val tekKisi = Kayitlardao().tekKisiGetir(vt,gelenSira)
        binding.etDetayIsim.setText(tekKisi?.kisi_isim)
        binding.etDetaySoyisim.setText(tekKisi?.kisi_soyisim)
        binding.etDetayDT.setText(tekKisi?.kisi_dogumtarihi)
        binding.etDetayTel.setText(tekKisi?.kisi_tel)

        binding.buttonDetayGuncelle.setOnClickListener {
            if(binding.etDetayIsim.text.isNotEmpty() && binding.etDetaySoyisim.text.isNotEmpty() && binding.etDetayDT.text.isNotEmpty() && binding.etDetayTel.text.isNotEmpty()){
                val kisiDetayIsim: String = binding.etDetayIsim.text.toString()
                val kisiDetaySoyisim: String = binding.etDetaySoyisim.text.toString()
                val kisiDetayDT: String = binding.etDetayDT.text.toString()
                val kisiDetayTel: String = binding.etDetayTel.text.toString()

                Kayitlardao().kisiGuncelle(vt,gelenSira,kisiDetayIsim,kisiDetaySoyisim,kisiDetayDT,kisiDetayTel)
                Toast.makeText(this,"Güncelleme Başarılı",Toast.LENGTH_SHORT).show()
                startActivity(Intent(this,KayitlariGosterActivity::class.java))
                finish()
            } else {
                Toast.makeText(this,"İlgili Alanlar Boş Olamaz!",Toast.LENGTH_SHORT).show()
            }
        }

        binding.buttonDetaySil.setOnClickListener {
            Kayitlardao().kisiSil(vt,gelenSira)
            Toast.makeText(this,"Silme Başarılı",Toast.LENGTH_SHORT).show()
            startActivity(Intent(this,KayitlariGosterActivity::class.java))
            finish()
        }

    }

    override fun onBackPressed() {
        super.onBackPressed()
        finish()
    }

}