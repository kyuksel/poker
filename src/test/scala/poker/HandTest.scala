package poker

import org.scalatest.FunSuite

final class HandTest extends FunSuite {
  import TestHelpers._

  test("hasConsecutiveCards{,StartingWith}") {
    assert(royalFlush.hasConsecutiveCards)
    assert(straight.hasConsecutiveCardsStartingWith('7'))
    assert(!twoPair.hasConsecutiveCards)
  }

  test("hasSameSuit") {
    assert(royalFlush.hasSameSuit)
    assert(!straight.hasSameSuit)
  }

  test("sorted") {
    assert(royalFlushMixed.sorted sameAs royalFlush)
    assert(straightMixed.sorted sameAs straight)
  }

}
