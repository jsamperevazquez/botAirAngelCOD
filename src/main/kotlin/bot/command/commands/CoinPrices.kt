package bot.command.commands
import bot.Configuration
import bot.command.Context
import bot.command.ICommand
import api.coinpricemap.CoinPriceMap
/**
 *
 * Creado por @autor: angel
 *       El  11 de may. de 2021.
 *   //-encoding utf8 -docencoding utf8 -charset utf8(Para el javadoc)
 **/
class CoinPrices :ICommand {
    override fun execute(context: Context) {
        val args = context.getArgs()
        var coin = CoinPriceMap()
        when(args.size){

            0->{
                context.sendMessage("some possibilities\n" +
                        "BTC-EUR\n" +
                        "BTC-USD\n" +
                        "BTC-GBP\n" +
                        "ETH-EUR\n" +
                        "ETH-USD\n" +
                        "ETH-GBP\n" +
                        "XRP-EUR\n" +
                        "XRP-USD\n" +
                        "XRP-GPB\n" +
                        "...")
            }


            1->{
            val price = coin.getCurrentPrice(args[0])
            if (price != null){
                context.sendMessage(
                    "${price.data.amount} ${price.data.currency} "
                )
            }else {
                context.sendMessage("no data found")
            }

        }
            else ->
             return
        }

    }

}