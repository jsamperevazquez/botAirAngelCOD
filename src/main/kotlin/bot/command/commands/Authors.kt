package bot.command.commands

import bot.command.Context
import bot.command.ICommand
import com.github.kotlintelegrambot.entities.InlineKeyboardMarkup
import com.github.kotlintelegrambot.entities.keyboard.InlineKeyboardButton

/**
 *
 * Creado por @autor: angel
 *       El  08 de may. de 2021.
 *
 */

class Authors() : ICommand {
	override val name : String = "authors"
	override val description: String = "What do you expect to happen?"

    override fun execute(context: Context) {
        context.sendMessage(
            text = "Authors: ",
            replyMarkup = InlineKeyboardMarkup.create(
                listOf(
                    InlineKeyboardButton.Url("Jose Angel Sampere", "https://github.com/jsamperevazquez"),
                    InlineKeyboardButton.Url("Jose Ramon Aira", "https://github.com/jairagil")
                )
            )
        )
    }

}