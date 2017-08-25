package poker.handanalyzer

import org.scalatest.FunSuite
import poker.TestHelpers._

final class HandAnalyzerTest extends FunSuite {
  test("classify") {
    assert(HandAnalyzer.classify(straightFlushMixed) === straightFlushWithQueenKickerStatus)
  }
}
