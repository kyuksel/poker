package poker.handanalyzer

import org.scalatest.FunSuite
import poker.HandType.StraightFlush
import poker.handanalyzer.HandAnalyzer.classify
import poker.TestHelpers._

final class HandAnalyzerTest extends FunSuite {
  test("classify") {
    assert(classify(straightFlushHandMixed) === (StraightFlush and queenCKicker))
  }
}
