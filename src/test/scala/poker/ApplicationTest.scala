package poker

import org.scalatest.FunSuite
import Application._
import TestHelpers._

final class ApplicationTest extends FunSuite {
  test("categorizeHand") {
    assert(classify(straightFlushMixed) === straightFlushWithQueenKickerStatus)
  }
}
