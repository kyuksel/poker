package poker

import org.scalatest.FunSuite

final class HandTest extends FunSuite {
  import TestHelpers._

  test("hasConsecutiveCards{,StartingWith}") {
    assert(royalFlushHand.hasConsecutiveCards)
    assert(straightHand.hasConsecutiveCardsStartingWith('7'))
    assert(!twoPairHand.hasConsecutiveCards)
  }

  test("hasSameSuit") {
    assert(royalFlushHand.hasSameSuit)
    assert(!straightHand.hasSameSuit)
  }

  test("sorted") {
    assert(royalFlushHandMixed.sorted isSameAs royalFlushHand)
    assert(straightHandMixed.sorted isSameAs straightHand)
  }

  test("existsNCardsBySameRank") {
    assert(royalFlushHand.existsNCardsBySameRank(1))
    assert(!royalFlushHand.existsNCardsBySameRank(2))
    assert(fourOfAKindHand.existsNCardsBySameRank(4))
    assert(!fourOfAKindHand.existsNCardsBySameRank(3))
    assert(fullHouseHand.existsNCardsBySameRank(3))
    assert(fullHouseHand.existsNCardsBySameRank(2))
    assert(Hand("2D", "3S", "4H", "5C", "6C").existsNCardsBySameRank(1))
    assert(!Hand("2D", "3S", "4H", "5C", "6C").existsNCardsBySameRank(2))
  }

  test("findNCardsBySameRank") {
    assert(fourOfAKindHand.findNCardsBySameRank(4) === Some(Vector("AS", "AD", "AC", "AH").map(Card(_))))
    assert(fourOfAKindHand.findNCardsBySameRank(1) === Some(Vector("2D").map(Card(_))))
    assert(fullHouseHand.findNCardsBySameRank(3) === Some(Vector("AS", "AC", "AD").map(Card(_))))
    assert(fullHouseHand.findNCardsBySameRank(2) === Some(Vector("KD", "KS").map(Card(_))))
  }

  test("validate") {
    // Identical cards
    doIntercept("KC", "KC", "AC", "AS", "6D")

    // Too few cards
    doIntercept("KC", "AC", "AS", "6D")

    // No cards
    doIntercept()

    // Too many cards
    doIntercept("KC", "AC", "AS", "6D", "QH", "7S")

    def doIntercept(s: String*) = {
      intercept[IllegalArgumentException] {
        Hand(s: _*)
      }
    }
  }
}
