package poker.handanalyzer

import org.scalatest.FunSuite
import poker.{HandStatus, HandType, Kickers}
import poker.TestHelpers._

final class HighCardAnalyzerTest extends FunSuite {
  test("analyze") {
    val highCardAnalyzer = new HighCardAnalyzer

    assert(highCardAnalyzer.analyze(royalFlushHand) === HandStatus(HandType.HighCard, Kickers(royalFlushHand)))
    assert(highCardAnalyzer.analyze(royalFlushHandMixed) === HandStatus(HandType.HighCard, Kickers(royalFlushHand)))
    assert(highCardAnalyzer.analyze(straightFlushHand) === HandStatus(HandType.HighCard, Kickers(straightFlushHand)))
    assert(highCardAnalyzer.analyze(straightFlushHandMixed) === HandStatus(HandType.HighCard, Kickers(straightFlushHand)))
    assert(highCardAnalyzer.analyze(highCardHand) === highCardStatus)
  }
}
