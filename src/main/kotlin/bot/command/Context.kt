package bot.command

import com.github.kotlintelegrambot.Bot
import com.github.kotlintelegrambot.entities.*
import com.github.kotlintelegrambot.entities.keyboard.InlineKeyboardButton
import com.github.kotlintelegrambot.entities.polls.PollType
import retrofit2.http.HTTP
import java.io.BufferedReader
import java.io.InputStream
import java.io.InputStreamReader
import java.net.HttpURLConnection
import java.net.URL
import java.net.http.HttpRequest

/**
 *
 *
 * @author Aira
 * @since 07/05/2021
 **/
class Context(private val bot: Bot, private val message: Message, private val args: List<String>) {
    fun getArgs(): List<String> = args
    fun getBot(): Bot = bot
    fun getChat(): ChatId = ChatId.fromId(message.chat.id)
    fun getChatId(): Long = message.chat.id
    fun getMessage(): Message = message
    fun getMessageId(): Long = message.messageId
    fun getUser(): User? = message.from

    fun sendDice() {
        bot.sendDice(getChat())
    }

    fun sendMessage(
        text: String,
        parseMode: ParseMode? = null,
        disableWebPagePreview: Boolean? = null,
        disableNotification: Boolean? = null,
        replyToMessageId: Long? = null,
        replyMarkup: ReplyMarkup? = null
    ) {
        bot.sendMessage(
            chatId = getChat(),
            text = text,
            parseMode = parseMode,
            disableWebPagePreview = disableWebPagePreview,
            disableNotification = disableNotification,
            replyToMessageId = replyToMessageId,
            replyMarkup = replyMarkup
        )
    }

	fun sendReply(text: String) {
		bot.sendMessage(
			chatId = getChat(),
			text = text,
			replyToMessageId = getMessageId()
		)
	}

	fun sendPoll(question: String, options: List<String>, correctOptionId: Int?) {
		bot.sendPoll(
			chatId = getChat(),
			type = PollType.QUIZ,
			question = question,
			options = options,
			correctOptionId = correctOptionId,
			isAnonymous = false
		)
	}
}