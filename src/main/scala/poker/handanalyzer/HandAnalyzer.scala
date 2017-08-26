package poker.handanalyzer

import poker.{Hand, HandStatus}

trait HandAnalyzer {
  /**  Sort hand and delegate analysis to implementers of doAnalyze()
    *
    *  @param hand collection of five [[poker.Card]]s
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
}
