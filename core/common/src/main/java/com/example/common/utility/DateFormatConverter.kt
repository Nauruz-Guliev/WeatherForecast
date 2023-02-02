package com.example.common.utility

import java.text.SimpleDateFormat
import java.util.*


fun Long.convert(pattern: String) = SimpleDateFormat(
    pattern,
    Locale.getDefault()
).format(this)


object DateFormats {
    val FULL_DATE_FORMAT_WITHOUT_TIME = "EEEE, dd \n else MMMM"
    val TIME_ONLY_WITH_SECONDS = "hh:mm:ss"
    val TIME_ONLY_WITHOUT_SECONDS = "hh:mm"
}