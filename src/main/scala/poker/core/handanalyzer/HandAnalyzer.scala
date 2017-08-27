package poker.core.handanalyzer

import poker.core.{Card, Hand, HandStatus}

trait HandAnalyzer {
  /**  Sort hand and delegate analysis to implementers of doAnalyze()
    *
    *  @param hand collection of five [[Card]]s
    *  @return tuple of type of hand and kicker cards, both optional
    */
  def analyze(hand: Hand): HandStatus = doAnalyze(hand.sorted)

  def doAnalyze(hand: Hand): HandStatus
}

object HandAnalyzer {
  val all: Seq[HandAnalyzer] =
    Seq(
      new RoyalFlushAnalyzer,
      new StraightFlushAnalyzer,
      new FourOfAKindAnalyzer,
      new FullHouseAnalyzer,
      new FlushAnalyzer,
      new StraightAnalyzer,
      new ThreeOfAKindAnalyzer,
      new TwoPairAnalyzer,
      new OnePairAnalyzer,
      new HighCardAnalyzer
    )

  def classify(hand: Hand): HandStatus = {
    all.map(_.analyze(hand)).find(HandStatus.nonEmpty) match {
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

  def bestPossibleHands(cards: Card*): Set[Hand] = {
    val allPossibleHands = cards.toSeq.combinations(5).toVector.map(Hand(_))

    determineWinners(allPossibleHands: _*)
  }
}
