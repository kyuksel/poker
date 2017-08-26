package poker.core.handanalyzer

import poker.core.{Hand, HandStatus, HandType, Kickers}

final class StraightAnalyzer extends HandAnalyzer {
  /** Detect any five consecutive cards (not necessarily of different suits)
    * where aces can count as high card only.
    *
    * Record highest-ranked card as kicker.
    */
  override def doAnalyze(hand: Hand): HandStatus = {
    if (hand.hasConsecutiveCards) {
      HandStatus(HandType.Straight, Kickers(hand.highestRankCard))
    } else {
      HandStatus.none
    }
  }
}
