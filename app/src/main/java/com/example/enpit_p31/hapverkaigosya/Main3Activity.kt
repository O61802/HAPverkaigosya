package com.example.enpit_p31.hapverkaigosya

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import kotlinx.android.synthetic.main.activity_main3.*

class Main3Activity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main3)
        button2.setOnClickListener { finish() }

        RadioBotton.setOnClickListener { onRadioBottonTapped(it) }
        Check.setOnClickListener { onCheck(it) }
        supina.setOnClickListener { onSupina(it) }
    }

    fun onRadioBottonTapped(view: View){
        val intent = Intent(this, Radio::class.java)
        startActivity(intent)
    }

    fun onCheck(view: View){
        val intent = Intent(this,check::class.java)
        startActivity(intent)
    }

    fun onSupina(view: View){
        val intent = Intent(this, Supina::class.java)
        startActivity(intent)
    }
}
