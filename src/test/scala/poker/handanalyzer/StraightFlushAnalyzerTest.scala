package poker.handanalyzer

import org.scalatest.FunSuite
import poker.HandType.StraightFlush
import poker.HandStatus
import poker.TestHelpers._

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
