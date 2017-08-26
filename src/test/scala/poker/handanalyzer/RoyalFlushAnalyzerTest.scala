package poker.handanalyzer

import org.scalatest.FunSuite
import poker.HandType.RoyalFlush
import poker.HandStatus
import poker.TestHelpers._

final class RoyalFlushAnalyzerTest extends FunSuite {
  test("analyze") {
    val analyzer = new RoyalFlushAnalyzer

    assert(analyzer.analyze(royalFlushHand) === HandStatus(RoyalFlush))
    assert(analyzer.analyze(royalFlushHandMixed) === HandStatus(RoyalFlush))
    assert(analyzer.analyze(straightHand) === HandStatus.none)
  }
}
