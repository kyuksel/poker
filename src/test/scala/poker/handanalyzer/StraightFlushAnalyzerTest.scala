package poker.handanalyzer

import org.scalatest.FunSuite
import poker.{HandStatus, HandType}
import poker.TestHelpers._

final class StraightFlushAnalyzerTest extends FunSuite {
  test("analyze") {
    val straightFlushAnalyzer = new StraightFlushAnalyzer

    assert(straightFlushAnalyzer.analyze(royalFlush) === HandStatus(HandType.StraightFlush, aceKicker))
    assert(straightFlushAnalyzer.analyze(royalFlushMixed) === HandStatus(HandType.StraightFlush, aceKicker))
    assert(straightFlushAnalyzer.analyze(straightFlush) === HandStatus(HandType.StraightFlush, queenKicker))
    assert(straightFlushAnalyzer.analyze(straightFlushMixed) === HandStatus(HandType.StraightFlush, queenKicker))
    assert(straightFlushAnalyzer.analyze(twoPair) === HandStatus.none)
  }
}
