package poker

/**
  * Cards that do not themselves take part in determining the rank of the hand,
  * but that may be used to break ties between hands of the same rank
  */
final case class Kickers(cards: Traversable[Card])
