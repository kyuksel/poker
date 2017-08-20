package poker.handtype

import poker._

/**
  * T-J-Q-K-A, all of the same suit
  */
final class RoyalFlush extends HandType {
  override def status(hand: Hand): (Option[HandType], Option[Kickers]) = {
    if (hand.hasSameSuit && hand.hasConsecutiveCardsStartingWith(Utils.rankAsInt('T'))) {
      (Some(this), None)
    } else {
      (None, None)
    }
  }
}
