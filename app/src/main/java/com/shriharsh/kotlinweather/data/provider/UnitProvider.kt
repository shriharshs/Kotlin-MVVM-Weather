package com.shriharsh.kotlinweather.data.provider

import com.shriharsh.kotlinweather.internal.UnitSystem


interface UnitProvider {
    fun getUnitSystem(): UnitSystem
}