package poker

import poker.handanalyzer.HandAnalyzer.classify

object Application extends App {
  def determineWinners(hands: Hand*): Set[Hand] = {
    val handsByStatus: Map[HandStatus, Seq[Hand]] = hands.groupBy(classify)

    assert(
      handsByStatus.forall { case (status, _) => status.isTypeKnown },
      "Cannot determine winner when not all hands' types are classifiable"
    )

    handsByStatus.maxBy(_._1)._2.toSet
  }

  def bestPossibleHands(cards: Card*): Set[Hand] = {
    val allPossibleHands = cards.toSeq.combinations(5).toVector.map(Hand(_))

    determineWinners(allPossibleHands: _*)
  }
}
