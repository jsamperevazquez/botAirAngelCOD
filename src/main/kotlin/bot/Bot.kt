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
    lateinit var dispatcher : Dispatcher
	val bot = bot {
<<<<<<< HEAD
        token = Configuration.PROPERTIES["TOKEN"].toString()
=======
        token = Configuration.PROPERTIES["token"].toString()
>>>>>>> a1174412d44a08a22b1548846d66c17b89e17368
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

    fun addToDispatcher(name : String) {
		dispatcher.command(name) {
<<<<<<< HEAD
			val context = Context(bot, message)
=======
			val context = Context(bot, message, args)
>>>>>>> a1174412d44a08a22b1548846d66c17b89e17368
			commandManager.handle(name, context)
		}
    }
}