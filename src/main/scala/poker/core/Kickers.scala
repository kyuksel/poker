package poker.core

/**
  * Cards that do not themselves take part in determining the rank of the hand,
  * but that may be used to break ties between hands of the same rank
  */
final case class Kickers(cs: Traversable[Card]) extends Ordered[Kickers] {
  /** Compare the strongest of the kickers */
  // TODO Do we need to consider more than just the strongest kicker cards?
  override def compare(that: Kickers): Int = {
    cs.map(_.rankAsInt).max - that.cs.map(_.rankAsInt).max
  }

  override def toString: String = {
    val sOpt = if (cs.size > 1) "s" else ""
    s"kicker$sOpt ${cs.mkString(", ")}"
  }
}

object Kickers {
  def apply(card: Card): Kickers = Kickers(Vector(card))

  def apply(strings: String*): Kickers = Kickers(strings.map(Card(_)))

  def apply(hand: Hand): Kickers = Kickers(hand.cards)
}
