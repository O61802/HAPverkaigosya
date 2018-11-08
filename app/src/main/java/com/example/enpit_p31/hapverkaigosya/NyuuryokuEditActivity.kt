package com.example.enpit_p31.hapverkaigosya

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import io.realm.Realm
import io.realm.kotlin.createObject
import io.realm.kotlin.where
import kotlinx.android.synthetic.main.activity_nyuuryoku_edit.*
import org.jetbrains.anko.alert
import org.jetbrains.anko.yesButton
import java.lang.IllegalArgumentException
import java.text.ParseException
import java.text.SimpleDateFormat
import java.util.*

class NyuuryokuEditActivity : AppCompatActivity() {
    private lateinit var realm: Realm

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_nyuuryoku_edit)

        realm = Realm.getDefaultInstance()

        syousaibutton.setOnClickListener { onSyousaiBottonTapped(it) }

        val nyuuryokuModelId =intent?.getLongExtra("nyuuryokuModel_id", -1L)
        if (nyuuryokuModelId != -1L) {
            val nyuuryokuModel =realm.where<NyuuryokuModel>()
                    .equalTo("id", nyuuryokuModelId).findFirst()
            dateEdite.setText(
                    android.text.format.DateFormat.format("yyyy/MM/dd", nyuuryokuModel?.date))
            titleEdite.setText(nyuuryokuModel?.title)
            detailEdit.setText(nyuuryokuModel?.detail)
        }

        save.setOnClickListener{
            when (nyuuryokuModelId) {
                -1L -> {
                    realm.executeTransaction {
                        val maxId = realm.where<NyuuryokuModel>().max("id")
                        val nextId = (maxId?.toLong() ?:  0L) + 1
                        val list = realm.createObject<NyuuryokuModel>(nextId)
                        dateEdite.text.toString().toDate("yyyy/MM/dd")?.let {
                            list.date = it
                        }
                        list.title = titleEdite.text.toString()
                        list.detail = detailEdit.text.toString()
                    }
                    alert("追加しました"){
                        yesButton { finish() }
                    }.show()
                }


            }
        }
    }


    override fun onDestroy() {
        super.onDestroy()
        realm.close()
    }

    fun String.toDate(pattern: String = "yyyy/MM/dd HH:mm"): Date? {
        val sdFormat = try {
            SimpleDateFormat(pattern)
        } catch (e: IllegalArgumentException) {
            null
        }
        val date = sdFormat?.let {
            try {
                it.parse(this)
            }catch (e: ParseException){
                null
            }
        }
        return  date
    }

    fun onSyousaiBottonTapped(view: View){
        val intent = Intent(this, Main3Activity::class.java)
        startActivity(intent)
    }
}
