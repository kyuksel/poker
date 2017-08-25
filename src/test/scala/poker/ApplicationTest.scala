package poker

import org.scalatest.FunSuite
import Application._
import TestHelpers._

final class ApplicationTest extends FunSuite {
  test("determineWinners") {
    assert(determineWinners(royalFlush, straightFlush) === Set(royalFlush))
    assert(determineWinners(straightFlush, straightFlushMixed) === Set(straightFlush, straightFlushMixed))
  }

  test("bestPossibleHands") {
    val royalFlushPlusOneMoreCard =
      Vector("AD", "2S", "JC", "KD", "7S", "TC", "3H", "AC", "JS", "QC", "KC", "2D").map(Card(_))
    assert(bestPossibleHands(royalFlushPlusOneMoreCard: _*).head.cards === royalFlushMixed.cards)
  }
}
