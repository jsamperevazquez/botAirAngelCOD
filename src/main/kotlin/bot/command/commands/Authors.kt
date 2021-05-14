package bot.command.commands

import bot.command.Context
import bot.command.ICommand

/**
 *
 * Creado por @autor: angel
 *       El  08 de may. de 2021.
 *   //-encoding utf8 -docencoding utf8 -charset utf8(Para el javadoc)
 **/
class Authors() : ICommand {
	override val name : String = "authors"
	override val description: String = "What do you expect to happen?"

	override fun execute(context: Context) {
		context.sendAuthors()
	}

}