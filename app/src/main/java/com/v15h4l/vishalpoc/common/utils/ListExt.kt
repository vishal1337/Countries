package com.v15h4l.vishalpoc.common.utils

fun List<String>.joinOrNa(separator: String) =
    takeIf { it.isNotEmpty() }?.joinToString(separator) ?: "N/A"
