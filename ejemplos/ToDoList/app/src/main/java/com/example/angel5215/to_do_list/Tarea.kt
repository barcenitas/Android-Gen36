package com.example.angel5215.to_do_list

import io.realm.RealmObject
import io.realm.annotations.RealmClass
import java.text.SimpleDateFormat
import java.util.*

@RealmClass
open class Tarea: RealmObject() {
    var fecha: Date? = null
    var contenido: String? = null

    override fun toString(): String {
        val formatoSimple = SimpleDateFormat("yyyy-MM-dd HH:mm", Locale.US)
        return "${formatoSimple.format(fecha)}. ${contenido}"
    }
}