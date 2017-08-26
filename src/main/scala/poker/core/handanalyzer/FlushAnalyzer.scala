package poker.core.handanalyzer

import poker.core.{Hand, HandStatus, HandType, Kickers}

final class FlushAnalyzer extends HandAnalyzer {
  /** Detect any five cards of the same suit (not necessarily consecutive) */
  override def doAnalyze(hand: Hand): HandStatus = {
    if (hand.hasSameSuit) {
      HandStatus(HandType.Flush, Kickers(hand.highestRankCard))
    } else {
      HandStatus.none
    }
  }
}
