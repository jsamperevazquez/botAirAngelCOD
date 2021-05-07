import bot.Bot
import bot.Configuration
import com.github.kotlintelegrambot.bot
import com.github.kotlintelegrambot.dispatch
import com.github.kotlintelegrambot.dispatcher.command
import com.github.kotlintelegrambot.dispatcher.text
import com.github.kotlintelegrambot.entities.ChatId
import com.github.kotlintelegrambot.network.fold

fun main(args: Array<String>) {
    // loads configuration from file
    Configuration.fromFile("configuration")
    Bot.start()
}