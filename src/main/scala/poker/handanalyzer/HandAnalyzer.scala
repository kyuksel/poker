package poker.handanalyzer

import poker.{Hand, HandStatus}

trait HandAnalyzer {
  /**  Sort hand and delegate analysis to implementers
    *
    *  @param hand collection of five [[poker.Card]]s
    *  @return tuple of type of hand and kicker cards, both optional
    */
  def analyze(hand: Hand): HandStatus = doAnalyze(hand.sorted)

  def doAnalyze(hand: Hand): HandStatus
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
