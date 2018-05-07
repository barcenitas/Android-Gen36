package com.example.angel5215.sensores

import android.content.Context
import android.content.pm.ActivityInfo
import android.hardware.Sensor
import android.hardware.SensorEvent
import android.hardware.SensorEventListener
import android.hardware.SensorManager
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_acelerometro.*

class AcelerometroActivity : AppCompatActivity(), SensorEventListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_acelerometro)

        requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_PORTRAIT
    }

    override fun onResume() {
        super.onResume()

        val sensorManager = getSystemService(Context.SENSOR_SERVICE) as SensorManager
        val sensores = sensorManager.getSensorList(Sensor.TYPE_ACCELEROMETER)

        if (sensores.size > 0) {
            //  Qué tan rápido obtenemos los datos del sensor
            sensorManager.registerListener(this, sensores.get(0), SensorManager.SENSOR_DELAY_NORMAL)
        }

    }

    //  Uno de los usos del acelerómetro es detectar la orientación de nuestro teléfono
    override fun onPause() {
        super.onPause()
        val sensorManager = getSystemService(Context.SENSOR_SERVICE) as SensorManager
        sensorManager.unregisterListener(this)
    }

    override fun onSensorChanged(event: SensorEvent?) {
        event?.let {
            ejeX.text = "X = ${it.values[0]}"
            ejeY.text = "Y = ${it.values[1]}"
            ejeZ.text = "Z = ${it.values[2]}"
        }
    }

    override fun onAccuracyChanged(sensor: Sensor?, accuracy: Int) {
        //  Método necesario por la interfaz
    }

}
