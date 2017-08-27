package poker.core.handanalyzer

import poker.core.{Hand, HandStatus, HandType}
import poker.Utils

final class RoyalFlushAnalyzer extends HandAnalyzer {
  /** Detect any T-J-Q-K-A, all of the same suit */
  override def doAnalyze(hand: Hand): HandStatus = {
    if (hand.hasSameSuit && hand.hasConsecutiveCardsStartingWith(Utils.rankAsInt('T'))) {
      HandStatus(HandType.RoyalFlush)
    } else {
      HandStatus.none
    }
  }
}
