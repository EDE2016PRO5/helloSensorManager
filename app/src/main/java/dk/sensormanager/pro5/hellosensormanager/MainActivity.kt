package dk.sensormanager.pro5.hellosensormanager

import android.content.Context
import android.hardware.Sensor
import android.hardware.SensorManager
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity()
{
    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //  Some private members:
        val sensorManager = getSystemService(Context.SENSOR_SERVICE) as SensorManager
        val deviceSensors:MutableList<Sensor> = sensorManager.getSensorList(Sensor.TYPE_ALL)

        //  Update the textview:
        val msg = StringBuilder()
        msg.append("Sensors on this device are:\n-----------------------------------------------\n")

        for(e in deviceSensors)
        {
            msg.append("Name: " + e.name + "\n\n")
        }
        txtSensorList.text = msg
    }
}