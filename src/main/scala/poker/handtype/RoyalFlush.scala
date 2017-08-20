package poker.handtype

import poker.{Hand, HandType, Kickers, Utils}

/**
  * T-J-Q-K-A, all of the same suit
  */
final class RoyalFlush extends HandType {
  override def status(hand: Hand): (Option[HandType], Option[Kickers]) = {
    if (hand.hasSameSuit && hand.sorted.hasConsecutiveCardsStartingWith(Utils.rankAsInt('T'))) {
      (Some(this), None)
    } else {
      (None, None)
    }
  }
}
