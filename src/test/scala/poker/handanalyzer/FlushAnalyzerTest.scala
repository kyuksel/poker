package poker.handanalyzer

import org.scalatest.FunSuite
import poker.HandStatus
import poker.HandType.Flush
import poker.TestHelpers._

final class FlushAnalyzerTest extends FunSuite {
  test("analyze") {
    val analyzer = new FlushAnalyzer

    assert(analyzer.analyze(royalFlushHand) === (Flush and aceKicker))
    assert(analyzer.analyze(royalFlushHandMixed) === (Flush and aceKicker))
    assert(analyzer.analyze(straightFlushHand) === (Flush and queenKicker))
    assert(analyzer.analyze(straightFlushHandMixed) === (Flush and queenKicker))
    assert(analyzer.analyze(flushHand) === (Flush and jackKicker))
    assert(analyzer.analyze(twoPairHand) === HandStatus.none)
  }
}
