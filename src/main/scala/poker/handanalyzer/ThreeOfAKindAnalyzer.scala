package poker.handanalyzer

import poker.{Hand, HandStatus, HandType, Kickers}

final class ThreeOfAKindAnalyzer extends HandAnalyzer {
  /** Detect any three cards of the same rank */
  override def doAnalyze(hand: Hand): HandStatus = {
    if (hand.existsNCardsBySameRank(3)) {
      val kickers = hand.cards.toSeq diff hand.findNCardsBySameRank(3).get.toSeq

      HandStatus(HandType.ThreeOfAKind, Kickers(kickers))
    } else {
      HandStatus.none
    }
  }
}
