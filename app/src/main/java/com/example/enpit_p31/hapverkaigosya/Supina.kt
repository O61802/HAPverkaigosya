package com.example.enpit_p31.hapverkaigosya

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Spinner
import kotlinx.android.synthetic.main.activity_radio.*
import kotlinx.android.synthetic.main.activity_supina.*

class Supina : AppCompatActivity() {

    private val spinnerItems = arrayOf("東京","千葉","福岡","佐賀")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_supina)

        val adapter = ArrayAdapter(applicationContext,
                android.R.layout.simple_spinner_item, spinnerItems)

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        
        spinner.adapter = adapter
        
        spinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {

            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                val spinnerParent = parent as Spinner
                val item = spinnerParent.selectedItem as String
                textView.text = item
            }

            override  fun onNothingSelected(parent: AdapterView<*>?){}
        }
        button4.setOnClickListener { finish() }
    }
}
