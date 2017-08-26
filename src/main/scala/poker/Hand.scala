package poker

/** Set of five poker cards */
final class Hand private (cs: Vector[Card]) {
  def hasConsecutiveCards: Boolean = hasConsecutiveCardsStartingWith(lowestRank)

  def hasConsecutiveCardsStartingWith(start: Char): Boolean = {
    hasConsecutiveCardsStartingWith(Utils.rankAsInt(start))
  }

  def hasConsecutiveCardsStartingWith(start: Int): Boolean = {
    ranksSorted == Vector.tabulate(length)(_ + start)
  }

  def isSameAs(that: Hand): Boolean = this.cards == that.cards
  def isNotSameAs(that: Hand): Boolean = !isSameAs(that)

  override def toString: String = s"Hand(${cs.toString})"

  lazy val cards: Traversable[Card] = cs

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

  def apply(strings: String*): Hand = apply(strings.map(Card(_)))

  private def validate(cards: Traversable[Card]): Unit = {
    val handSize = cards.toSet.size

    require(
      handSize == 5,
      s"Invalid hand: Expected 5 distinct cards but found $handSize: [${cards.mkString(", ")}]"
    )
  }
}
