package com.example.enpit_p31.hapverkaigosya

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.RadioButton
import kotlinx.android.synthetic.main.activity_radio.*

class Radio : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_radio)

        button.setOnClickListener { finish() }

        radioGroup.setOnCheckedChangeListener { group, checkedId ->
            zikan1.text = findViewById<RadioButton>(checkedId).text
        }
        radioGroup.setOnCheckedChangeListener { group, checkedId ->
            zikan2.text = findViewById<RadioButton>(checkedId).text
        }
        radioGroup.setOnCheckedChangeListener { group, checkedId ->
            ziakn3.text = findViewById<RadioButton>(checkedId).text
        }

    }
}
