package poker.app

import poker.Utils._
import poker.core.handanalyzer.HandAnalyzer._
import poker.core.{Card, Hand}

/**
  * App that takes five or more cards, and returns the best five-card hand
  * that can be made with those cards.
  */
object Best extends App {
  private val lines = getLines(args)

  require(
    lines.size == 1,
    "The file should contain a single line with a JSON array " +
      "such as [\"TC\", \"JC\", \"QC\", \"KC\", \"AC\", \"5D\"]" +
      s"Found ${lines.size}"
  )

  private val jsonArray = lines.head

  private val bestHands = doMain(jsonArray)

  if (bestHands.size == 1) {
    val bestHand = bestHands.head
    println(s"The best possible hand is $bestHand, which is a ${classify(bestHand)}.")
  } else {
    println(s"The best possible hands are ${bestHands.mkString(", ")}.")
  }

  private[app] def doMain(jsonArray: String): Set[Hand] = {
    val parsedHandStr = parseJsonArray(jsonArray)
    val parsedHandStrSize = parsedHandStr.size

    require(
      parsedHandStrSize >= 5,
      s"Expected hand size of 5 or more but found $parsedHandStrSize"
    )

    val cards = parsedHandStr.map(Card(_)).toVector

    bestPossibleHands(cards: _*)
  }
}
