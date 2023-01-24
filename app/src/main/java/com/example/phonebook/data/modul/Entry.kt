package com.example.phonebook.data.modul

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Entry(
    val name: String,
    val mobileNumber: String,
    val imageResource: Int
): Parcelable
