package poker.handanalyzer

import org.scalatest.FunSuite
import poker.HandType.StraightFlush
import poker.HandStatus
import poker.TestHelpers._

final class StraightFlushAnalyzerTest extends FunSuite {
  test("analyze") {
    val analyzer = new StraightFlushAnalyzer

    assert(analyzer.analyze(royalFlushHand) === (StraightFlush and aceKicker))
    assert(analyzer.analyze(royalFlushHandMixed) === (StraightFlush and aceKicker))
    assert(analyzer.analyze(straightFlushHand) === (StraightFlush and queenKicker))
    assert(analyzer.analyze(straightFlushHandMixed) === (StraightFlush and queenKicker))
    assert(analyzer.analyze(twoPairHand) === HandStatus.none)
  }
}
