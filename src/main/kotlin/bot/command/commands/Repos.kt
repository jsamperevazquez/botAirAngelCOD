package bot.command.commands

import api.repositories.ReposMap
import api.repositories.entities.ReposInfo
import bot.command.Context
import bot.command.ICommand
import com.github.kotlintelegrambot.entities.ParseMode

/**
 *
 * Creado por @autor: angel
 *       El  02 de jun. de 2021.
 * Class to create de Repos command
 */

class Repos() : ICommand {

    /**
     * Command name
     */
    override val name: String = "repos"

    /**
     *  Command description
     */
    override val description: String = " All user's GitHub repositories "

    /**
     * Execute function with context to point to repositories
     */

    override fun execute(context: Context) {
        val args = context.getArgs()
        val repos = ReposMap()


        when (args.size) {
            0 -> {
                context.sendMessage(" Please enter the username after the command ")
            }
            1 -> {
                val reposInf = repos.getRepos(args[0])
                reposInf!!.forEach {
                    context.sendMessage(
                        String.format(
                            "*${it.language}* [${it.name}](%s)",
                            it.html_url
                        ),
                        ParseMode.MARKDOWN_V2
                    )
                }
            }
            else ->
                return
        }

    }

}

