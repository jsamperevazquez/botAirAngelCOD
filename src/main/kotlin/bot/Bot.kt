package bot

import com.github.kotlintelegrambot.bot
import com.github.kotlintelegrambot.dispatch
import com.github.kotlintelegrambot.dispatcher.command
import com.github.kotlintelegrambot.entities.ChatId
import com.github.kotlintelegrambot.network.fold

/**
 *
 *
 * @author Aira
 * @since 07/05/2021
 **/
object Bot {
    val bot = bot {
        token = Configuration.PROPERTIES["TOKEN"].toString()
        dispatch {

        }
    }

    init {
        println("[!] Bot initialized")
    }

    /**
     * Starts the Bot
     */
    fun start() {
        println("[!] Bot startPolling")
        bot.startPolling()
    }
}