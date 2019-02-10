package com.cobos.edwin.musicplayer

import android.app.AlarmManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.cobos.edwin.musicplayer.alarm.AlarmBroadcastReceiver
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setupAlarm()
    }

    private fun setupAlarm() {
        ok.setOnClickListener {
            val timeValue = time.text.toString().toInt()
            val intent: Intent = Intent(this, AlarmBroadcastReceiver::class.java)
            val pIntent = PendingIntent.getBroadcast(this, 123, intent, PendingIntent.FLAG_UPDATE_CURRENT)
            val alarmManager = getSystemService(Context.ALARM_SERVICE) as AlarmManager
            alarmManager.set(AlarmManager.RTC_WAKEUP, System.currentTimeMillis() + timeValue * 1000, pIntent)
            Toast.makeText(this, "Alarm set in $timeValue seconds", Toast.LENGTH_LONG).show()
        }
    }
}
