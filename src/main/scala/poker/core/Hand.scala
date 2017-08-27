package poker.core

import poker.Utils

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

  def existsNCardsBySameRank(n: Int): Boolean = cardsByRank.exists(_._2.size == n)
  def findNCardsBySameRank(n: Int): Option[Traversable[Card]] = cardsByRank.find(_._2.size == n).map(_._2)

  override def toString: String = s"[${cards.mkString(", ")}]"

  lazy val cards: Traversable[Card] = cs
  lazy val cardsByRank: Map[Rank, Traversable[Card]] = Hand.byRank(cards)

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

  def existsNCardsBySameRank(cards: Traversable[Card], n: Int): Boolean = byRank(cards).exists(_._2.size == n)

  private def byRank(cards: Traversable[Card]): Map[Rank, Traversable[Card]] = cards.groupBy(_.rank)

  private def validate(cards: Traversable[Card]): Unit = {
    val handSize = cards.toSet.size

    require(
      handSize == 5,
      s"Invalid hand: Expected 5 distinct cards but found $handSize: [${cards.mkString(", ")}]"
    )
  }
}
