package bot.command

import com.github.kotlintelegrambot.Bot
import com.github.kotlintelegrambot.entities.*
import com.github.kotlintelegrambot.entities.keyboard.InlineKeyboardButton
import kotlin.coroutines.coroutineContext

/**
 *
 *
 * @author Aira
 * @since 07/05/2021
 **/
class Context(private val bot: Bot, private val message : Message) {
	fun getBot() : Bot = bot
	fun getChat() : ChatId = ChatId.fromId(message.chat.id)
	fun getChatId() : Long = message.chat.id
	fun getMessage() : Message = message
	fun getMessageId() : Long = message.messageId
	fun getUser() : User? = message.from

	fun sendDice() {
		bot.sendDice(getChat())
	}
	fun sendMessage(text : String) {
		bot.sendMessage(getChat(), text)
	}
	fun sendReply(text : String) {
		bot.sendMessage(
			chatId = getChat(),
			text = text,
			replyToMessageId = getMessageId())
	}
	fun sendAuthors(){
		bot.sendMessage(
			chatId = getChat(),
			text = "Bot authors",
			replyMarkup = InlineKeyboardMarkup.create(
				listOf(
					InlineKeyboardButton.CallbackData("Angel Sampere", "Sampere"),
					InlineKeyboardButton.CallbackData("Jose Ramón Aira", "Aira")
				)
			)
		)
		bot.answerCallbackQuery("Sampere",url = "https://github.com/jsamperevazquez?tab=repositories",showAlert = true)
		bot.answerCallbackQuery("Aira",url = "https://github.com/jairagil?tab=repositories",showAlert = true)

	}

}