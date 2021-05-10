package api.openweathermap

import WeatherLocation
import com.google.gson.Gson
import utils.HTTP

/**
 *
 *
 * @author Aira
 * @since 08/05/2021
 **/
class OpenWeatherMap(private val apiKey : String) {
	val HTTP = HTTP()
	private val URL = mapOf<String, String>(
		"base" to "https://api.openweathermap.org/data/2.5",
		"weather" to "/weather?q=%s&appid=${apiKey}"
	)

	fun getCurrentWeatherFromLocation(location : String) : WeatherLocation? {
		val response = HTTP.get(
			String.format("${URL["base"]}${URL["weather"]}", location)
		)

		return if (response != null) {
			Gson().fromJson(response, WeatherLocation::class.java)
		} else {
			null
		}
	}
}