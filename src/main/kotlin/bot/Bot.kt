package bot

import bot.command.Context
import com.github.kotlintelegrambot.bot
import com.github.kotlintelegrambot.dispatch
import com.github.kotlintelegrambot.dispatcher.Dispatcher
import com.github.kotlintelegrambot.dispatcher.command
import com.github.kotlintelegrambot.updater.Updater

/**
 *
 *
 * @author Aira
 * @since 07/05/2021
 **/
object Bot {
    lateinit var dispatcher: Dispatcher
    val bot = bot {
        token = Configuration.PROPERTIES["token"].toString()
        dispatcher = updater.dispatcher
    }

    private val commandManager = CommandManager()

    init {
        println("[!] Bot initialized")
    }

    /**
     * Starts the Bot
     */
    fun start() {
        bot.startPolling()
        println("[!] Bot started polling")
    }

    fun addToDispatcher(name: String) {
        dispatcher.command(name) {
            val context = Context(bot, message, args)
            commandManager.handle(name, context)
        }
    }
}