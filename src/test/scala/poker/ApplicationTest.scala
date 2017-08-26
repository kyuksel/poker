package poker

import org.scalatest.FunSuite
import Application._
import TestHelpers._
import poker.core.Card

final class ApplicationTest extends FunSuite {
  test("determineWinners") {
    assert(determineWinners(royalFlushHand, straightFlushHand) === Set(royalFlushHand))
    assert(determineWinners(straightFlushHand, straightFlushHandMixed) === Set(straightFlushHand, straightFlushHandMixed))
  }

  test("bestPossibleHands") {
    val royalFlushPlusOneMoreCard =
      Vector("AD", "2S", "JC", "KD", "7S", "TC", "3H", "AC", "JS", "QC", "KC", "2D").map(Card(_))
    assert(bestPossibleHands(royalFlushPlusOneMoreCard: _*).head.cards === royalFlushHandMixed.cards)
  }
}
