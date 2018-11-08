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

        RadioBotton.setOnClickListener { onRadioBottonTapped(it) }
    }

    fun onRadioBottonTapped(view: View){
        val intent = Intent(this, Radio::class.java)
        startActivity(intent)
    }
}
