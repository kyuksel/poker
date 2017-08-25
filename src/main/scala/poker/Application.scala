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

  def determineWinner(hands: Hand*): Hand = ???
/*
  {
    val handsByOptionalStatus: Map[HandStatus, Seq[Hand]] = hands.groupBy(classify)

    assert(
      handsByOptionalStatus.forall { case (status, _) => status.isTypeKnown },
      "Cannot determine winner when not all hands' types are classifiable")

    handsByOptionalStatus.map()



    val strongestHands: (HandType, Seq[(HandType, Hand)]) = handsByType.maxBy(_._1)

    if (strongestHands)
  }
*/
  def bestHand(cards: Traversable[Card]): Hand = ???
}
