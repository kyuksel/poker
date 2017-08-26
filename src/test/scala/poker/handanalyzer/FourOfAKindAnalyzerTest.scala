package poker.handanalyzer

import org.scalatest.FunSuite
import poker.HandStatus
import poker.HandType.FourOfAKind
import poker.TestHelpers._

final class FourOfAKindAnalyzerTest extends FunSuite {
  test("analyze") {
    val analyzer = new FourOfAKindAnalyzer

    assert(analyzer.analyze(fourOfAKindHand) === (FourOfAKind and twoDKicker))
    assert(analyzer.analyze(twoPairHand) === HandStatus.none)
    assert(analyzer.analyze(highCardHand) === HandStatus.none)
  }
}
