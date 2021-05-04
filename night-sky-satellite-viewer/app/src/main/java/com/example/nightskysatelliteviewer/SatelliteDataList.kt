package com.example.nightskysatelliteviewer

import java.net.URL

const val satelliteXmlUrlText = "http://www.celestrak.com/NORAD/elements/gp.php?GROUP=active&FORMAT=xml"

object SatelliteDataList {

    val satellites: MutableList<Satellite> = mutableListOf<Satellite>()

    private val satelliteXmlUrl = URL(satelliteXmlUrlText)

    fun updateAll() {
        val xmlText = satelliteXmlUrl.readText()
        //TODO: update all satellite objects
    }

    fun updateSatellite(id: Int) {
        //TODO: update satellite with given id
    }
}