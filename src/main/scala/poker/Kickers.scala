package poker

/**
  * Cards that do not themselves take part in determining the rank of the hand,
  * but that may be used to break ties between hands of the same rank
  */
final case class Kickers(cards: Vector[Card]) {
  override def toString: String = {
    val sOpt = if (cards.size > 1) "s" else ""
    s"kicker$sOpt ${cards.mkString(", ")}"
  }

  lazy val sorted: Vector[Card] = cards.sorted

  lazy val ranks: Vector[Int] = cards.map(_.rankAsInt)
  lazy val ranksSorted: Vector[Int] = ranks.sorted

  lazy val lowestRankCard: Card = sorted.head
  lazy val highestRankCard: Card = sorted.last
}

object Kickers {
  def apply(card: Card): Kickers = Kickers(Vector(card))

  def fromStrings(string: String, strings: String*): Kickers = {
    Kickers((string +: strings.toVector).map(Card(_)))
  }
}
