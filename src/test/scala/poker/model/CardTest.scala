package poker.model

import poker.{Card, Rank, Suit}

final class CardTest extends org.scalatest.FunSuite {
  import Card._

  private def doIntercept(s: String) = {
    intercept[IllegalArgumentException] {
      Card(s)
    }
  }

  private val validCards = Traversable("2H", "9C", "JD", "QS", "KH", "AH")
  private val onlySuits = Traversable("H", "C", "D", "S")
  private val onlyRanks = Traversable("2", "9", "J", "K", "Q", "A")
  private val invalidNumberOfChars = Traversable("", "9C8", "2HJD")
  private val invalidChars = Traversable("1H", "2I", "0S", "RC", "BH")

  test("Card construction") {
    assert(Card("2H").rank === Rank('2'))
    assert(Card("2H").suit === Suit('H'))

    onlySuits.foreach(doIntercept)
    onlyRanks.foreach(doIntercept)
    invalidNumberOfChars.foreach(doIntercept)
    invalidChars.foreach(doIntercept)
  }

  test("isValid") {
    assert(validCards.forall(isValid))
    assert(onlySuits.forall(!isValid(_)))
    assert(onlyRanks.forall(!isValid(_)))
    assert(invalidNumberOfChars.forall(!isValid(_)))
    assert(invalidChars.forall(!isValid(_)))
  }
}
