package bot.command.commands

import bot.command.Context
import bot.command.ICommand

/**
 *
 *
 * @author Aira
 * @since 07/05/2021
 **/
class Hello() : ICommand {
	override fun execute(context : Context) {
		context.sendReply("Hello world!")
	}
}