package com.adematici.kayikontrolsqlite.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.adematici.kayikontrolsqlite.adapter.KayitlarAdapter
import com.adematici.kayikontrolsqlite.database.Kayitlardao
import com.adematici.kayikontrolsqlite.database.VeritabaniYardimcisi
import com.adematici.kayikontrolsqlite.databinding.ActivityKayitlariGosterBinding
import com.adematici.kayikontrolsqlite.model.Kayitlar

class KayitlariGosterActivity : AppCompatActivity() {

    lateinit var binding: ActivityKayitlariGosterBinding
    private lateinit var kisiListesi: ArrayList<Kayitlar>
    private lateinit var adapter: KayitlarAdapter
    val vt = VeritabaniYardimcisi(this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityKayitlariGosterBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setSupportActionBar(binding.toolbarKayitGoster)

        kisiListesi = ArrayList()
        kisiListesi = Kayitlardao().tumKisiler(vt)

        binding.recyclerView.setHasFixedSize(true)
        binding.recyclerView.layoutManager = LinearLayoutManager(this)

        adapter = KayitlarAdapter(this,kisiListesi)
        binding.recyclerView.adapter = adapter
    }

    override fun onBackPressed() {
        super.onBackPressed()
        startActivity(Intent(this,MainActivity::class.java))
        finish()
    }

}