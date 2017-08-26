package poker.handanalyzer

import org.scalatest.FunSuite
import poker.{HandStatus, Kickers}
import poker.HandType._
import poker.handanalyzer.HandAnalyzer.classify
import poker.TestHelpers._

final class HandAnalyzerTest extends FunSuite {
  test("classify") {
    assert(classify(royalFlushHandMixed) === HandStatus(RoyalFlush))
    assert(classify(straightFlushHandMixed) === (StraightFlush and queenCKicker))
    assert(classify(fourOfAKindHand) === (FourOfAKind and twoDKicker))
    assert(classify(fullHouseHand) === (FullHouse and kingKickers))
    assert(classify(flushHand) === (Flush and jackHKicker))
    assert(classify(straightHand) === (Straight and jackCKicker))
    assert(classify(threeOfAKindHand) === (ThreeOfAKind and Kickers(threeOfAKindHand.sorted.cards)))
    assert(classify(twoPairHand) === (TwoPair and Kickers(twoPairHand.sorted.cards)))
    assert(classify(onePairHand) === (OnePair and Kickers(onePairHand.sorted.cards)))
    assert(classify(highCardHand) === (HighCard and Kickers(highCardHand.sorted.cards)))
  }
}
