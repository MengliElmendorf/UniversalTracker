package com.vormittag.mobile.tracker

class TrackingNumberValidation {

    fun isValidUPSTrackingNumber(number: String) : Boolean {
        val upsNumberFormat1 = "1Z ?[0-9A-Z]{3} ?[0-9A-Z]{3} ?[0-9A-Z]{2} ?[0-9A-Z]{4} ?[0-9A-Z]{3} ?[0-9A-Z]|[\\\\dT]\\\\d\\\\d\\\\d ?\\\\d\\\\d\\\\d\\\\d ?\\\\d\\\\d\\\\d".toRegex()
        val upsNumberFormat2 = "[kKJj]{1}[0-9]{10}".toRegex()
        return upsNumberFormat1.matches(number) || upsNumberFormat2.matches(number)
    }

    fun isValidUSPSTrackingNumber(number: String) : Boolean{
        val uspsNumberFormat1 = "(\\b\\d{30}\\b)|(\\b91\\d+\\b)|(\\b\\d{20}\\b)".toRegex()
        val uspsNumberFormat2 = "^E\\D{1}\\d{9}\\D{2}\$|^9\\d{15,21}$".toRegex()
        val uspsNumberFormat3 = "^91[0-9]+$".toRegex()
        val uspsNumberFormat4 = "^[A-Za-z]{2}[0-9]+US\$".toRegex()
        return uspsNumberFormat1.matches(number)||uspsNumberFormat2.matches(number)||uspsNumberFormat3.matches(number)||uspsNumberFormat4.matches(number)
    }

    fun isValidFedexTrackingNumber(number: String) :Boolean {
        val fedexNumberFormat1 = "(\\b96\\d{20}\\b)|(\\b\\d{15}\\b)|(\\b\\d{12}\\b)".toRegex()
        val fedexNumberFormat2 = "b((98\\d\\d\\d\\d\\d?\\d\\d\\d\\d|98\\d\\d) ?\\d\\d\\d\\d ?\\d\\d\\d\\d( ?\\d\\d\\d)?)\\b".toRegex()
        val fedexNumberFormat3 = "^[0-9]{15}\$".toRegex()
        return fedexNumberFormat1.matches(number) || fedexNumberFormat2.matches(number) || fedexNumberFormat3.matches(number)
    }
}