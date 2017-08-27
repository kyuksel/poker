package poker.app

import poker.Utils._
import poker.core.handanalyzer.HandAnalyzer.classify
import poker.core.{Card, Hand, HandStatus}

object Classification extends App {
  private val lines = getLines(args)

  require(
    lines.size == 1,
    "The file should contain a single line with a JSON array " +
      "such as [\"TC\", \"JC\", \"QC\", \"KC\", \"AC\"]" +
      s"Found ${lines.size}"
  )

  private val jsonArray = lines.head

  doMain(jsonArray)

  private[app] def doMain(jsonArray: String): HandStatus = {
    val parsedHandStr = parseJsonArray(jsonArray)
    val parsedHandStrSize = parsedHandStr.size

    require(
      parsedHandStrSize == 5,
      s"Expected hand size of 5 but found $parsedHandStrSize"
    )

    val hand = Hand(parsedHandStr.map(Card(_)))

    val status = classify(hand)

    println(status)

    status
  }
}
