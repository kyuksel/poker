package poker.handanalyzer

import org.scalatest.FunSuite
import poker.{HandStatus, HandType, Kickers}
import poker.TestHelpers._

final class HighCardAnalyzerTest extends FunSuite {
  test("analyze") {
    val highCardAnalyzer = new HighCardAnalyzer

    assert(highCardAnalyzer.analyze(royalFlush) === HandStatus(HandType.HighCard, Kickers(royalFlush)))
    assert(highCardAnalyzer.analyze(royalFlushMixed) === HandStatus(HandType.HighCard, Kickers(royalFlush)))
    assert(highCardAnalyzer.analyze(straightFlush) === HandStatus(HandType.HighCard, Kickers(straightFlush)))
    assert(highCardAnalyzer.analyze(straightFlushMixed) === HandStatus(HandType.HighCard, Kickers(straightFlush)))
    assert(highCardAnalyzer.analyze(highCard) === highCardStatus)
  }
}
