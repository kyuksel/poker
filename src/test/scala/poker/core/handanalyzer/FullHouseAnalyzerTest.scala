package poker.core.handanalyzer

import org.scalatest.FunSuite
import poker.TestHelpers._
import poker.core.HandStatus
import poker.core.HandType.FullHouse

final class FullHouseAnalyzerTest extends FunSuite {
  test("analyze") {
    val analyzer = new FullHouseAnalyzer

    assert(analyzer.analyze(fullHouseHand) === (FullHouse and kingKickers))
    assert(analyzer.analyze(fourOfAKindHand) === HandStatus.none)
    assert(analyzer.analyze(twoPairHand) === HandStatus.none)
    assert(analyzer.analyze(highCardHand) === HandStatus.none)
  }
}
