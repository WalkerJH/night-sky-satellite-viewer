package com.example.nightskysatelliteviewer

import org.w3c.dom.Document
import java.net.URL
import org.xml.sax.InputSource
import java.io.StringReader
import javax.xml.parsers.*

const val satelliteXmlUrlText = "http://www.celestrak.com/NORAD/elements/gp.php?GROUP=active&FORMAT=xml"

object SatelliteDataList {

    val satellites: MutableList<Satellite> = mutableListOf<Satellite>()

    private val satelliteXmlUrl = URL(satelliteXmlUrlText)

    fun updateAll() {
        val xmlText = satelliteXmlUrl.readText()

        val xmlDoc = stringToXmlDoc(xmlText)
        val root = xmlDoc.firstChild
        //TODO: update all satellite objects
    }

    fun updateSatellite(id: Int) {
        //TODO: update satellite with given id
    }

    private fun stringToXmlDoc(text: String): Document {
        val factory: DocumentBuilderFactory = DocumentBuilderFactory.newInstance()
        val builder: DocumentBuilder = factory.newDocumentBuilder()
        val xmlDoc = builder.parse(InputSource(StringReader(text)))
        return xmlDoc
    }
}