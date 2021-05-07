import bot.Bot
import bot.Configuration

fun main(args: Array<String>) {
	if (args.size > 0) {
		Configuration.fromFile(args[0])
	} else {
		// loads configuration from default file
		Configuration.fromFile("configuration")
	}
	
    Bot.start()
}