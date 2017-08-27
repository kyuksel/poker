package poker.core.handanalyzer

import org.scalatest.FunSuite
import poker.TestHelpers._
import poker.core.HandType.TwoPair
import poker.core.{HandStatus, Kickers}

final class TwoPairAnalyzerTest extends FunSuite {
  test("analyze") {
    val analyzer = new TwoPairAnalyzer

    assert(analyzer.analyze(royalFlushHand) === HandStatus.none)
    assert(analyzer.analyze(twoPairHand) === (TwoPair and Kickers(twoPairHand.sorted.cards)))
    assert(analyzer.analyze(onePairHand) === HandStatus.none)
  }
}
