package bot

import bot.Bot.addToDispatcher
import bot.command.Context
import bot.command.commands.Hello
import bot.command.ICommand
import bot.command.commands.Authors
import bot.command.commands.Dice

/**
 *
 *
 * @author Aira
 * @since 07/05/2021
 **/
class CommandManager {
	val commands = mutableMapOf<String, ICommand>()

	init {
		addCommand("hello", Hello())
		addCommand("dice", Dice())
		addCommand("authors",Authors())
	}

	fun addCommand(name : String, command : ICommand) {
		commands[name] = command
		addToDispatcher(name)
	}

	fun getCommand(name : String) : ICommand? {
		return commands[name]
	}

	fun handle(name : String, context : Context) {
		val invoke : ICommand? = getCommand(name)

		if (invoke != null) {
			invoke.execute(context)
		}
	}
}