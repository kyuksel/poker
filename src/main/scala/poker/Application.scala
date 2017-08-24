package poker

import poker.handanalyzer.{RoyalFlushAnalyzer, StraightFlushAnalyzer}

object Application extends App {
  def categorizeHand(hand: Hand): HandStatus = {
    //HandAnalyzer.all.map(_.analyze(hand)).find(HandStatus.nonEmpty) match {
    Seq(new RoyalFlushAnalyzer, new StraightFlushAnalyzer).map(_.analyze(hand)).find(HandStatus.nonEmpty) match {
      case Some(handStatus) => handStatus
      case _ => throw new Error("$hand could not be analyzed!")
    }
  }

  def determineWinnerHand(hand1: Hand, hand2: Hand): Hand = ???

  def determineBestHand(cards: Traversable[Card]): Hand = ???
}
