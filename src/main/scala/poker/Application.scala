package poker

import poker.handanalyzer.{RoyalFlushAnalyzer, StraightFlushAnalyzer}

object Application extends App {
  def classify(hand: Hand): HandStatus = {
    //HandAnalyzer.all.map(_.analyze(hand)).find(HandStatus.nonEmpty) match {
    Seq(new RoyalFlushAnalyzer, new StraightFlushAnalyzer).map(_.analyze(hand)).find(HandStatus.nonEmpty) match {
      case Some(handStatus) => handStatus
      case _ => throw new Error("$hand could not be analyzed!")
    }
  }

  def determineWinners(hands: Hand*): Set[Hand] = {
    val handsByStatus: Map[HandStatus, Seq[Hand]] = hands.groupBy(classify)

    assert(
      handsByStatus.forall { case (status, _) => status.isTypeKnown },
      "Cannot determine winner when not all hands' types are classifiable"
    )

    handsByStatus.maxBy(_._1)._2.toSet
  }

  def bestPossibleHand(cards: Traversable[Card]): Hand = ???
}
