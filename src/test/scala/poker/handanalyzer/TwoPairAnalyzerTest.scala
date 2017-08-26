package poker.handanalyzer

import org.scalatest.FunSuite
import poker.{HandStatus, Kickers}
import poker.HandType.TwoPair
import poker.TestHelpers._

final class TwoPairAnalyzerTest extends FunSuite {
  test("analyze") {
    val analyzer = new TwoPairAnalyzer

    assert(analyzer.analyze(royalFlushHand) === HandStatus.none)
    assert(analyzer.analyze(twoPairHand) === (TwoPair and Kickers(twoPairHand.sorted.cards)))
    assert(analyzer.analyze(onePairHand) === HandStatus.none)
  }
}
