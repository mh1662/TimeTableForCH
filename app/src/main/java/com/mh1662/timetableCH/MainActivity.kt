package com.mh1662.timetableCH

import android.os.Bundle
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(findViewById(R.id.toolbar))

        findViewById<FloatingActionButton>(R.id.fab).setOnClickListener {
            val dialog = AddTimeDialog()
            dialog.show(supportFragmentManager, DIALOG_ADD_TIME)
        }
    }

    data class AddTimeData(var title : String, var location : String, var startTime : String, var endTime : String)
}