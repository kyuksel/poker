package poker.handanalyzer

import poker.{Hand, HandType, Kickers, Utils}

/** T-J-Q-K-A, all of the same suit */
final class RoyalFlushAnalyzer extends HandAnalyzer {
  override def doAnalyze(hand: Hand): (Option[HandType], Option[Kickers]) = {
    if (hand.hasSameSuit && hand.hasConsecutiveCardsStartingWith(Utils.rankAsInt('T'))) {
      (Some(HandType.RoyalFlush), None)
    } else {
      (None, None)
    }
  }
}
