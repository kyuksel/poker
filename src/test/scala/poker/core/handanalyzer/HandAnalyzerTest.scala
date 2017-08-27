package poker.core.handanalyzer

import org.scalatest.FunSuite
import poker.core.handanalyzer.HandAnalyzer._
import poker.TestHelpers._
import poker.core.HandType._
import poker.core.{Card, HandStatus, Kickers}

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

  test("determineWinners") {
    assert(determineWinners(royalFlushHand, straightFlushHand) === Set(royalFlushHand))
    assert(determineWinners(straightFlushHand, straightFlushHandMixed) === Set(straightFlushHand, straightFlushHandMixed))
  }

  test("bestPossibleHands") {
    val royalFlushPlusOneMoreCard =
      Vector("AD", "2S", "JC", "KD", "7S", "TC", "3H", "AC", "JS", "QC", "KC", "2D").map(Card(_))
    assert(bestPossibleHands(royalFlushPlusOneMoreCard: _*).head.cards === royalFlushHandMixed.cards)
  }
}
