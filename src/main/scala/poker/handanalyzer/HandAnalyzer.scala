package poker.handanalyzer

import poker.{Hand, HandType, Kickers}

trait HandAnalyzer {
  /**  Sort hand and delegate analysis to implementers
    *
    *  @param hand collection of five [[poker.Card]]s
    *  @return tuple of type of hand and kicker cards, both optional
    */
  def analyze(hand: Hand): (Option[HandType], Option[Kickers]) = {
    doAnalyze(hand.sorted)
  }

  def doAnalyze(hand: Hand): (Option[HandType], Option[Kickers])
}

object HandAnalyzer {
  def all: Seq[HandAnalyzer] = {
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
  }
}
