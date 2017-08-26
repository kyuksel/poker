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
