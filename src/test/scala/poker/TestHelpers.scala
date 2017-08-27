package poker

import poker.core.HandType.{HighCard, RoyalFlush, StraightFlush, TwoPair}
import poker.core.{Hand, HandStatus, Kickers}

object TestHelpers {
  // Hand String Arrays
  val royalFlushStrArray = """["TC", "JC", "QC", "KC", "AC"]"""

  // Hands
  val royalFlushHand = Hand("TC", "JC", "QC", "KC", "AC")
  val royalFlushHandMixed = Hand("JC", "TC", "AC", "QC", "KC")

  val straightFlushHand = Hand("8C", "9C", "TC", "JC", "QC")
  val straightFlushHandMixed = Hand("TC", "8C", "QC", "JC", "9C")

  val fourOfAKindHand = Hand("AS", "AD", "2D", "AC", "AH")

  val fullHouseHand = Hand("AS", "KD", "AC", "KS", "AD")

  val flushHand = Hand("8H", "2H", "JH", "TH", "5H")

  val straightHand = Hand("7S", "8H", "9S", "TH", "JC")
  val straightHandMixed = Hand("TH", "7S", "9S", "JC", "8H")

  val threeOfAKindHand = Hand("5H", "TC", "TH", "7D", "TD")

  val twoPairHand = Hand("KC", "KS", "AC", "AS", "6D")

  val onePairHand = Hand("KC", "KS", "AC", "4S", "6D")

  val highCardHand = Hand("AS", "5D", "8H", "TC", "3H")

  // Kickers
  val aceCKicker = Kickers("AC")
  val queenCKicker = Kickers("QC")
  val jackHKicker = Kickers("JH")
  val jackCKicker = Kickers("JC")
  val sixDKicker = Kickers("6D")
  val twoDKicker = Kickers("2D")

  val kingKickers = Kickers("KD", "KS")

  // HandStatuses
  val royalFlushStatus = HandStatus(RoyalFlush)
  val straightFlushWithQueenKickerStatus = HandStatus(StraightFlush, queenCKicker)
  val straightFlushWithTwoKickerStatus = HandStatus(StraightFlush, twoDKicker)
  val twoPairWithSixKickerStatus = HandStatus(TwoPair, sixDKicker)
  val highCardStatus = HandStatus(HighCard, Kickers(highCardHand.sorted))
}
