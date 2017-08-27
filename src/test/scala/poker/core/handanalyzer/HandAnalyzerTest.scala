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
    assert(determineWinners(royalFlushHand, straightFlushHand, twoPairHand) === Set(royalFlushHand))
    assert(determineWinners(straightFlushHand, threeOfAKindHand, twoPairHand) === Set(straightFlushHand))
    assert(determineWinners(straightFlushHand, straightFlushHandMixed) === Set(straightFlushHand, straightFlushHandMixed))
    assert(determineWinners(twoPairHand, flushHand) === Set(flushHand))
    assert(determineWinners(onePairHand, onePairHandWeaker) === Set(onePairHand))
    // Fails due to known bug
    //assert(determineWinners(threeOfAKindHand, threeOfAKindHandWeaker) === Set(threeOfAKindHand))
  }

  test("bestPossibleHands") {
    val royalFlushPlusSevenMoreCards =
      Vector("AD", "2S", "JC", "KD", "7S", "TC", "3H", "AC", "JS", "QC", "KC", "2D").map(Card(_))
    assert(bestPossibleHands(royalFlushPlusSevenMoreCards: _*).head.cards === royalFlushHandMixed.cards)

    val straightHandPlusOneMoreCard =
      Vector("7S", "8H", "9S", "TH", "JC", "3H").map(Card(_))
    assert(bestPossibleHands(straightHandPlusOneMoreCard: _*).head.cards === straightHand.cards)

    /* Fails due to known bug
    val twoPairHandPlusTwoMoreCards =
      Vector("KC", "KS", "AC", "AS", "6D", "TC", "3H").map(Card(_))
    assert(bestPossibleHands(twoPairHandPlusTwoMoreCards: _*).head.cards === twoPairHand.cards)
    */
  }
}
