package poker.handtype

import poker.{Hand, HandType, Kickers}

final class FourOfAKind extends HandType {
  override def status(hand: Hand): (Option[HandType], Option[Kickers]) = ???
}
