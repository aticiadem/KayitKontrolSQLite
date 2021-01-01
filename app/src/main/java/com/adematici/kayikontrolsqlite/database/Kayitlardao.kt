package com.adematici.kayikontrolsqlite.database

import android.content.ContentValues
import com.adematici.kayikontrolsqlite.model.Kayitlar

class Kayitlardao {

    fun kisiEkle(vt: VeritabaniYardimcisi, kisi_isim: String, kisi_soyisim: String, kisi_dogumtarihi: String, kisi_tel: String){
        val db = vt.writableDatabase
        val values = ContentValues()

        values.put("kisi_isim", kisi_isim)
        values.put("kisi_soyisim", kisi_soyisim)
        values.put("kisi_dogumtarihi", kisi_dogumtarihi)
        values.put("kisi_tel", kisi_tel)

        db.insertOrThrow("kayitlar",null,values)
        db.close()
    }

    fun tumKisiler(vt: VeritabaniYardimcisi) : ArrayList<Kayitlar> {
        val kisilerArrayList = ArrayList<Kayitlar>()
        val db = vt.writableDatabase
        val cursor = db.rawQuery("SELECT * FROM kayitlar",null)

        while (cursor.moveToNext()){
            val kisi = Kayitlar(cursor.getInt(cursor.getColumnIndex("kisi_no")),
                cursor.getString(cursor.getColumnIndex("kisi_isim")),
                cursor.getString(cursor.getColumnIndex("kisi_soyisim")),
                cursor.getString(cursor.getColumnIndex("kisi_dogumtarihi")),
                cursor.getString(cursor.getColumnIndex("kisi_tel")))
            kisilerArrayList.add(kisi)
        }
        return kisilerArrayList
    }

    fun kisiSil(vt: VeritabaniYardimcisi, kisi_no: Int){
        val db = vt.writableDatabase
        db.delete("kayitlar","kisi_no=?", arrayOf(kisi_no.toString()))
        db.close()
    }

    fun tekKisiGetir(vt:VeritabaniYardimcisi, kisi_no: Int) : Kayitlar? {
        var gelenKisi: Kayitlar? = null
        val db = vt.writableDatabase
        val cursor = db.rawQuery("SELECT * FROM kayitlar WHERE kisi_no=$kisi_no",null)

        while (cursor.moveToNext()){
            gelenKisi = Kayitlar(cursor.getInt(cursor.getColumnIndex("kisi_no")),
                cursor.getString(cursor.getColumnIndex("kisi_isim")),
                cursor.getString(cursor.getColumnIndex("kisi_soyisim")),
                cursor.getString(cursor.getColumnIndex("kisi_dogumtarihi")),
                cursor.getString(cursor.getColumnIndex("kisi_tel")))
        }
        return gelenKisi
    }

    fun kisiGuncelle(vt: VeritabaniYardimcisi,kisi_no: Int, kisi_isim: String, kisi_soyisim: String, kisi_dogumtarihi: String, kisi_tel: String){
        val db = vt.writableDatabase
        val values = ContentValues()

        values.put("kisi_isim", kisi_isim)
        values.put("kisi_soyisim", kisi_soyisim)
        values.put("kisi_dogumtarihi", kisi_dogumtarihi)
        values.put("kisi_tel", kisi_tel)

        db.update("kayitlar",values,"kisi_no=?", arrayOf(kisi_no.toString()))
        db.close()
    }

}