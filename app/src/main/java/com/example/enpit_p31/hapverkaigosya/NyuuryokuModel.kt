package com.example.enpit_p31.hapverkaigosya

import io.realm.RealmObject
import io.realm.annotations.PrimaryKey
import java.util.*

open class NyuuryokuModel : RealmObject() {
    @PrimaryKey
    var id: Long = 0
    var date: Date = Date()
    var title: String = ""
    var detail: String = ""
}