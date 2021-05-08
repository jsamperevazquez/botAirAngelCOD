package bot

import java.io.File

/**
 *
 *
 * @author Aira
 * @since 07/05/2021
 **/
object Configuration {
    val PROPERTIES = mutableMapOf<String, String>()

    /**
     * Loads a configuration file using KEY=VALUE statement
     */
    fun fromFile(path : String) : Boolean {
        val file = File(path)
        if (file.exists()) {
        	println("[!] Configuration started")

            file.forEachLine {
                val prop = it.split("=").toTypedArray()
                if (prop.size > 1) {
					println("- '${prop[0]}' found")
                    PROPERTIES[prop[0].toLowerCase()] = prop[1]
                }
            }

			println()

			return true
        } else {
            println("[!] No configuration found, creating configuration file")
            file.createNewFile()

			return false
        }
    }
}