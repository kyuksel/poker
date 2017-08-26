package poker

final class CardTest extends org.scalatest.FunSuite {
  import Card._

  private val validCards = Traversable("2H", "9C", "JD", "QS", "KH", "AH")
  private val onlySuits = Traversable("H", "C", "D", "S")
  private val onlyRanks = Traversable("2", "9", "J", "K", "Q", "A")
  private val invalidNumberOfRanksOrSuits = Traversable("", "9C8", "2HJD")
  private val invalidSuits = Traversable("1H", "2I", "0S", "RC", "BH")

  test("Card construction") {
    assert(Card("2H").rank === Rank('2'))
    assert(Card("2H").suit === Suit('H'))

    onlySuits.foreach(doIntercept)
    onlyRanks.foreach(doIntercept)
    invalidNumberOfRanksOrSuits.foreach(doIntercept)
    invalidSuits.foreach(doIntercept)

    def doIntercept(s: String) = {
      intercept[IllegalArgumentException] {
        Card(s)
      }
    }
  }

  test("isValid") {
    assert(validCards.forall(isValid))
    assert(notValid(onlySuits))
    assert(notValid(onlyRanks))
    assert(notValid(invalidNumberOfRanksOrSuits))
    assert(notValid(invalidSuits))

    def notValid(strings: Traversable[String]): Boolean = {
      strings.forall(!isValid(_))
    }
  }

  test("compare") {
    doCompare("3C", "4C", -1)
    doCompare("3C", "4D", -1)
    doCompare("AH", "JS", 3)
    doCompare("KH", "KC", 0)
    doCompare("TS", "2S", 8)

    def doCompare(c1: String, c2: String, res: Int): Unit = {
      assert(Card(c1).compare(Card(c2)) === res)
    }
  }
}
