package com.adematici.kayikontrolsqlite.adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.adematici.kayikontrolsqlite.databinding.KayitGosterRowBinding
import com.adematici.kayikontrolsqlite.model.Kayitlar
import com.adematici.kayikontrolsqlite.view.DetayActivity
import com.adematici.kayikontrolsqlite.view.KayitlariGosterActivity

class KayitlarAdapter(private val mContext: Context, private val kisiListesi: ArrayList<Kayitlar>) : RecyclerView.Adapter<KayitlarAdapter.KayitlarViewHolder>() {

    val intent = Intent(this.mContext,DetayActivity::class.java)

    class KayitlarViewHolder(val itemBinding: KayitGosterRowBinding) : RecyclerView.ViewHolder(itemBinding.root) {
    }

    override fun getItemCount(): Int {
        return kisiListesi.size
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): KayitlarViewHolder {
        val binding = KayitGosterRowBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return KayitlarViewHolder(binding)
    }

    override fun onBindViewHolder(holder: KayitlarViewHolder, position: Int) {

        holder.itemBinding.tvKayitGosterIsim.text = kisiListesi[position].kisi_isim
        holder.itemBinding.tvKayitGosterSoyisim.text = kisiListesi[position].kisi_soyisim
        holder.itemBinding.tvKayitGosterDG.text = kisiListesi[position].kisi_dogumtarihi
        holder.itemBinding.tvKayitGosterTel.text = kisiListesi[position].kisi_tel

        holder.itemBinding.buttonGuncelle.setOnClickListener {
            intent.putExtra("pozisyon",kisiListesi[1].kisi_no)
            mContext.startActivity(intent)
        }
    }

}