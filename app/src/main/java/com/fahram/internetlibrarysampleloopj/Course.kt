package com.fahram.internetlibrarysampleloopj

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Course(
    val title : String,
    val path : String,
    val image : String
) : Parcelable
