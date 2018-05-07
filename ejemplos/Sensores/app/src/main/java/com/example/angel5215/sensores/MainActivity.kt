package com.example.angel5215.sensores

import android.content.Context
import android.content.Intent
import android.hardware.Sensor
import android.hardware.SensorManager
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), View.OnClickListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        vibrador.setOnClickListener(this)
        acelerometro.setOnClickListener(this)
        giroscopio.setOnClickListener(this)
        proximidad.setOnClickListener(this)

        //  Conocer qué sensores tiene disponibles nuestro teléfono
        val sensorManager = getSystemService(Context.SENSOR_SERVICE) as? SensorManager
        val listaSensores = sensorManager?.getSensorList(Sensor.TYPE_ALL)

        listaSensores?.forEach {
            sensoresTextView.append(it.name + "\n")
        }
    }

    override fun onClick(v: View?) {
        when (v?.id){
            R.id.vibrador -> {
                val intent = Intent(this, VibradorActivity::class.java)
                startActivity(intent)
            }
            R.id.acelerometro -> {
                val intent = Intent(this, AcelerometroActivity::class.java)
                startActivity(intent)
            }
            R.id.giroscopio -> {
                val intent = Intent(this, GiroscopioActivity::class.java)
                startActivity(intent)
            }
            R.id.proximidad -> {
                val intent = Intent(this, ProximidadActivity::class.java)
                startActivity(intent)
            }
        }
    }
}
