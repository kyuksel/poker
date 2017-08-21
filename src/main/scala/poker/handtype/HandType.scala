package poker.handtype

import poker.{Hand, Kickers}

trait HandType {
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

object HandType {
  def all: Seq[HandType] = {
    Seq(
      new RoyalFlush,
      new StraightFlush,
      new FourOfAKind,
      new FullHouse,
      new Flush,
      new Straight,
      new ThreeOfAKind,
      new TwoPair,
      new OnePair,
      new HighCard
    )
  }
}
