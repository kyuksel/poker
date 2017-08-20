package poker.handtype

import poker.{Hand, HandType, Kickers}

final class OnePair extends HandType {
  override def status(hand: Hand): (_root_.scala.Option[_root_.poker.HandType], _root_.scala.Option[_root_.poker
  .Kickers]) = ???
}
