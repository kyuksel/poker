package poker.core.handanalyzer

import org.scalatest.FunSuite
import poker.TestHelpers._
import poker.core.HandStatus
import poker.core.HandType.RoyalFlush

final class RoyalFlushAnalyzerTest extends FunSuite {
  test("analyze") {
    val analyzer = new RoyalFlushAnalyzer

    assert(analyzer.analyze(royalFlushHand) === HandStatus(RoyalFlush))
    assert(analyzer.analyze(royalFlushHandMixed) === HandStatus(RoyalFlush))
    assert(analyzer.analyze(straightHand) === HandStatus.none)
  }
}
