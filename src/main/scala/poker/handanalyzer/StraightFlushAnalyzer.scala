package poker.handanalyzer

import poker.{Hand, HandType, Kickers}

final class StraightFlushAnalyzer extends HandAnalyzer {
  /** Detect any straight with all five cards of the same suit */
  override def doAnalyze(hand: Hand): (Option[HandType], Option[Kickers]) = {
    if (hand.hasSameSuit && hand.hasConsecutiveCards) {
      (Some(HandType.StraightFlush), None)
    } else {
      (None, None)
    }
  }
}
