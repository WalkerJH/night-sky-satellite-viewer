package com.example.nightskysatelliteviewer

import java.net.URL

class SatelliteDataDownloader {
    val satelliteXmlUrl = "http://www.celestrak.com/NORAD/elements/gp.php?GROUP=active&FORMAT=xml"

    val satelliteXmlLink = URL(satelliteXmlUrl)

}