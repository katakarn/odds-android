package com.odds.movie

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
class User(val username: String, val password: String): Parcelable
