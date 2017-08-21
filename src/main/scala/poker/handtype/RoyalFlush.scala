package poker.handtype

import poker.{Hand, Kickers, Utils}

/**
  * T-J-Q-K-A, all of the same suit
  */
final class RoyalFlush extends HandType {
  override def doAnalyze(hand: Hand): (Option[HandType], Option[Kickers]) = {
    if (hand.hasSameSuit && hand.hasConsecutiveCardsStartingWith(Utils.rankAsInt('T'))) {
      (Some(this), None)
    } else {
      (None, None)
    }
  }
}
