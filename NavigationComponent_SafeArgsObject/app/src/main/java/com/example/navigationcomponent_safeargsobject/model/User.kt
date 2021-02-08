package com.example.navigationcomponent_safeargsobject.model

import android.os.Parcelable
import android.text.Editable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class User(
    val firstName: String,
    val lastName: String
) : Parcelable
