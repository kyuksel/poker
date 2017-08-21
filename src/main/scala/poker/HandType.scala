package poker

sealed trait HandType

object HandType {
  case object RoyalFlush extends HandType
  case object StraightFlush extends HandType
  case object FourOfAKind extends HandType
  case object FullHouse extends HandType
  case object Flush extends HandType
  case object Straight extends HandType
  case object ThreeOfAKind extends HandType
  case object TwoPair extends HandType
  case object OnePair extends HandType
  case object HighCardAnalyzer extends HandType
}
