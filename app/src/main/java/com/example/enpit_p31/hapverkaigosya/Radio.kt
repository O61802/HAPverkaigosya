package com.example.enpit_p31.hapverkaigosya

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.RadioButton
import kotlinx.android.synthetic.main.activity_radio.*

class Radio : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_radio)

        radioGroup.setOnCheckedChangeListener { group, checkedId ->
            zikan1.text = findViewById<RadioButton>(checkedId).text
            zikan2.text = findViewById<RadioButton>(checkedId).text
            zijan3.text = findViewById<RadioButton>(checkedId).text
        }
    }
}
