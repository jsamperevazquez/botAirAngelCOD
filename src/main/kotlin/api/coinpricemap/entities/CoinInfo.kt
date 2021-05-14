package api.coinpricemap.entities

/**
 *
 * Creado por @autor: angel
 *       El  12 de may. de 2021.
 *   //-encoding utf8 -docencoding utf8 -charset utf8(Para el javadoc)
 **/

data class CoinInfo(
    val `data`: Data
)

data class Data(
    val amount: String,
    val base: String,
    val currency: String
)


