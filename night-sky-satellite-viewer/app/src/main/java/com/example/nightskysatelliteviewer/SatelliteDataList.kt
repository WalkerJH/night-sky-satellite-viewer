package com.example.nightskysatelliteviewer

import org.w3c.dom.Document
import org.w3c.dom.Element
import org.w3c.dom.NodeList
import org.xml.sax.InputSource
import java.io.StringReader
import java.net.URL
import java.text.SimpleDateFormat
import java.util.*
import javax.xml.parsers.DocumentBuilder
import javax.xml.parsers.DocumentBuilderFactory

const val satelliteXmlUrlText = "http://www.celestrak.com/NORAD/elements/gp.php?GROUP=active&FORMAT=xml"
const val epochDateFormat = "yyyy-MM-dd'T'HH:mm:ss.SSSSSS"

object SatelliteDataList {

    val satellites: MutableList<Satellite> = mutableListOf<Satellite>()

    private val satelliteXmlUrl = URL(satelliteXmlUrlText)

    fun updateSatellite(id: Int) {
        //TODO: update satellite with given id
    }

    fun updateAll() {
        val xmlText = satelliteXmlUrl.readText()

        val xmlDoc = stringToXmlDoc(xmlText)
        val satelliteXmlElements: NodeList? = xmlDoc.getElementsByTagName("body")
        if (satelliteXmlElements != null) {
            for (i in 0 until satelliteXmlElements.length) {
                satellites.add(createSatelliteFromXml(satelliteXmlElements.item(i) as Element))
            }
        }
    }

    private fun createSatelliteFromXml(xmlElement: Element): Satellite {
        val name = getElementContent(xmlElement, "OBJECT_NAME")
        val id = getElementContent(xmlElement, "OBJECT_ID")
        val epoch = parseDate(getElementContent(xmlElement, "EPOCH"))
        val mean_motion = getElementContent(xmlElement, "MEAN_MOTION") as Double
        val eccentricity = getElementContent(xmlElement, "ECCENTRICITY") as Double
        val inclination = getElementContent(xmlElement, "INCLINATION") as Double
        val raOfAscNode = getElementContent(xmlElement, "RA_OF_ASC_NODE") as Double
        val argOfPericenter = getElementContent(xmlElement, "ARG_OF_PERICENTER") as Double
        val meanAnomaly = getElementContent(xmlElement, "MEAN_ANOMALY") as Double
        return Satellite(name, id, epoch, mean_motion, eccentricity, inclination,
                            raOfAscNode, argOfPericenter, meanAnomaly)
    }

    private fun parseDate(dateString: String): Long {
        return SimpleDateFormat(epochDateFormat).parse(dateString).getTime()
    }

    private fun getElementContent(element: Element, name: String): String {
        return element.getElementsByTagName(name).item(0).textContent
    }

    private fun stringToXmlDoc(text: String): Document {
        val factory: DocumentBuilderFactory = DocumentBuilderFactory.newInstance()
        val builder: DocumentBuilder = factory.newDocumentBuilder()
        return builder.parse(InputSource(StringReader(text)))
    }
}