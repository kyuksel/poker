package poker.core.handanalyzer

import poker.core.{Hand, HandStatus, HandType, Kickers}

final class ThreeOfAKindAnalyzer extends HandAnalyzer {
  /** Detect any three cards of the same rank.
    *
    * Record all cards as kickers since they could all be used as tie-breaker.
    */
  override def doAnalyze(hand: Hand): HandStatus = {
    if (hand.existsNCardsBySameRank(3)) {
      HandStatus(HandType.ThreeOfAKind, Kickers(hand.cards))
    } else {
      HandStatus.none
    }
  }
}
