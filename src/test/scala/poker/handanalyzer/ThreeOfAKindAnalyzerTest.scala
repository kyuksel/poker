package poker.handanalyzer

import org.scalatest.FunSuite
import poker.HandStatus
import poker.HandType.ThreeOfAKind
import poker.TestHelpers._

final class ThreeOfAKindAnalyzerTest extends FunSuite {
  test("analyze") {
    val analyzer = new ThreeOfAKindAnalyzer

    assert(analyzer.analyze(threeOfAKindHand) === (ThreeOfAKind and fiveSevenKickers))
    assert(analyzer.analyze(twoPairHand) === HandStatus.none)
    assert(analyzer.analyze(highCardHand) === HandStatus.none)
  }
}
