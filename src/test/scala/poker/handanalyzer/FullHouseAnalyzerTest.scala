package poker.handanalyzer

import org.scalatest.FunSuite
import poker.HandStatus
import poker.HandType.FullHouse
import poker.TestHelpers._

final class FullHouseAnalyzerTest extends FunSuite {
  test("analyze") {
    val analyzer = new FullHouseAnalyzer

    assert(analyzer.analyze(fullHouseHand) === (FullHouse and kingKickers))
    assert(analyzer.analyze(fourOfAKindHand) === HandStatus.none)
    assert(analyzer.analyze(twoPairHand) === HandStatus.none)
    assert(analyzer.analyze(highCardHand) === HandStatus.none)
  }
}
