package poker.app

import poker.Utils._
import poker.core.handanalyzer.HandAnalyzer._
import poker.core.{Card, Hand}

/**
  * App that takes two or more five-card hands and determines
  * the winner(s)
  */
object Winner extends App {
  private val lines = getLines(args)

  private val winners = doMain(lines)

  if (winners.size == 1) {
    val winner = winners.head
    println(s"The winner hand is $winner, which is a ${classify(winner)}.")
  } else {
    println(s"It is a tie between ${winners.mkString(", ")}.")
  }

  private[app] def doMain(jsonArrays: Traversable[String]): Set[Hand] = {
    val parsedArrays = jsonArrays.map(parseJsonArray)
    val hands = parsedArrays.map(arr => Hand(arr.map(Card(_))))

    val winners = determineWinners(hands.toVector: _*)

    assert(winners.nonEmpty, "Unexpected error: There should have been at least one winner!")

    winners
  }
}
