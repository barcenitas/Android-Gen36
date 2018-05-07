package com.example.angel5215.sensores

import android.content.Context
import android.graphics.Color
import android.hardware.Sensor
import android.hardware.SensorEvent
import android.hardware.SensorEventListener
import android.hardware.SensorManager
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_proximidad.*

class ProximidadActivity : AppCompatActivity(), SensorEventListener{

    var i = 0

    lateinit var sensorManager: SensorManager

    var sensorProximidad: Sensor? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_proximidad)

        sensorManager = getSystemService(Context.SENSOR_SERVICE) as SensorManager

        sensorProximidad = sensorManager.getDefaultSensor(Sensor.TYPE_PROXIMITY)

        sensorManager.registerListener(this, sensorProximidad, SensorManager.SENSOR_DELAY_NORMAL)

    }

    override fun onSensorChanged(event: SensorEvent?) {

        var distancia = -1f
        event?.let {
            distancia = it.values[0]
        }

        prox_contador.text = "Entrada + ${i}"
        texto_prox.text = "Distancia = ${distancia} [cm]"

        if(distancia >= 3){
            layout_prox.setBackgroundColor(Color.GRAY)
        }
        else {
            layout_prox.setBackgroundColor(Color.RED)
        }
    }

    override fun onAccuracyChanged(sensor: Sensor?, accuracy: Int) {
        //  Nos permite medir cuando la precisión del sensor cambia
    }
}
