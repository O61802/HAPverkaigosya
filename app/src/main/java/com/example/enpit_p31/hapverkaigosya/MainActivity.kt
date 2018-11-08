package com.example.enpit_p31.hapverkaigosya

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import io.realm.Realm
import io.realm.kotlin.where
import kotlinx.android.synthetic.main.activity_main.*
import org.jetbrains.anko.startActivity

class MainActivity : AppCompatActivity() {
    private lateinit var realm: Realm

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        realm = Realm.getDefaultInstance()
        val nyuuryokumodels = realm.where<NyuuryokuModel>().findAll()
        listView.adapter = NyuuryokuModelAdapter(nyuuryokumodels)
        sinnki.setOnClickListener { onFaBottonTapped(it)  }

        listView.setOnItemClickListener { parent, view, position, id ->
            val nyuuryokuModel = parent.getItemAtPosition(position) as NyuuryokuModel
            startActivity<NyuuryokuEditActivity>(
                    "nyuuryokuModel_id" to nyuuryokuModel.id)
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        realm.close()
    }

    fun onFaBottonTapped(view: View){
        val intent = Intent(this, NyuuryokuEditActivity::class.java)
        startActivity(intent)
    }




}
