package poker.core.handanalyzer

import org.scalatest.FunSuite
import poker.TestHelpers._
import poker.core.HandType.ThreeOfAKind
import poker.core.{HandStatus, Kickers}

final class ThreeOfAKindAnalyzerTest extends FunSuite {
  test("analyze") {
    val analyzer = new ThreeOfAKindAnalyzer

    assert(analyzer.analyze(threeOfAKindHand) === (ThreeOfAKind and Kickers(threeOfAKindHand.sorted.cards)))
    assert(analyzer.analyze(twoPairHand) === HandStatus.none)
    assert(analyzer.analyze(highCardHand) === HandStatus.none)
  }
}
