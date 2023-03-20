package com.staygrateful.gojekclone.ui.anim.interpolator

import android.view.animation.Interpolator
import kotlin.math.cos
import kotlin.math.pow

class CustomBounceInterpolator(
    private val amplitude: Double = 1.0,
    private val frequency: Double = 10.0,
) : Interpolator {
    override fun getInterpolation(input: Float): Float {
        return (-1 * Math.E.pow(-input / amplitude) * cos(frequency * input) + 1).toFloat()
    }
}