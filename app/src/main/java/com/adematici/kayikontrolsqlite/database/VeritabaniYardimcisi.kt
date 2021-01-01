package com.adematici.kayikontrolsqlite.database

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class VeritabaniYardimcisi(context: Context) : SQLiteOpenHelper(context,"kayit",null,1) {

    override fun onCreate(db: SQLiteDatabase?) {
        db?.execSQL("CREATE TABLE kayitlar(kisi_no INTEGER PRIMARY KEY AUTOINCREMENT, kisi_isim TEXT, kisi_soyisim TEXT, kisi_dogumtarihi TEXT, kisi_tel TEXT);")
    }

    override fun onUpgrade(db: SQLiteDatabase?, p1: Int, p2: Int) {
        db?.execSQL("DROP TABLE IF EXISTS kayitlar")
        onCreate(db)
    }

}