import bot.Bot
import bot.Configuration
import kotlin.system.exitProcess

fun main(args: Array<String>) {
    if (args.size > 0) {
        if (!Configuration.fromFile(args[0])) {
            println("[!] Shutting down...")
            exitProcess(0)
        }

    } else {
        // loads configuration from default file
        if (!Configuration.fromFile("configuration")) {
            println("[!] Shutting down...")
            exitProcess(0)
        }
    }

    Bot.start()
}