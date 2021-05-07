import com.github.kotlintelegrambot.bot
import com.github.kotlintelegrambot.dispatch
import com.github.kotlintelegrambot.dispatcher.command
import com.github.kotlintelegrambot.dispatcher.text
import com.github.kotlintelegrambot.entities.ChatId
import com.github.kotlintelegrambot.network.fold

fun main(args: Array<String>) {
    println("Hello Bot!")

    val bot = bot {
        token = ApiKey.miToken
        dispatch {
            command("start") {
                val result = bot.sendMessage(chatId = ChatId.fromId(message.chat.id), text = "Hola, estoy escuchando las peticiones")
                result.fold({
                    // do something here with the response
                },{
                    // do something with the error
                })
            }

            // Comando hola
            command("hola") {

                val result = bot.sendMessage(chatId = ChatId.fromId(update.message!!.chat.id), text = "HOLA DAM 2020")

                result.fold(
                    {
                        // do something here with the response
                    },
                    {
                        // do something with the error
                    }
                )
            }
        }
    }
    bot.startPolling()
}