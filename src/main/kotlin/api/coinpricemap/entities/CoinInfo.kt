package api.coinpricemap.entities

/**
 *
 * Creado por @autor: angel
 *       El  12 de may. de 2021.
 *
 * To create coin values objects from jsons
 */

data class CoinInfo(
    val `data`: Data
)

data class Data(
    val amount: String,
    val base: String,
    val currency: String
)


