package com.vormittag.mobile.tracker

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    private lateinit var trackNoInput: EditText
    private lateinit var type: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        findViews()
    }

    private fun findViews(){
        trackNoInput = findViewById(R.id.trackingNumberInput)
        type = findViewById(R.id.type);
    }

    fun checkBtnClick(view: View) {
        val id = view.id
        if(id == R.id.trackBtn) {
            val number = trackNoInput.text.toString().trim()
            if (TrackingNumberValidation().isValidUPSTrackingNumber(number)){
                type.text = "It is a ups tracking"
            }
            else if(TrackingNumberValidation().isValidUSPSTrackingNumber(number)) {
                type.text = "It is a usps tracking"
            }
            else if(TrackingNumberValidation().isValidFedexTrackingNumber(number)) {
                type.text = "It is a fedex tracking"
            }
            else {
                type.text = "Unknown tracking."
            }
        }
    }








}