package bot.command

import com.github.kotlintelegrambot.Bot
import com.github.kotlintelegrambot.entities.Chat
import com.github.kotlintelegrambot.entities.ChatId
import com.github.kotlintelegrambot.entities.Message
import com.github.kotlintelegrambot.entities.User

/**
 *
 *
 * @author Aira
 * @since 07/05/2021
 **/
class Context(private val bot: Bot, private val message : Message, private val args : List<String> ) {
	fun getArgs() : List<String> = args
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
}