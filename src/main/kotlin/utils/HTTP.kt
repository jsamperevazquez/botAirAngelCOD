package utils

import okhttp3.OkHttpClient
import okhttp3.Request

class HTTP {
    private val CLIENT = OkHttpClient()

    fun get(url : String) : String? {
        val request = Request.Builder()
            .url(url)
            .build()

        CLIENT.newCall(request).execute().use { response ->
            return response.body?.string()
        }
    }
}