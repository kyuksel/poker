package poker

/**
  *
  */
final class Hand private (val cards: List[Card]) {
  def hasConsecutiveCards: Boolean = hasConsecutiveCardsStartingWith(lowestRank)

  def hasConsecutiveCardsStartingWith(start: Char): Boolean = {
    hasConsecutiveCardsStartingWith(Utils.rankAsInt(start))
  }

  def hasConsecutiveCardsStartingWith(start: Int): Boolean = {
    ranksSorted == List.tabulate(length)(_ + start)
  }

  def sameAs(that: Hand): Boolean = this.cards == that.cards

  lazy val hasSameSuit: Boolean = suits.toSet.size == 1

  lazy val length: Int = cards.length

  lazy val lowestRank: Int = ranksSorted.head

  lazy val ranks: List[Int] = cards.map(_.rankAsInt)

  lazy val ranksSorted: List[Int] = ranks.sorted

  lazy val sorted: Hand = Hand(cards.sorted)

  lazy val suits: List[Suit] = cards.map(_.suit)
}

object Hand {
  def apply(cards: Traversable[Card]): Hand = {
    validate(cards)

    new Hand(cards.toList)
  }

  def fromStrings(strings: Traversable[String]): Hand = {
    Hand(strings.toList.map(Card(_)))
  }

  private def validate(cards: Traversable[Card]): Unit = {
    val handSize = cards.size

    require(
      handSize == 5,
      s"Invalid hand: Expected 5 cards but found $handSize"
    )
  }
}
