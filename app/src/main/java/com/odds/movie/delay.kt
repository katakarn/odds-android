package com.odds.movie

import android.os.Handler
import android.os.Looper

fun delay(beforeDelay: () -> Unit = {}, afterDelay: () -> Unit) {
	beforeDelay()
	Handler(Looper.getMainLooper()).postDelayed({
		afterDelay()
	}, 3000)
}
