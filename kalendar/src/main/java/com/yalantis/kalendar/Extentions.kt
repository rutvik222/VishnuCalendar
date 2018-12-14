package com.yalantis.kalendar

import android.transition.TransitionManager
import android.util.TypedValue
import android.view.View
import android.view.ViewGroup
import java.util.*
import java.util.Calendar.DAY_OF_WEEK
import java.util.Calendar.MONTH

const val WEEK_OFFSET = 2

const val BLOCKING_TOUCH_WEEK = 3

const val EMPTY_INT = 0

const val EMPTY_STRING = ""


val DAYS_IN_WEEK = 0 until 7


infix fun View.dp(value: Int): Int {
    return TypedValue.applyDimension(
        TypedValue.COMPLEX_UNIT_DIP,
        value.toFloat(),
        this.resources.displayMetrics
    ).toInt()
}

fun View.clicks(enabled: Boolean) {
    if (enabled) {
        isClickable = true
        isFocusable = true
    } else {
        isClickable = false
        isFocusable = false
    }
}

fun ViewGroup.applyTransition(block: () -> Unit) {
    TransitionManager.beginDelayedTransition(this)
    block.invoke()
}

fun Calendar.getDaysAfter() = when (this[DAY_OF_WEEK]) {
    Calendar.SATURDAY -> 0
    Calendar.FRIDAY -> 1
    Calendar.THURSDAY -> 2
    Calendar.WEDNESDAY -> 3
    Calendar.TUESDAY -> 4
    Calendar.MONDAY -> 5
    Calendar.SUNDAY -> 6
    else -> -1
}

fun Calendar.getDaysBefore() = when (this[DAY_OF_WEEK]) {
    Calendar.SATURDAY -> 6
    Calendar.FRIDAY -> 5
    Calendar.THURSDAY -> 4
    Calendar.WEDNESDAY -> 3
    Calendar.TUESDAY -> 2
    Calendar.MONDAY -> 1
    Calendar.SUNDAY -> 0
    else -> -1
}

fun Calendar.previousMonthName(): String {
    this.add(Calendar.MONTH, -1)
    val pre = this.getDisplayName(Calendar.MONTH, Calendar.LONG, Locale.getDefault())
    this.add(MONTH, 1)
    return pre
}
fun Calendar.currentMonthName() = getDisplayName(Calendar.MONTH, Calendar.LONG, Locale.getDefault())

fun Calendar.nextMonthName(): String {
    this.add(Calendar.MONTH, 1)
    val next = this.getDisplayName(Calendar.MONTH, Calendar.LONG, Locale.getDefault())
    this.add(Calendar.MONTH, -1)
    return next
}