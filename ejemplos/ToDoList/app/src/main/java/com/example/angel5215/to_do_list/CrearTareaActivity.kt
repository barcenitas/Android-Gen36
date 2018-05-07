package com.example.angel5215.to_do_list

import android.app.Activity
import android.content.ActivityNotFoundException
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_crear_tarea.*
import kotlin.math.E

class CrearTareaActivity : AppCompatActivity() {

    companion object {
        val EXTRA_DESCRIPCION_TAREA = "tarea"
    }



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_crear_tarea)

        terminarButton.setOnClickListener {
            terminarClicked()
        }
    }

    fun terminarClicked(){

        val descripcionTarea = descripcionEditText.text.toString()

        if (!descripcionTarea.isEmpty()) {
            var intentResultado = Intent()
            intentResultado.putExtra(EXTRA_DESCRIPCION_TAREA, descripcionTarea)
            setResult(Activity.RESULT_OK, intentResultado)
        }
        else {
            setResult(Activity.RESULT_CANCELED)
        }

        finish()
    }


}