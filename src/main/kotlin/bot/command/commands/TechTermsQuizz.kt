package bot.command.commands

import bot.command.Context
import bot.command.ICommand
import com.google.gson.Gson
import com.google.gson.JsonObject
import okhttp3.FormBody
import okhttp3.OkHttpClient
import okhttp3.Request
import utils.HTTP
import java.text.DateFormat
import java.text.SimpleDateFormat
import java.time.LocalDateTime
import java.time.LocalTime
import java.time.format.DateTimeFormatter
import java.util.*


/**
 *
 *
 * @author Aira
 * @since 01/06/2021
 **/
class TechTermsQuizz : ICommand {
	override val name: String = "quiz"
	override val description: String = "Random TechTerms quiz!"

	override fun execute(context: Context) {
		val responseHTML = HTTP().get("https://techterms.com")
		val quizz = mutableListOf<String>()

		responseHTML.toString().replace("><", ">\n<").split("\n").filter {
			it.contains("quizAnswer") || it.contains("quizQuestion")
		}.forEachIndexed { i, element ->
			if (element.contains("quizQuestion")) {
				quizz.add(
					i,
					element.substring(
						element.indexOf(">") + 1, element.indexOf("</p>")
					)
				)
			} else {
				quizz.add(
					i,
					element.substring(
						element.indexOf(">") + 1, element.indexOf("</span>")
					)
				)
			}
		}

		val formBody = FormBody.Builder()
			.add("action", "load")
			.add("date", DateTimeFormatter.ofPattern("yyyy-MM-dd").format(LocalDateTime.now()))
			.build()

		val request = Request.Builder()
			.url("https://techterms.com/lib/quiz_scripts.php")
			.post(formBody)
			.build()

		val responseJSON = Gson().fromJson(OkHttpClient().newCall(request).execute().use { response ->
			response.body?.string()
		}, JsonObject::class.java)

		val correct : Int = when (responseJSON.get("Correct").asString) {
			"A" -> 0
			"B" -> 1
			"C" -> 2
			"D" -> 3
			else -> -1
		}

		context.sendPoll(quizz[0], quizz.subList(1, quizz.size), correct)
	}
}