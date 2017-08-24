package poker.handanalyzer

import org.scalatest.FunSuite
import poker.{HandStatus, HandType, TestHelpers}

final class HandAnalyzerTest extends FunSuite {
  import TestHelpers._

  test("RoyalFlushAnalyzer") {
    val royalFlushAnalyzer = new RoyalFlushAnalyzer

    assert(royalFlushAnalyzer.analyze(royalFlush) === HandStatus(HandType.RoyalFlush), None)
    assert(royalFlushAnalyzer.analyze(royalFlushMixed) === HandStatus(HandType.RoyalFlush), None)
    assert(royalFlushAnalyzer.analyze(straight) === HandStatus.none)
  }

  test("StraightFlushAnalyzer") {
    val straightFlushAnalyzer = new StraightFlushAnalyzer

    assert(straightFlushAnalyzer.analyze(royalFlush) === HandStatus(HandType.StraightFlush, aceKicker))
    assert(straightFlushAnalyzer.analyze(royalFlushMixed) === HandStatus(HandType.StraightFlush, aceKicker))
    assert(straightFlushAnalyzer.analyze(straightFlush) === HandStatus(HandType.StraightFlush, queenKicker))
    assert(straightFlushAnalyzer.analyze(straightFlushMixed) === HandStatus(HandType.StraightFlush, queenKicker))
    assert(straightFlushAnalyzer.analyze(twoPair) === HandStatus.none)
  }
}
