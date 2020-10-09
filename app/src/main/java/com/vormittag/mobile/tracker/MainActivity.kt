package com.vormittag.mobile.tracker

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity


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
                goToUPSTrackingInformation(number)
            }
            else if(TrackingNumberValidation().isValidUSPSTrackingNumber(number)) {
                type.text = "It is a usps tracking"
                goToUSPSTrackingInformation(number)
            }
            else if(TrackingNumberValidation().isValidFedexTrackingNumber(number)) {
                type.text = "It is a fedex tracking"
                goToFedexTrackingInformation(number)
            }
            else {
                type.text = "Unknown tracking."
            }
        }
    }

    override fun onStart() {
        super.onStart()
        type.text = ""
    }

    private fun goToUPSTrackingInformation(number:String){
        val url = "https://www.ups.com/track?loc=en_US&tracknum=$number"
        val browserIntent = Intent(Intent.ACTION_VIEW, Uri.parse(url))
        startActivity(browserIntent)
    }

    private fun goToFedexTrackingInformation(number:String){
        val url = "https://www.fedex.com/apps/fedextrack/?action=track&trackingnumber=%@&cntry_code=us$number"
        val browserIntent = Intent(Intent.ACTION_VIEW, Uri.parse(url))
        startActivity(browserIntent)
    }

    private fun goToUSPSTrackingInformation(number: String){
        val url = "https://tools.usps.com/go/TrackConfirmAction?qtc_tLabels1=$number"
        val browserIntent = Intent(Intent.ACTION_VIEW, Uri.parse(url))
        startActivity(browserIntent)
    }








}