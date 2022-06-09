package com.sample

import android.content.Context
import android.content.res.Resources
import android.graphics.Paint
import android.graphics.Rect
import android.util.TypedValue
import kotlin.math.ceil

/**
 * 工具方法
 * @author guoyixiong
 */

fun dpToPx(value: Float, resources: Resources): Int {
    return ceil(value * resources.displayMetrics.density).toInt()
}

fun dpToPx(value: Float, context: Context): Int {
    return dpToPx(value, context.resources)
}

fun spToPx(value: Float, context: Context): Int {
    return ceil(
        TypedValue.applyDimension(
            TypedValue.COMPLEX_UNIT_SP,
            value,
            context.resources.displayMetrics
        )
    ).toInt()
}

fun getTextSizeByHeight(expect: Float): Float {
    val p = Paint()
    p.textSize = expect
    val step = 0.01F
//    val t = "你好"
//    val b = Rect()

    fun getH(): Float {
        val fontMetrics: Paint.FontMetrics = p.fontMetrics
        return fontMetrics.descent - fontMetrics.ascent + fontMetrics.leading
    }

    val first=getH()
    if (first > expect) {
        do {
            p.textSize = p.textSize - step
        } while (getH() > expect)
    }
    if (first < expect) {
        do {
            p.textSize = p.textSize + step
        } while (getH() < expect)
    }

    return p.textSize
}