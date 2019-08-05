package com.example.android.collapsingtoolbar.util

import android.view.View
import androidx.viewpager.widget.ViewPager

const val MINIMUM_SCALE = 0.75f

class PageAnimator : ViewPager.PageTransformer {

    override fun transformPage(view: View, position: Float) {
        view.apply {
            val pageWidth = width
            when {
                position < -1 -> alpha = 0f
                position <= 0 -> {
                    translationX = 0f
                    scaleX = 1f
                    scaleY = 1f
                    alpha = 1f
                }
                position <= 1 -> {
                    val scaleFactor = (MINIMUM_SCALE + (1 - MINIMUM_SCALE) * (1 - Math.abs(position)))
                    scaleX = scaleFactor
                    scaleY = scaleFactor
                    alpha = 1 - position
                    translationX = pageWidth * -position
                }
                else -> alpha = 0f
            }
        }
    }
}