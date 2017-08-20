package poker

import java.util.regex.Pattern

/**
  *
  */
final case class Card private(r: Rank, s: Suit) extends Ordered[Card] {
  def rank: Rank = r

  def rankAsInt: Int = Utils.rankAsInt(rank.char)

  def suit: Suit = s

  def compare(that: Card): Int = this.rankAsInt - that.rankAsInt
}

object Card {
  def apply(card: String): Card = {
    require(isValid(card), s"Invalid card string found: $card")

    val rank = card.head
    val suit = card.last

    Card(Rank(rank), Suit(suit))
  }

  def isValid(card: String): Boolean = validPokerCardPattern.matcher(card).matches

  // Compile regex once and reuse as necessary
  private val validPokerCardPattern = Pattern.compile("[2-9TJQKA]{1}[HCDS]{1}")
}
