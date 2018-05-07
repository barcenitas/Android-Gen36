package com.example.angel5215.sensores

import android.content.Context
import android.hardware.Sensor
import android.hardware.SensorEvent
import android.hardware.SensorEventListener
import android.hardware.SensorManager
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_giroscopio.*

class GiroscopioActivity : AppCompatActivity(), SensorEventListener {

    var giroscopio: Sensor? = null
    lateinit var sensorManager: SensorManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_giroscopio)

        sensorManager = getSystemService(Context.SENSOR_SERVICE) as SensorManager
        giroscopio = sensorManager.getDefaultSensor(Sensor.TYPE_GYROSCOPE)

        if (giroscopio == null) {
            Toast.makeText(this, "No se cuenta con giroscopio", Toast.LENGTH_LONG).show()
        }
    }

    override fun onResume() {
        super.onResume()
        sensorManager.registerListener(this, giroscopio, SensorManager.SENSOR_DELAY_NORMAL)
    }

    override fun onStop() {
        super.onStop()
        sensorManager.unregisterListener(this)
    }

    override fun onSensorChanged(event: SensorEvent?) {
        event?.let {
            x_axis.text = "X = ${it.values[0]} rad/s"
            y_axis.text = "Y = ${it.values[1]} rad/s"
            z_axis.text = "Z = ${it.values[2]} rad/s"

        }
    }

    override fun onAccuracyChanged(sensor: Sensor?, accuracy: Int) {
        //  Método que nos permite realizar acciones cuando la precisión de nuestro sensor cambie.
    }

}
