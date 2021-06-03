package bot.command.commands

import bot.command.Context
import bot.command.ICommand

/**
 *
 *
 * @author Aira
 * @since 07/05/2021
 **/
class Dice() : ICommand {
	override val name : String = "dice"
	override val description: String = "Rolls a dice, just a classic"

	override fun execute(context: Context) {
		context.sendDice()
	}
}