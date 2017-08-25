package poker.handanalyzer

import org.scalatest.FunSuite
import poker.{HandStatus, HandType}
import poker.TestHelpers._

final class RoyalFlushAnalyzerTest extends FunSuite {
  test("analyze") {
    val royalFlushAnalyzer = new RoyalFlushAnalyzer

    assert(royalFlushAnalyzer.analyze(royalFlush) === HandStatus(HandType.RoyalFlush), None)
    assert(royalFlushAnalyzer.analyze(royalFlushMixed) === HandStatus(HandType.RoyalFlush), None)
    assert(royalFlushAnalyzer.analyze(straight) === HandStatus.none)
  }
}
