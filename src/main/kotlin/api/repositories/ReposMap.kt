package api.repositories

import api.repositories.entities.ReposInfo
import com.google.gson.Gson
import utils.HTTP

/**
 *
 * Creado por @autor: angel
 *       El  02 de jun. de 2021.
 *
 */
class ReposMap {
    /**
     *  HTTP object java Utils
     */
    private val HTTP = HTTP()

    /**
     * Url with de end point
     */
    private var url = "https://api.github.com/users/%s/repos"

    /**
     * Function to collect values and pass them to object
     */
    fun getRepos(user: String): Array<ReposInfo>? {
        val response = HTTP.get(
            String.format(url, user)
        )
        return if (response != null) {
            Gson().fromJson(response, Array<ReposInfo>::class.java)
        } else
            null
    }
}