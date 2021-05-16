# Telegram Bot
Project made with Kotlin

## Configuration
***CONFIGURATION CODE***

    fun fromFile(path: String): Boolean {
    val file = File(path)
    if (file.exists()) {
    println("--> CONFIGURATION <--")`

			file.forEachLine {
				val prop = it.split("=").toTypedArray()
				if (prop.size > 1) {
					println("[!] '${prop[0]}' found")
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


## Commnands

***COMMAND LIST***
* author -  What do you expect to happen?
* dice -  Rolls a dice, just a classic
* hello -  Say hello!
* value -  Shows a Cryptocurrency value in Fiat
* weather -  Shows current weather in the desired location



## use bot images and gifs
![Hello png](https://github.com/jsamperevazquez/botAirAngelCOD/blob/Dev/src/main/kotlin/utils/media/hello.png)
![Dice gif](https://github.com/jsamperevazquez/botAirAngelCOD/blob/Dev/src/main/kotlin/utils/media/dice.gif)
![Authors gif](https://github.com/jsamperevazquez/botAirAngelCOD/blob/Dev/src/main/kotlin/utils/media/authors.gif)



## Libraries
- [Gson](https://github.com/google/gson) 
- [Kotlin Telegram Bot](https://github.com/kotlin-telegram-bot/kotlin-telegram-bot)  
- [OkHttp](https://github.com/square/okhttp)  
