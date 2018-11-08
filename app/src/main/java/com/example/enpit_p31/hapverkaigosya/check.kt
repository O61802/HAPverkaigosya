package com.example.enpit_p31.hapverkaigosya

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import kotlinx.android.synthetic.main.activity_check.*

class check : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_check)

        val status = arrayOf(
                "未チェック",
                "チェックされた",
                "チェックされていない"
        )

        check1.isChecked = false
        check1.text = status[0]

        check1.setOnClickListener(View.OnClickListener {
            val check = check1.isChecked()
            if(check){
                check1.text = status[1]
            }else{
                check1.text = status[2]
            }
        })

        Back.setOnClickListener { finish() }


    }
}
