package poker

import org.scalatest.FunSuite
import Application._
import TestHelpers._

final class ApplicationTest extends FunSuite {
  test("classify") {
    assert(classify(straightFlushMixed) === straightFlushWithQueenKickerStatus)
  }

  test("determineWinners") {
    assert(determineWinners(royalFlush, straightFlush) === Set(royalFlush))
    assert(determineWinners(straightFlush, straightFlushMixed) === Set(straightFlush, straightFlushMixed))
  }
}
