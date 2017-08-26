package poker.core.handanalyzer

import poker.core.{Hand, HandStatus, HandType, Kickers}

final class OnePairAnalyzer extends HandAnalyzer {
  /** Detect any two cards of the same rank.
    *
    * Record all of the cards as kickers since they all could be used as tie-breaker.
    */
  override def doAnalyze(hand: Hand): HandStatus = {
    if (hand.existsNCardsBySameRank(2)) {
      HandStatus(HandType.OnePair, Kickers(hand.cards))
    } else {
      HandStatus.none
    }
  }
}
