package poker.handtype

import poker.{Hand, Kickers}

final class HighCard extends HandType {
  override def doAnalyze(hand: Hand): (_root_.scala.Option[HandType], _root_.scala.Option[_root_.poker
  .Kickers]) = ???
}
