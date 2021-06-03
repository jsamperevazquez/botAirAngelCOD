package api.coinpricemap

import api.coinpricemap.entities.CoinInfo
import com.google.gson.Gson
import utils.HTTP
import javax.swing.JOptionPane

/**
 *
 * Creado por @autor: angel
 * El  12 de may. de 2021.
 *
 */

class CoinPriceMap() {

    private val HTTP = HTTP()
    private val URL = "https://api.coinbase.com/v2/prices/%s/buy"

    /**
     * @author Angel
     * @return object CoinInfo created with Gson from Json
     */
    fun getCurrentPrice(criptoFiat: String): CoinInfo? {

        val response = HTTP.get(
            String.format(URL, criptoFiat)
        )
        return if (response != null) {
            Gson().fromJson(response, CoinInfo::class.java)
        } else {
            null
        }
    }
}
