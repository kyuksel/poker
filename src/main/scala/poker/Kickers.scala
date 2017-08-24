package poker

/**
  * Cards that do not themselves take part in determining the rank of the hand,
  * but that may be used to break ties between hands of the same rank
  */
final case class Kickers(cards: Vector[Card]) {
  lazy val sorted: Vector[Card] = cards.sorted

  lazy val ranks: Vector[Int] = cards.map(_.rankAsInt)
  lazy val ranksSorted: Vector[Int] = ranks.sorted

  lazy val lowestRankCard: Card = sorted.head
  lazy val highestRankCard: Card = sorted.last
}

object Kickers {
  def apply(card: Card): Kickers = Kickers(Vector(card))

  def fromString(strings: Traversable[String]): Kickers = Kickers(strings.map(Card(_)).toVector)
  def fromString(string: String): Kickers = Kickers.fromString(Traversable(string))
}
