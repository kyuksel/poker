package poker.core.handanalyzer

import org.scalatest.FunSuite
import poker.TestHelpers._
import poker.core.HandType.FourOfAKind
import poker.core.HandStatus

final class FourOfAKindAnalyzerTest extends FunSuite {
  test("analyze") {
    val analyzer = new FourOfAKindAnalyzer

    assert(analyzer.analyze(fourOfAKindHand) === (FourOfAKind and twoDKicker))
    assert(analyzer.analyze(twoPairHand) === HandStatus.none)
    assert(analyzer.analyze(highCardHand) === HandStatus.none)
  }
}
