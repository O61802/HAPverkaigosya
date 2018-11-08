package com.example.enpit_p31.hapverkaigosya

import android.app.Application
import io.realm.Realm

class NyuuryokuApp : Application() {
    override fun onCreate() {
        super.onCreate()
        Realm.init(this)
    }
}