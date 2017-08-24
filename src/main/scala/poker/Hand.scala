package poker

/** Set of five poker cards */
final class Hand private (val cs: Vector[Card]) {
  def cards: Traversable[Card] = cs

  def hasConsecutiveCards: Boolean = hasConsecutiveCardsStartingWith(lowestRank)

  def hasConsecutiveCardsStartingWith(start: Char): Boolean = {
    hasConsecutiveCardsStartingWith(Utils.rankAsInt(start))
  }

  def hasConsecutiveCardsStartingWith(start: Int): Boolean = {
    ranksSorted == Vector.tabulate(length)(_ + start)
  }

  def sameAs(that: Hand): Boolean = this.cs == that.cs
  def notSameAs(that: Hand): Boolean = !sameAs(that)

  override def toString: String = s"Hand(${cs.toString})"

  lazy val hasSameSuit: Boolean = suits.toSet.size == 1

  lazy val length: Int = cs.length

  lazy val sorted: Hand = Hand(cs.sorted)

  lazy val suits: Vector[Suit] = cs.map(_.suit)

  lazy val ranks: Vector[Int] = cs.map(_.rankAsInt)
  lazy val ranksSorted: Vector[Int] = ranks.sorted

  lazy val lowestRank: Int = ranksSorted.head
  lazy val highestRank: Int = ranksSorted.last

  lazy val lowestRankCard: Card = sorted.cards.head
  lazy val highestRankCard: Card = sorted.cards.last
}

object Hand {
  def apply(cards: Traversable[Card]): Hand = {
    validate(cards)

    new Hand(cards.toVector)
  }

  def fromStrings(string: String, strings: String*): Hand = {
    Hand((string +: strings.toVector).map(Card(_)))
  }

  private def validate(cards: Traversable[Card]): Unit = {
    val handSize = cards.size

    require(
      handSize == 5,
      s"Invalid hand: Expected 5 cards but found $handSize"
    )
  }
}
