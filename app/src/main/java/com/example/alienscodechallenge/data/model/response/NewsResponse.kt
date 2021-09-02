package com.example.alienscodechallenge.data.model.response

import com.example.alienscodechallenge.domain.model.News

data class NewsResponse(
    val status: Int?,
    val news: List<News>?,
) {
    companion object {
        fun mock() = NewsResponse(
            status = 200,
            news = listOf(
                News(title = "Mayoral candidate pledges to make NYC 'most cryptocurrency-friendly city in the nation",
                    content = "Some mayors of U.S. cities large and small have been pushing for the adoption of cryptocurrencies or otherwise taking a position in favor of digital assets. Curtis Sliwa, a beret-wearing Republican running to be the mayor of New York City, said one of the goals of his campaign is to focus on crypto.\n"+
                            "In a Wednesday tweet, Sliwa said he would be focusing on creating greater financial inclusivity in New York City by opening more crypto ATMs and incentivizing businesses to accept cryptocurrency. According to his campaign website, however, the mayoral candidate currently only accepts donations in U.S. dollars using personal checks or credit cards.",
                    author = "TURNER WRIGHT",
                    imageUrl = "https://images.cointelegraph.com/images/1434_aHR0cHM6Ly9zMy5jb2ludGVsZWdyYXBoLmNvbS91cGxvYWRzLzIwMjEtMDkvY2Y5ZTM3NGQtZmI0MC00NzY4LWFhNDktZTI5NDQ4YTgxMDE2LmpwZw==.jpg"
                ),
                News(title = "El Salvador police arrested and released Bitcoin detractor without a warrant",
                    content = "The National Civil Police later released a statement saying Mario Gómez’s detainment was related to an investigation for financial fraud.\n"+
                            "A Salvadoran news outlet has reported that a computer and cryptocurrency expert critical of the country accepting Bitcoin as legal tender was arrested by local police and held for hours before being released.\n" +
                            "According to multiple interviews conducted by La Prensa Gráfica, police in San Salvador arrested computer specialist Mario Gómez Wednesday without a warrant, seizing his phone and attempting to take possession of a computer from his mother Elena de Gomez. The National Civil Police, or PNC, released a statement saying Gómez’s detainment was related to an investigation for financial fraud. Otto Flores, Gómez’s lawyer, said authorities released Gómez later that afternoon.\n" +
                            "[Mario] participates a lot in forums, in events, on social networks and is critical of the government,\" said his mother. \"If we see that the country is going backward, it is necessary to speak because it is a human right to express our opinions.”\n" +
                            "Gómez has regularly posted on social media about his opposition to legislation set to make Bitcoin (BTC) legal tender in El Salvador on Sept. 7. His Twitter posts include allegations that individuals behind the government’s Bitcoin wallet “Chivo” may be associated with the same BTC address associated with the massive hack of Twitter in July 2020. He has also made No Al Bitcoin (No To Bitcoin) stickers available to his thousands of followers.",
                    author = "TURNER WRIGHT",
                    imageUrl = "https://images.cointelegraph.com/images/1434_aHR0cHM6Ly9zMy5jb2ludGVsZWdyYXBoLmNvbS91cGxvYWRzLzIwMjEtMDkvOTIxY2VmNTUtZjJhZC00OTI2LThmNzgtODQ5ZjE4OWMwMjU4LmpwZw==.jpg"
                ),
                News(title = "Price analysis 9/1: BTC, ETH, ADA, BNB, XRP, DOGE, SOL, DOT, UNI, LUNA",
                    content = "Bitcoin price continues to press higher within its range and altcoins broke out after ETH rose above a key resistance level.\n"+
                            "Bitcoin (BTC) is struggling to break above \$50,000 but analysts remain confident due to strong on-chain metrics. Analyst Willy Woo believes that investors have been accumulating Bitcoin and a break above \$50,000 could result in a quick up-move to \$60,000.\n" +
                            "Another positive voice was that of SkyBridge Capital CEO Anthony Scaramucci, who said in an interview with Cointelegraph that the limited, fixed supply of Bitcoin and exponentially growing demand will boost prices higher. Scaramucci personally believes that Bitcoin could reach \$100,000 before the end of the year.",
                    author = "RAKESH UPADHYAY",
                    imageUrl = "https://images.cointelegraph.com/images/1434_aHR0cHM6Ly9zMy5jb2ludGVsZWdyYXBoLmNvbS91cGxvYWRzLzIwMjEtMDkvNzU0MDJlZTQtMjVhYy00N2E1LTlmZGItNmRiNjMwYmM4YzZiLmpwZw==.jpg"
                )
            )
        )
    }
}