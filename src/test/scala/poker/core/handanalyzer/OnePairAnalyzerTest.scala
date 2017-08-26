package poker.core.handanalyzer

import org.scalatest.FunSuite
import poker.TestHelpers._
import poker.core.HandType.OnePair
import poker.core.{HandStatus, Kickers}

final class OnePairAnalyzerTest extends FunSuite {
  test("analyze") {
    val analyzer = new OnePairAnalyzer

    assert(analyzer.analyze(royalFlushHand) === HandStatus.none)
    assert(analyzer.analyze(twoPairHand) === (OnePair and Kickers(twoPairHand.sorted.cards)))
    assert(analyzer.analyze(onePairHand) === (OnePair and Kickers(onePairHand.sorted.cards)))
  }
}
