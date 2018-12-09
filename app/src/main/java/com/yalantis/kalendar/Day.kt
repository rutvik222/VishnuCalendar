package com.yalantis.kalendar

import android.content.Context
import android.view.Gravity
import android.widget.TextView
import java.util.*

class Day(context: Context) : TextView(context) {
    var label = ""
        set(value) {
            field = value
            text = value
        }
    var date = Date()

    var clickListener: OnDayClickListener? = null

    var canClick = false
    set(value) {
        field = value
        setOnClickListener {
            clickListener?.onDayClick(it as Day)
        }
    }

    var labelColor = 0
    set(value) {
        field = value
        setTextColor(value)
    }

    init {
        isClickable = true
        isFocusable = true
        gravity = Gravity.CENTER
        textAlignment = TextView.TEXT_ALIGNMENT_GRAVITY
    }

    interface OnDayClickListener {
        fun onDayClick(day: Day)
    }
}