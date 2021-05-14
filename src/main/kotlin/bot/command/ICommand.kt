package bot.command

/**
 * Interface that holds all about a command
 *
 * @author Aira
 * @since 07/05/2021
 **/
interface ICommand {
	/**
	 * Command name
	 */
	val name : String

	/**
	 * Command description
	 */
	val description : String

	/**
	 * Method that will be executed
	 */
	fun execute(context: Context)
}