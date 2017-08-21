package poker.handanalyzer

import org.scalatest.FunSuite
import poker.{HandType, TestHelpers}

final class HandAnalyzerTest extends FunSuite {
  import TestHelpers._

  test("RoyalFlush") {
    val royalFlushAnalyzer = new RoyalFlushAnalyzer

    assert(royalFlushAnalyzer.analyze(royalFlush) === (Some(HandType.RoyalFlush), None))
    assert(royalFlushAnalyzer.analyze(royalFlushMixed) === (Some(HandType.RoyalFlush), None))
    assert(royalFlushAnalyzer.analyze(straight) === (None, None))
  }
}
