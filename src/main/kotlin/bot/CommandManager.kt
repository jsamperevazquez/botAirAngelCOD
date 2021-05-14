package bot

import bot.Bot.addToDispatcher
import bot.command.Context
import bot.command.ICommand
import bot.command.commands.*


/**
 *
 *
 * @author Aira
 * @since 07/05/2021
 **/
class CommandManager {
	private val commands = mutableMapOf<String, ICommand>()

	init {
		addCommand(Hello())
		addCommand(Dice())
		addCommand(OpenWeatherMap())
		addCommand(Authors())
		addCommand(CoinPrices())

		// generates a list to add to BotFather
		generateList()

		println("--> BOT INITIALIZATION <--")
	}

	/**
	 * Adds the ICommand to the Map
	 */
	private fun addCommand(command: ICommand) {
		commands[command.name] = command
		addToDispatcher(command.name)
	}

	/**
	 * Gets the ICommand from the Map
	 */
	private fun getCommand(name: String): ICommand? {
		return commands[name]
	}

	/**
	 * Executes the command if exist
	 */
	fun handle(name: String, context: Context) {
		getCommand(name)?.execute(context)
	}

	/**
	 * Prints the sorted list of the commands formatted for BotFather
	 */
	private fun generateList() {
		println("--> COMMAND LIST <--")

		// sorts the map and prints the command list
		val sorted = commands.toSortedMap()
		sorted.forEach { (k, v) ->
			println("$k - ${v.description}")
		}

		println()
	}
}