package poker.handtype

import poker.{Hand, Kickers}

final class TwoPair extends HandType {
  override def doAnalyze(hand: Hand): (Option[HandType], Option[Kickers]) = ???
}
