package poker.handanalyzer

import org.scalatest.FunSuite
import poker.{HandStatus, Kickers}
import poker.HandType.OnePair
import poker.TestHelpers._

final class OnePairAnalyzerTest extends FunSuite {
  test("analyze") {
    val analyzer = new OnePairAnalyzer

    assert(analyzer.analyze(royalFlushHand) === HandStatus.none)
    assert(analyzer.analyze(twoPairHand) === (OnePair and Kickers(twoPairHand.sorted.cards)))
    assert(analyzer.analyze(onePairHand) === (OnePair and Kickers(onePairHand.sorted.cards)))
  }
}
