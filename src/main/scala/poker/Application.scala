package poker

import poker.handtype.HandType

/**
  *
  */
object Application extends App {
  def categorizeHand(hand: Hand): (Option[HandType], Option[Kickers]) = ???

  def determineWinnerHand(hands: Traversable[Hand]): Hand = ???

  def determineBestHand(cards: Traversable[Card]): Hand = ???
}
