package poker.core.handanalyzer

import org.scalatest.FunSuite
import poker.TestHelpers._
import poker.core.HandStatus
import poker.core.HandType.StraightFlush

final class StraightFlushAnalyzerTest extends FunSuite {
  test("analyze") {
    val analyzer = new StraightFlushAnalyzer

    assert(analyzer.analyze(royalFlushHand) === (StraightFlush and aceCKicker))
    assert(analyzer.analyze(royalFlushHandMixed) === (StraightFlush and aceCKicker))
    assert(analyzer.analyze(straightFlushHand) === (StraightFlush and queenCKicker))
    assert(analyzer.analyze(straightFlushHandMixed) === (StraightFlush and queenCKicker))
    assert(analyzer.analyze(twoPairHand) === HandStatus.none)
  }
}
