package poker

/**
  *
  */
object Application extends App {
  def categorizeHand(hand: Hand): (Option[HandType], Option[Kickers]) = ???

  def determineWinnerHand(hands: Traversable[Hand]): Hand = ???

  def determineBestHand(cards: Traversable[Card]): Hand = ???
}
