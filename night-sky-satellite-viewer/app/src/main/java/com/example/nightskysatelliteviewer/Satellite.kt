package com.example.nightskysatelliteviewer

import java.util.*

class Satellite(val name: String, val id: String, val epoch: Date,
                val mean_motion: Double, val eccentricity: Double,
                val inclination: Double, val raOfAscNode: Double,
                val argOfPericenter: Double, val meanAnomaly: Double,
                val empherisType: Int, val classificationType: String,
                val noradCatId: String, val elementSetNo:Int,
                val revAtEpoch: Int, val bStar: Double,
                val meanMotionDot: Double, val meanMotionDDot: Double) {



}