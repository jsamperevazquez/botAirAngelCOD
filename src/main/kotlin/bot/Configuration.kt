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
    fun fromFile(path : String) {
        val file = File(path)
        if (file.exists()) {
            file.forEachLine {
                val prop = it.split("=").toTypedArray()
                if (prop.size > 1) {
                    PROPERTIES[prop[0]] = prop[1]
                }
            }
        } else {
            println("[!] No configuration found, creating configuration file")
            file.createNewFile()
        }
    }
}