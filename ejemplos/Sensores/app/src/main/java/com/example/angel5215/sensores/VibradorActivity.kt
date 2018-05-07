package com.example.angel5215.sensores

import android.content.Context
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.os.VibrationEffect
import android.os.Vibrator
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_vibrador.*

class VibradorActivity : AppCompatActivity() {

    var estaVibrando = false
    lateinit var vibrator: Vibrator

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_vibrador)

        stop.isEnabled = false

        //  Es necesario agregar un permiso para vibrar en el archivo AndroidManifest.xml
        // <uses-permission android:name="android.permission.VIBRATE"></uses-permission>
        vibrator = getSystemService(Context.VIBRATOR_SERVICE) as Vibrator
        vibrator.cancel()

    }

    fun vibrarUnaVez(v: View) {
        if(!vibrator.hasVibrator()) {
            Toast.makeText(this, "No soporta vibración.", Toast.LENGTH_LONG).show()
            return
        }

        // Forma actual
        //vibrator.vibrate(VibrationEffect.createOneShot(1000, 100))
        vibrator.vibrate(1000)

    }

    fun vibrarRepetidas(v: View) {

        if(!vibrator.hasVibrator()) {
            Toast.makeText(this, "No soporta vibración.", Toast.LENGTH_LONG).show()
            return
        }
        if(estaVibrando) {
            vibrator.cancel()
        }
        else {
            vibrator.vibrate(longArrayOf(0, 1000, 500, 2000, 50), 0)
            estaVibrando = true
            stop.isEnabled = true
        }

    }

    fun detener(v: View) {
        if(!vibrator.hasVibrator()) {
            Toast.makeText(this, "No soporta vibración.", Toast.LENGTH_LONG).show()
            return
        }

        if (estaVibrando) {
            vibrator.cancel()
            stop.isEnabled = false
            estaVibrando = false
        }
    }


}
