package com.odds.movie.data

import android.content.Context

class SharePreferenceLocalStorage(private val context: Context): LocalStorange {

    override fun insert(data: String) {
        context.getSharedPreferences("movie", Context.MODE_PRIVATE)
            .edit()
            .putString("username", data)
            .apply()
    }

    override fun read(): String {
        return context.getSharedPreferences("movie", Context.MODE_PRIVATE)
            .getString("username", "").orEmpty()
    }
}

interface LocalStorange{
    fun insert(data: String)
    fun read(): String
}