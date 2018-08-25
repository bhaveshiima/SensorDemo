package vsl.bhavesh.sensordemo

import android.content.Context
import android.hardware.Sensor
import android.hardware.SensorEvent
import android.hardware.SensorEventListener
import android.hardware.SensorManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Vibrator
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        var sManager = getSystemService(Context.SENSOR_SERVICE) as SensorManager


        // TYPE_ACCELEROMETER SENSOR [ START ]
        var sensor = sManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER)

        sManager.registerListener(
                object : SensorEventListener {
                    override fun onAccuracyChanged(p0: Sensor?, p1: Int) {

                    }

                    override fun onSensorChanged(p0: SensorEvent?) {
                        // when sensor change then this function called..
                        var values = p0!!.values //FloatArray is the return type
                        tv1.text = values[0].toString()
                        tv2.text = values[1].toString()
                    }

                },sensor,SensorManager.SENSOR_DELAY_NORMAL)
        // TYPE_ACCELEROMETER SENSOR [ END ]


        // TYPE_PROXIMITY SENSOR [ START ]
        var sensorP = sManager.getDefaultSensor(Sensor.TYPE_PROXIMITY)

        sManager.registerListener(
                object : SensorEventListener {
                    override fun onAccuracyChanged(p0: Sensor?, p1: Int) {

                    }

                    override fun onSensorChanged(p0: SensorEvent?) {
                        // when sensor change then this function called..
                        var values = p0!!.values //FloatArray is the return type
                        tv3.text = values[0].toString()
                        //tv2.text = values[1].toString()
                    }

                },sensorP,SensorManager.SENSOR_DELAY_NORMAL)
        // TYPE_PROXIMITY SENSOR [ END ]






        // Btn for Vibrate Code [ START ]
        btn1.setOnClickListener {
            var vib = getSystemService(Context.VIBRATOR_SERVICE) as Vibrator
            vib.vibrate(5000)
        }
        // Btn for Vibrate Code [ END ]

    }// onCreate [ END ]
}
