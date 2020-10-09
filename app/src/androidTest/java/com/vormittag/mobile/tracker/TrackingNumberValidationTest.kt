package com.vormittag.mobile.tracker

import org.junit.Test

import org.junit.Assert.*

class TrackingNumberValidationTest {

    /** Sample Data **/
    /**
    USPS:
    70160910000108310009   (certified)
    23153630000057728970   (signature confirmation)
    RE360192014US          (registered mail)
    EL595811950US          (priority express)
    9374889692090270407075 (regular)

    FEDEX:
    810132562702  (all seem to follow same pattern regardless)
    795223646324
    785037759224

    UPS:
    K2479825491         (UPS ground)
    J4603636537         (UPS next day express)
    1Z87585E4391018698  (regular)
     **/

    private val ups1 = "K2479825491"
    private val ups2 = "J4603636537"
    private val ups3 = "1Z87585E4391018698"

    private val usps1 = "70160910000108310009"
    private val usps2 = "23153630000057728970"
    private val usps3 = "RE360192014US"
    private val usps4 = "EL595811950US"
    private val usps5 = "9374889692090270407075"

    private val fedex1 = "810132562702"
    private val fedex2 = "795223646324"
    private val fedex3 = "785037759224"


    @Test
    fun upsRegularExpression_Test() {
        assertTrue(TrackingNumberValidation().isValidUPSTrackingNumber(ups1))
        assertTrue(TrackingNumberValidation().isValidUPSTrackingNumber(ups2))
        assertTrue(TrackingNumberValidation().isValidUPSTrackingNumber(ups3))
    }

    @Test
    fun uspsRegularExpression_Test() {
        assertTrue(TrackingNumberValidation().isValidUSPSTrackingNumber(usps1))
        assertTrue(TrackingNumberValidation().isValidUSPSTrackingNumber(usps2))
        assertTrue(TrackingNumberValidation().isValidUSPSTrackingNumber(usps3))
        assertTrue(TrackingNumberValidation().isValidUSPSTrackingNumber(usps4))
        assertTrue(TrackingNumberValidation().isValidUSPSTrackingNumber(usps5))
    }

    @Test
    fun fedexRegularExpression_Test() {
        assertTrue(TrackingNumberValidation().isValidFedexTrackingNumber(fedex1))
        assertTrue(TrackingNumberValidation().isValidFedexTrackingNumber(fedex2))
        assertTrue(TrackingNumberValidation().isValidFedexTrackingNumber(fedex3))
    }
}