package poker.core.handanalyzer

import poker.core.{Hand, HandStatus, HandType, Kickers}

final class StraightFlushAnalyzer extends HandAnalyzer {
  /** Detect any straight with all five cards of the same suit.
    *
    * Record the highest-ranked card as kicker.
    */
  override def doAnalyze(hand: Hand): HandStatus = {
    if (hand.hasSameSuit && hand.hasConsecutiveCards) {
      HandStatus(HandType.StraightFlush, Kickers(hand.highestRankCard))
    } else {
      HandStatus.none
    }
  }
}
