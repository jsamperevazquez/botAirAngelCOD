package bot.command.commands

import WeatherLocation
import bot.Configuration
import bot.command.Context
import bot.command.ICommand

/**
 *
 *
 * @author Aira
 * @since 08/05/2021
 **/
class OpenWeatherMap : ICommand {
	override val name : String = "weather"
	override val description: String = "Shows current weather in the desired location"

	override fun execute(context: Context) {
		val args = context.getArgs()

		if (!Configuration.PROPERTIES.containsKey("api_owm")) {
			context.sendMessage("This command is currently disabled")
		}

		if (args.isNotEmpty()) {
			val key = Configuration.PROPERTIES["api_owm"]
			when (args.size) {
				1 -> {
					// args[0] -> location
					val owm = api.openweathermap.OpenWeatherMap(key.toString())
					val weather = owm.getCurrentWeatherFromLocation(args[0])


					if (weather != null) {
						context.sendMessage(
							"${weather.name} (${weather.sys.country}) - ${weather.weather[0].main} | ${
								"%.2f".format(
									weather.main.temp - 273.15
								)
							}ºC | Humidity: ${weather.main.humidity}%"
						)
					} else {
						context.sendMessage("No data found")
					}
				}

				else -> {
					return
				}
			}
		} else {
			return
		}
	}
}