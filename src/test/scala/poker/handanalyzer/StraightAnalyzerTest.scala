package poker.handanalyzer

import org.scalatest.FunSuite
import poker.HandStatus
import poker.HandType.Straight
import poker.TestHelpers._

final class StraightAnalyzerTest extends FunSuite {
  test("analyze") {
    val analyzer = new StraightAnalyzer

    assert(analyzer.analyze(royalFlushHandMixed) === (Straight and aceCKicker))
    assert(analyzer.analyze(straightFlushHandMixed) === (Straight and queenCKicker))
    assert(analyzer.analyze(straightHand) === (Straight and jackCKicker))
    assert(analyzer.analyze(straightHandMixed) === (Straight and jackCKicker))
    assert(analyzer.analyze(fourOfAKindHand) === HandStatus.none)
    assert(analyzer.analyze(flushHand) === HandStatus.none)
    assert(analyzer.analyze(twoPairHand) === HandStatus.none)
    assert(analyzer.analyze(highCardHand) === HandStatus.none)
  }
}
