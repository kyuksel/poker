package poker.core.handanalyzer

import org.scalatest.FunSuite
import poker.TestHelpers._
import poker.core.HandType.Flush
import poker.core.HandStatus

final class FlushAnalyzerTest extends FunSuite {
  test("analyze") {
    val analyzer = new FlushAnalyzer

    assert(analyzer.analyze(royalFlushHand) === (Flush and aceCKicker))
    assert(analyzer.analyze(royalFlushHandMixed) === (Flush and aceCKicker))
    assert(analyzer.analyze(straightFlushHand) === (Flush and queenCKicker))
    assert(analyzer.analyze(straightFlushHandMixed) === (Flush and queenCKicker))
    assert(analyzer.analyze(flushHand) === (Flush and jackHKicker))
    assert(analyzer.analyze(twoPairHand) === HandStatus.none)
  }
}
